package org.hoshino9.engine.galtext

typealias Switch = String

interface GalElement {
    fun eval(ctx: GalContext)
    override fun toString(): String
}

data class GalLauncher(val elements: Iterable<GalElement>) {
    fun launch(context: GalContext = GalContext(arrayListOf())): GalContext {
        elements.forEach {
            it.eval(context)
        }

        return context
    }
}

data class GalContext(val ctx: MutableList<Switch>)

data class GalDialog(val talker: String, val text: String) : GalElement {
    override fun eval(ctx: GalContext) {
        println("$talker：「$text」")
        readLine()
    }
}

data class GalSwitch(val switch: MutableList<Switch>) : GalElement {
    operator fun Switch.unaryPlus() {
        switch.add(this)
    }

    override fun eval(ctx: GalContext) {
        var input: String

        do {
            println("Please select:")

            switch.forEachIndexed { index, switch ->
                println("$index. $switch")
            }

            input = readLine().orEmpty().trim()
        } while (input.isBlank())

        ctx.ctx.add(input)
    }
}

interface AbstractGalTextSwitch : GalElement {
    val cond: List<Switch>
    val texts: Iterable<GalElement>
}

data class GalTextSwitch(override val cond: List<Switch>, override val texts: Iterable<GalElement>) :
    AbstractGalTextSwitch {
    override fun eval(ctx: GalContext) {
        if (ctx.ctx.take(cond.size) == cond) {
            texts.forEach {
                it.eval(ctx)
            }
        }
    }
}

data class GalTextSwitchLast(override val cond: List<Switch>, override val texts: Iterable<GalElement>) :
    AbstractGalTextSwitch {
    override fun eval(ctx: GalContext) {
        if (ctx.ctx.takeLast(cond.size) == cond) {
            texts.forEach {
                it.eval(ctx)
            }
        }
    }
}

data class GalSwitchOnce(val switch: List<Pair<String, Iterable<GalElement>>>) : GalElement {
    override fun eval(ctx: GalContext) {
        var input: String

        do {
            println("Please select:")

            switch.forEachIndexed { index, (name, _) ->
                println("$index. $name")
            }

            input = readLine().orEmpty().trim()
        } while (input.isBlank())

        switch[input.toInt()].second.forEach {
            it.eval(ctx)
        }
    }
}

data class GetContext(val block: (GalContext) -> Unit) : GalElement {
    override fun eval(ctx: GalContext) {
        block(ctx)
    }
}

data class GalDSL(val elements: MutableList<GalElement>) {
    data class SayList(val list: MutableList<String>) {
        operator fun String.unaryPlus() {
            list.add(this)
        }
    }

    infix fun String.say(text: String) {
        elements.add(GalDialog(this, text))
    }

    infix fun String.say(block: SayList.() -> Unit) {
        val sl = SayList(arrayListOf())

        sl.block()

        elements.addAll(sl.list.map { GalDialog(this, it) })
    }

    inline fun switchInternal(
        cond: List<Switch>,
        block: GalDSL.() -> Unit,
        constrsuctor: (List<Switch>, Iterable<GalElement>) -> GalElement
    ) {
        val dsl = GalDSL(arrayListOf())

        dsl.block()

        val switch = constrsuctor(cond, dsl.elements)

        elements.add(switch)
    }

    inline fun switch(cond: List<Switch>, block: GalDSL.() -> Unit) = switchInternal(cond, block, ::GalTextSwitch)
    inline fun switchLast(cond: List<Switch>, block: GalDSL.() -> Unit) =
        switchInternal(cond, block, ::GalTextSwitchLast)

    inline fun switch(switch: Switch, block: GalDSL.() -> Unit) = switch(listOf(switch), block)
    inline fun switchLast(switch: Switch, block: GalDSL.() -> Unit) = switchLast(listOf(switch), block)

    inline fun select(block: GalSwitch.() -> Unit) {
        val switch = GalSwitch(arrayListOf())

        switch.block()

        elements.add(switch)
    }

    fun context(block: (GalContext) -> Unit) {
        elements.add(GetContext(block))
    }
}

inline fun gal(block: GalDSL.() -> Unit): GalLauncher {
    val dsl = GalDSL(arrayListOf())

    dsl.block()

    return GalLauncher(dsl.elements)
}
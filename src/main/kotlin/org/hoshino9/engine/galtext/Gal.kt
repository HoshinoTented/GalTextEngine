package org.hoshino9.engine.galtext

typealias Switch = String

interface GalElement {
    fun eval(ctx: GalContext)
    override fun toString(): String
}

data class GalLauncher(val elements: Iterable<GalElement>) {
    fun launch(): GalContext {
        val ctx = GalContext(mutableListOf())

        elements.forEach {
            it.eval(ctx)
        }

        return ctx
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

data class GalTextSwitch(val cond: List<Switch>, val texts: Iterable<GalElement>) : GalElement {
    override fun eval(ctx: GalContext) {
        if (ctx.ctx.take(cond.size) == cond) {
            texts.forEach {
                it.eval(ctx)
            }
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

    inline fun switch(cond: List<Switch>, block: GalDSL.() -> Unit) {
        val dsl = GalDSL(arrayListOf())

        dsl.block()

        val switch = GalTextSwitch(cond, dsl.elements)

        elements.add(switch)
    }

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
package org.hoshino9.engine.galtext

typealias Switch = String

interface GalElement {
    fun eval(ctx: GalContext)
    override fun toString(): String
}

data class GalLauncher(val elements: Iterator<GalElement>) {
    fun launch(): GalContext {
        val ctx = GalContext(emptyList<Switch>().toMutableList())

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
        println("Please select:")

        switch.forEachIndexed { index, switch ->
            println("$index. $switch")
        }

        ctx.ctx.add(readLine().toString())
    }
}

data class GalTextSwitch(val cond: List<Switch>, val texts: Iterator<GalElement>) : GalElement {
    override fun eval(ctx: GalContext) {
        if (ctx.ctx.take(cond.size) == cond) {
            texts.forEach {
                it.eval(ctx)
            }
        }
    }
}

data class GalDSL(val elements: MutableList<GalElement>) {
    infix fun String.say(text: String) {
        elements.add(GalDialog(this, text))
    }

    fun switch(cond: List<Switch>, block: GalDSL.() -> Unit) {
        val dsl = GalDSL(arrayListOf())

        dsl.block()

        val switch = GalTextSwitch(cond, dsl.elements.iterator())

        elements.add(switch)
    }

    fun select(block: GalSwitch.() -> Unit) {
        val switch = GalSwitch(arrayListOf())

        switch.block()

        elements.add(switch)
    }
}

inline fun gal(block: GalDSL.() -> Unit): GalLauncher {
    val dsl = GalDSL(arrayListOf())

    dsl.block()

    return GalLauncher(dsl.elements.iterator())
}
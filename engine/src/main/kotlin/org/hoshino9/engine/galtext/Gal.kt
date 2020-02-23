package org.hoshino9.engine.galtext

interface GalElement<Ctx> {
    fun eval(ctx: GalContext<Ctx>)
    override fun toString(): String
}

data class GalLauncher<Ctx>(val elements: List<GalElement<Ctx>>) {
    fun launch(context: GalContext<Ctx>): GalContext<Ctx> {
        var i = 0

        while (i < elements.size) {
            elements[i].eval(context)

            i += 1
        }

        return context
    }
}

data class GalContext<out Ctx>(val ctx: Ctx)

data class GalDialog<Ctx>(val talker: String, val text: String) : GalElement<Ctx> {
    override fun eval(ctx: GalContext<Ctx>) {
        println("$talker：「$text」")
        readLine()
    }
}

data class GetContext<Ctx>(val block: (GalContext<Ctx>) -> Unit) : GalElement<Ctx> {
    override fun eval(ctx: GalContext<Ctx>) {
        block(ctx)
    }
}

data class GalDSL<Ctx>(val elements: MutableList<GalElement<Ctx>>) {
    data class SayList(val list: MutableList<String>) {
        operator fun String.unaryPlus() {
            list.add(this)
        }
    }

    infix fun String.say(text: String) {
        elements.add(GalDialog(this, text))
    }

    infix fun List<String>.say(text: String) {
        elements.add(GalDialog(joinToString(separator = " & "), text))
    }

    infix fun String.say(block: SayList.() -> Unit) {
        val sl = SayList(arrayListOf())

        sl.block()

        elements.addAll(sl.list.map { GalDialog<Ctx>(this, it) })
    }

    fun withContext(block: (GalContext<Ctx>) -> Unit) {
        elements.add(GetContext(block))
    }
}

inline fun <Ctx> gal(block: GalDSL<Ctx>.() -> Unit): GalLauncher<Ctx> {
    val dsl = GalDSL<Ctx>(arrayListOf())

    dsl.block()

    return GalLauncher(dsl.elements)
}

typealias Context = MutableMap<String, Boolean>

data class GalSelect(val switches: MutableMap<String, String>) : GalElement<Context> {
    override fun eval(ctx: GalContext<Context>) {
        switches.forEach { (key, value) ->
            println("$key -> $value")
        }

        var select: String

        do {
            print("Please select: ")

            select = readLine().orEmpty()
        } while (select.isBlank() || ! switches.containsKey(select))

        ctx.ctx[select] = true
    }
}

data class GalSelectDSL(val map: MutableMap<String, String>) {
    infix fun String.with(name: String) {
        map[this] = name
    }
}

inline fun GalDSL<Context>.select(block: GalSelectDSL.() -> Unit) {
    val dsl = GalSelectDSL(HashMap())

    dsl.block()

    elements.add(GalSelect(dsl.map))
}

fun GalDSL<Context>.switch(key: String, block: GalDSL<Context>.() -> Unit) {
    withContext {
        if (it.ctx.getOrDefault(key, false)) {
            val newContext = GalDSL<Context>(arrayListOf()).apply {
                block()
            }.elements.let { elements ->
                GalLauncher(elements).launch(it)
            }

            it.ctx.clear()
            it.ctx.putAll(newContext.ctx)
        }
    }
}

fun GalDSL<Context>.switchAndRemove(key: String, block: GalDSL<Context>.() -> Unit) {
    withContext {
        if (it.ctx.getOrDefault(key, false)) {
            val newContext = GalDSL<Context>(arrayListOf()).apply {
                block()
            }.elements.let { elements ->
                GalLauncher(elements).launch(it)
            }

            it.ctx.clear()
            it.ctx.putAll(newContext.ctx)
            it.ctx.remove(key)
        }
    }
}
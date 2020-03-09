package org.hoshino9.engine.galtext

import kotlinx.coroutines.flow.*

interface GalElement<Ctx> {
    suspend fun eval(ctx: GalContext<Ctx>)
}

data class GalLauncher<Ctx>(val iter: Flow<GalElement<Ctx>>) {
    suspend fun launch(context: GalContext<Ctx>): GalContext<Ctx> {
        iter.collect {
            it.eval(context)
        }

        return context
    }
}

data class GalContext<out Ctx>(val ctx: Ctx)

data class GalDialog<Ctx>(val talker: String, val text: String) : GalElement<Ctx> {
    override suspend fun eval(ctx: GalContext<Ctx>) {
        println("$talker：「$text」")
        readLine()
    }
}

data class GetContext<Ctx>(val block: suspend (GalContext<Ctx>) -> Unit) : GalElement<Ctx> {
    override suspend fun eval(ctx: GalContext<Ctx>) {
        block(ctx)
    }
}

data class GalDSL<Ctx>(val collector: FlowCollector<GalElement<Ctx>>) {
    data class SayList(val list: MutableList<String>) {
        operator fun String.unaryPlus() {
            list.add(this)
        }
    }

    suspend infix fun String.say(text: String) {
        collector.emit(GalDialog(this, text))
    }

    suspend infix fun List<String>.say(text: String) {
        collector.emit(GalDialog(joinToString(separator = " & "), text))
    }

    suspend infix fun String.say(block: SayList.() -> Unit) {
        val sl = SayList(arrayListOf())

        sl.block()

        collector.emitAll(sl.list.map { GalDialog<Ctx>(this, it) }.asFlow())
    }

    suspend fun withContext(block: suspend (GalContext<Ctx>) -> Unit) {
        collector.emit(GetContext(block))
    }
}

fun <Ctx> gal(block: suspend GalDSL<Ctx>.() -> Unit): GalLauncher<Ctx> {
    return flow<GalElement<Ctx>> {
        GalDSL(this).block()
    }.let {
        GalLauncher(it)
    }
}

typealias Context = MutableMap<String, Boolean>
typealias Switch = MutableMap<String, String>

data class GalSelect(val switches: Switch) : GalElement<Context> {
    override suspend fun eval(ctx: GalContext<Context>) {
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

class GalSelectDSL(val map: Switch) {
    infix fun String.with(name: String) {
        map[this] = name
    }
}

suspend inline fun GalDSL<Context>.select(block: GalSelectDSL.() -> Unit) {
    val dsl = GalSelectDSL(HashMap())

    dsl.block()

    collector.emit(GalSelect(dsl.map))
}

internal suspend fun GalDSL<Context>.switchInternal(
    key: String,
    block: suspend GalDSL<Context>.() -> Unit,
    finally: (GalContext<Context>) -> Unit
) {
    withContext {
        if (it.ctx[key] == true) {
            block()
            finally(it)
        }
    }
}

suspend fun GalDSL<Context>.switch(key: String, block: suspend GalDSL<Context>.() -> Unit) =
    switchInternal(key, block) {}

suspend fun GalDSL<Context>.switchAndRemove(key: String, block: suspend GalDSL<Context>.() -> Unit) =
    switchInternal(key, block) { it.ctx.remove(key) }

suspend fun main() {
    gal<Context> {
        "0" say "0"

        select {
            "1" with "1"
            "2" with "2"
        }

        switch("1") {
            "1" say "1"
        }

        switch("2") {
            "2" say "2"
        }

        "3" say "3"
    }.launch(GalContext(HashMap()))
}
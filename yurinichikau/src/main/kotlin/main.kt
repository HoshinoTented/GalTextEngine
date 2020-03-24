import org.hoshino9.engine.galtext.GalContext

val defaultContext = GalContext(
    hashMapOf(
        tenied_h to true
    )
)

suspend fun main() {
    println("请选择章节：")

    sections.forEachIndexed { i, section ->
        println("$i：${section.name}")
    }

    val selected = readLine().orEmpty().toIntOrNull() ?: throw IllegalArgumentException("WDNMD")
    var section: GalSection? = sections[selected]
    val context = GalContext(HashMap<String, Boolean>())

    while (section != null) {
        section.launcher.launch(context)
        section = section.next(context)
    }
}
import org.hoshino9.engine.galtext.GalContext

fun main() {
    println("请选择章节：")

    sections.forEachIndexed { i, section ->
        println("$i：${section.name}")
    }

    val selected = readLine().orEmpty().toIntOrNull() ?: throw IllegalArgumentException("WDNMD")
    sections.getOrNull(selected)?.launcher?.launch(GalContext(hashMapOf("tenied_h" to true)))
        ?: throw IllegalArgumentException("WDNMD")
}
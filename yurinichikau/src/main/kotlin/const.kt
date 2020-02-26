import org.hoshino9.engine.galtext.Context
import org.hoshino9.engine.galtext.GalLauncher

const val none = "旁白"
const val self = "星野天诚"
const val tented_unknown = "？？"
const val tenied_unknown = "？？？"
const val rorin_unknown = "？？？？"
const val tt = "星野天忆"
const val ti = "星野天怡"
const val rr = "林落铃"
const val boss = "店长"
const val r18: Boolean = true

const val tenied_h = "tenied_h"

interface GalSection {
    val launcher: GalLauncher<Context>
    val name: String
}

val sections = listOf(Opening, Section0)
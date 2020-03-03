import org.hoshino9.engine.galtext.Context
import org.hoshino9.engine.galtext.GalLauncher
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

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

object PropertyNameDelegate : ReadOnlyProperty<Any?, String> {
    override fun getValue(thisRef: Any?, property: KProperty<*>): String {
        return property.name
    }
}

val tenied_h by PropertyNameDelegate
val tented_h by PropertyNameDelegate
val tented_h_refuse by PropertyNameDelegate
val tented_h_lie by PropertyNameDelegate
val tented_h_no_lie by PropertyNameDelegate


interface GalSection {
    val launcher: GalLauncher<Context>
    val name: String
}

val sections = listOf(Opening, Section0)
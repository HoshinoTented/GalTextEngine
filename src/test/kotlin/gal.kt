import org.hoshino9.engine.galtext.gal

const val none = "旁白"
const val self = "星野天诚"
const val tented_unknown = "？？"
const val tenied_unknown = "？？？"
const val tented = "星野天忆"
const val tenied = "星野天怡"

fun main() {
    gal {
        self say "啊啊，又重来了吗。"
        none say "你站在一片虚无中。"
        none say "望着黑色的天空和深渊。"
        self say "到底是为什么呢，又做错了哪里呢……"
        self say "……"
        self say "又是一次轮回啊……"

        none say "孤儿院前"
        self say "在这里吗……"
        none say "走进了孤儿院里"
        none say "一个女孩跑了过来"
        self say "……？"
        "小女孩" say "姐姐"
        none say "你蹲下身子"
        self say "真可爱啊……"
        "小女孩" say "姐姐是来陪我们玩的吗？"
        none say "你笑了笑，摸了摸小女孩的头"
        self say "不是哦……"
        "小女孩" say "是吗……"
        none say "小女孩沮丧地走掉了"
        none say "你望了望四周，在角落发现两个孤单又熟悉的身影"

        tented_unknown say "呜呜……"
        tenied_unknown say "好啦……别哭啦……给，你最喜欢的糖"
        tented_unknown say "姐姐……真的可以吗……？"
        tented_unknown say "这个……应该是姐姐自己的糖吧……"
        tenied_unknown say "说什么呢……我可是姐姐呀！"
        tented_unknown say "呜嗯……"
        none say "小女孩小心翼翼地接过糖，舔了一口"
        tented_unknown say "好甜！……"
        none say "姐姐笑了笑"
        tenied_unknown say "开心起来了吗？"
        tented_unknown say "嗯！"
        none say "你走到两个女孩旁边，姐姐最先注意到了你"
        tenied_unknown say "……？"
        none say "你只是笑了笑"
        tenied_unknown say "那个……请问……有什么事吗？"
        self say "没什么，只是想……"

        select {
            +"问问你们的名字"
            +"领养你们"
        }

        switch(listOf("0")) {
            tenied_unknown say "名字……"
            tenied_unknown say "我叫 0901，这边是我的妹妹，0504"
            self say "……不是那种名字啦"
            tenied_unknown say "那是……？"
            self say "唔……没什么……待会见啦"
            tenied_unknown say "嗯……"

            tenied_unknown say "诶……？待会……？"
        }

        switch(listOf("1")) {
            tenied_unknown say "领……领养？"
        }
    }.launch()
}
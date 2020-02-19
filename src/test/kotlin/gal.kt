import org.hoshino9.engine.galtext.gal
import org.hoshino9.engine.galtext.removeLast

const val none = "旁白"
const val self = "星野天诚"
const val tented_unknown = "？？"
const val tenied_unknown = "？？？"
const val rorin_unknown = "？？？？"
const val tt = "星野天忆"
const val ti = "星野天怡"

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
            + "问问你们的名字"
            + "领养你们"
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

        context {
            it.ctx.removeAt(it.ctx.lastIndex)
        }


        "教师" say "0901，0504"
        none say "这里的老师大声的呼唤那两个女孩"
        none say "姐姐拉着妹妹跑了过来"
        tenied_unknown say "唔……老师，怎么了？"
        "教师" say "这里有要领养你们的人"
        tenied_unknown say "啊……你是刚才的姐姐……"
        tented_unknown say "领养……姐姐……有人愿意领养我们了吗……"
        none say "姐姐摸了摸妹妹的头"
        tenied_unknown say "嗯！……"

        none say "家中"
        tenied_unknown say "唔……打扰了……"
        self say "先坐会儿吧，我去倒茶"
        tenied_unknown say "诶……"

        none say "你把茶递过去"
        tenied_unknown say "谢……谢谢！……"
        self say "……没什么需要谢谢的啦"
        tenied_unknown say "那个……"
        self say "嗯？"
        tenied_unknown say "为什么……要收留我们呢？"

        select {
            + "没什么"
            + "因为你们可爱"
        }

        switch(listOf("0")) {
            tenied_unknown say "是吗……不过我还是很感谢你的……"
        }

        switch(listOf("1")) {
            tenied_unknown say "可……可爱……是吗……"
            none say "女孩笑了笑"
            tenied_unknown say "总之……很感谢你收留我们！"
        }

        context {
            it.ctx.removeAt(it.ctx.lastIndex)
        }

        self say "对了，你们还没有名字呢"
        tenied_unknown say "诶……名字……"
        self say "这样吧，你叫星野天怡，你的妹妹就叫星野天忆吧"
        ti say "唔……嗯……"
        self say "名字是按照我的名字改出来的啦，我叫星野天诚哦"

        none say "浴场"
        ti say "哇！好大的浴场……不过从外面看起来……房子没有这么大的呀……"
        self say "这是隙间魔法啦"
        ti say "隙间魔法……？"
        self say "以后再慢慢说啦，先把衣服脱掉吧，泡泡澡"
        ti say "诶……嗯……"
        none say "天怡脱掉自己的衣服后帮天忆脱掉了衣服"

        ti say "好温暖……从来都没有在这么温暖的澡池里泡过澡……"
        self say "喜欢就好"
        none say "你笑了笑"
        self say "以后，你们就是我的妹妹了哦"
        ti say "嗯……"
        self say "嗯……天忆是不是有点怕生呀？"
        ti say "啊……是的……在孤儿院里只有我陪她……"
        self say "是吗……"
        none say "你走到天忆身边"
        ti say "呜诶！……"

        select {
            + "摸摸头"
        }

        context {
            it.ctx.removeLast()
        }

        none say "你摸了摸天忆的头"
        tt say "呜……"
        tt say "姐……姐姐……天诚姐姐……"
        self say "嗯，我在哦"
        tt say "呜……谢谢收留我们……"
        self say "……我其实不太喜欢听到谢谢呢"
        tt say "啊……对不起……"
        self say "“对不起” 也是哦"
        tt say "呜……"
        self say "好啦，好好放松一下吧"

        none say "你抬头望着天花板"
        self say "这次……又能有多久呢……"
        ti say "唔？"
        self say "啊……没什么，我先去拿点东西"

        self say "铛铛"
        none say "双手各拿着洛丽塔"
        ti say "这……这是……"
        self say "给你们的新衣服哦"
        ti say "诶……"

        none say "卧室，镜子前"
        self say "很合适呢"
        ti say "嗯……刚刚好……"
        none say "你笑了笑"
        self say "有什么想要买的吗？待会一起出去逛一逛商场……"
        ti say "诶……没有……"
        self say "是吗……"
        ti say "姐姐收留我们，我们就已经很感激了……"
        ti say "所以……不用在我们身上花这么多心思的……"
        self say "那可不行，你们可都是我的妹妹"
        ti say "唔……"
        none say "天怡看向旁边的天忆"
        ti say "天忆有什么想买的吗？"
        tt say "唔……想买好多好多糖果！"
        self say "吃太多糖可是不行的哦"
        tt say "唔……那……"
        self say "嘛，没关系的啦，天忆要好多糖的话就买啦"
        tt say "真的吗！……"
        self say "当然是真的"

        none say "路上"
        ti say "……"
        self say "……"
        self say "怎么了？"
        ti say "诶！没……"
        none say "天怡看起来很紧张的样子"
        ti say "只是……之前有迷路过一次……所以有点怕……跟丢……之类的……"
        self say "是吗……那待会回家我给你做个东西哦"
        ti say "诶……"

        none say "商场"
        self say "这些就够了吗？"
        none say "天忆手里捧着一小堆糖果"
        tt say "嗯！"
        self say "嗯……那我也买一些糖果吧"
        none say "你抓起了一大把糖果，放进了袋子里"
        self say "好啦，还要再买点……食材来着……"
        ti say "啊……那个姐姐……"
        self say "嗯？"
        ti say "我会做饭……所以可以帮上一点忙……"
        none say "你笑了笑"
        self say "嗯"

        self say "天怡有什么想吃的吗？"
        ti say "诶……没有……"
        self say "是吗……在孤儿院一般吃什么呢？"
        ti say "唔……白粥和白饭……有的时候吃面……"
        self say "那……做面吧"
        ti say "诶……嗯……"

        none say "餐桌上"
        ti say "唔……吃饭的时候就不要吃糖啦……"
        tt say "诶……唔……好吧……"
        none say "天忆恋恋不舍地把糖放下"
        self say "吃完饭，待会跟我讲讲孤儿院里的故事哦"
        ti say "嗯"

        none say "卧室"
        none say "天忆似乎已经睡着了"
        ti say "天忆很胆小，很怕生……所以在孤儿院里只跟我说话来着呢……"
        ti say "吃饭也是……睡觉也是……无论什么事情都想和我在一起"
        self say "……"
        ti say "就这样照顾了很长一段时间……"
        self say "嗯……一开始你们是怎么被收留在孤儿院里的？"
        ti say "啊……从记事起我们就已经在孤儿院里了"
        self say "是吗……那孤儿院里有发生什么有趣的事情吗？"
        ti say "有趣的事情……"
        ti say "……"
        self say "啊……"
        ti say "没有……很多朋友都被领养走了……只有我和天忆一直在孤儿院里……"
        self say "多久了？"
        ti say "一年……一年半吧……"
        self say "是吗"
        ti say "所以……所以姐姐能领养我们……我们真的很开心……"
        self say "我知道的"

        select {
            + "抱住天怡"
            + "摸摸天怡的头"
        }

        switch(listOf("0")) {
            none say "你抱住了天怡"
            ti say "诶！……"
            self say "不过不用担心了，接下来，你们会有全新的生活哦……"
            ti say "嗯……不过……也有点害怕未知的未来呢……"
            self say "不用怕哦……"
            ti say "……嗯！"
        }

        switch(listOf("1")) {
            none say "你摸了摸天怡的头"
            ti say "……"
        }

        context {
            it.ctx.removeLast()
        }

        self say "啊，差点忘记了，还要给你做魔法道具呢"
        ti say "诶……魔法道具……"

        none say "你递给天怡一个魔法戒指"
        ti say "啊……这个是……"
        self say "可以心灵沟通的魔法道具哦"
        ti say "谢谢姐姐……"
        self say "唔……我不是说过我不喜欢听到谢谢吗……"
        ti say "啊……那……我收下了……"
        self say "嗯"
        ti say "唔……可以给天忆也做一个吗？"
        self say "好，等等哦"
        ti say "嗯！……"

        none say "卧室"
        none say "天忆在床上睡着，十分安静"
        none say "你把戒指戴在天忆左手的无名指上"
        none say "接着抓住天怡的右手"
        ti say "诶……"
        self say "这样，很不错吧？"
        ti say "……嗯……"

        none say "书房"
        self say "伸出手"
        none say "天怡伸出手"
        none say "你握住天怡的小手"
        self say "……"
        ti say "……？"
        self say "天怡知道自己是什么魔法使吗？"
        ti say "唔……老师跟我说过……好像是……星曜？"
        self say "嗯……那这本书你看一下吧"
        none say "你从书架上拿下一本书"
        ti say "这是……"
        self say "星曜魔法使的必备书籍哦"
        ti say "唔……嗯……"

        self say "天忆还没醒啊……"
        ti say "天忆是那种一睡就睡很久的类型啦，而且睡的也很深……"
        self say "是吗"

        none say "夜晚"
        none say "三人坐在屋顶上望着璀璨的星空"
        self say "今天是值得纪念的日子呢"
        ti say "啊……嗯！"
        tt say "呜……姐姐……天忆好困……"
        ti say "那就在我怀里躺一会儿吧"
        tt say "呜嗯……"
        self say "睡太多可是不太好的呢"
        none say "天忆没有说话，好像已经睡着了"
        self say "……"

        none say {
            + "无论怎样，这都是一个好的开始"
            + "天诚心里如此想着"
            + "晚安，这个世界"
            + "就这样画下今天的句点吧"
            + "2003 年 5 月 4 日"
        }
    }.launch()
}
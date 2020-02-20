import org.hoshino9.engine.galtext.*

/**
 * 第 0 章 初梦
 */
fun main() {
    gal {
        self say "再见啦，天忆要乖一点哦"
        tt say "嗯！……天忆……不会让姐姐们担心的……"
        none say "天怡摸了摸天忆的头"
        ti say "姐姐不用太担心啦，快去工作吧……"
        self say "嗯，我回来之前天怡就先做点吃的垫一垫肚子吧"
        self say "回来的时候，我会给你们带好吃的哦"
        ti say "嗯……知道啦……"
        self say "那我走了哦"
        ti say "嗯"

        none say "天诚出发去工作了"
        none say "工作的地点是咖啡店"
        none say "虽说是咖啡店，但其实也还售卖一些西洋料理"
        none say "比如……"

        boss say "天诚，今天这么早吗"
        self say "嗯……对了，给我做两份意面吧"
        boss say "嗯，不过今天……"
        self say "我……我知道的啦……"
        boss say "好，那你先帮我看一下店"
        self say "嗯……"
        none say "比如意面，还有牛排"
        self say "啊……欢迎光临"

        boss say "天诚"
        self say "啊……"
        none say "${boss}拿着两个盒子"
        self say "好……"
        none say "天诚接过盒子"
        boss say "最近发生什么事了？"
        self say "诶？"
        boss say "以前可从没见过你要买东西回家的"
        self say "嘛……家里来了两个孩子啦"
        boss say "噢……"
        self say "……我去工作了……"
        boss say "嗯"

        if (r18) {
            // TODO: R18

            boss say "给，休息一下吧"
            none say "${boss}递过一杯魔力水给天诚"
            self say "啊……嗯……"
            none say "天诚的大腿上还残留着不明的白色液体"
            self say "那个……冰晶……"
            boss say "我去拿"
            self say "嗯……"

            none say "为什么会是这样子呢"
            none say "为了生计吧"
            none say "可是我需要担心这一些吗"
            none say "还是……"
        }

        none say "天诚打开大门"
        tt say "姐姐！"
        none say "天忆跑到天诚身边"
        none say "天诚摸了摸天忆的头"
        self say "天怡呢？"
        tt say "唔……姐姐在楼上看书……"
        self say "是吗……"
        tt say "姐姐，吃的！"
        self say "嗯，在这里啦"
        none say "天诚把手中的袋子递给天忆"
        self say "不过得等天怡下来一起吃哦"
        tt say "嗯！"

        ti say "这是……"
        self say "意大利面，吃过吗？"
        none say "天怡摇摇头"
        self say "试试看吧？"
        ti say "嗯……"
        self say "怎么样？"
        ti say "很好吃呢"
        self say "那就多吃点啦……"
        ti say "那个……"
        self say "嗯？"
        ti say "姐姐有时间……能不能带我去姐姐工作的地方看看……？"
        self say "嗯……可以呀"

        none say "书房"
        self say "……"
        self say "稍微休息一下吧？"
        ti say "……诶？"
        self say "我说，天怡稍微休息一下吧？毕竟看了那么久的书"
        ti say "啊……嗯……"
        none say "天怡放下手中的书本"
        self say "不过，天怡很喜欢看书呢"
        none say "天怡笑了笑"
        self say "孤儿院有书可以看吗？"
        ti say "唔……孤儿院倒是没有图书馆，但是有很多人来送过书，我也就看了一些……"
        self say "一般看什么书呢？"
        ti say "有什么就看什么啦……"
        self say "是吗……"
        self say "那天忆呢？"
        ti say "天忆的话……好像不是很喜欢看书……一看书就会睡着"
        self say "嗯……不学习可是不行的呀……"
        ti say "……"
        ti say "话说姐姐从刚才一直在忙什么呢？"
        self say "画法阵"
        ti say "诶……姐姐好厉害……"
        self say "以后天怡也需要学画法阵的啦"
        ti say "唔……听说很难……"
        self say "没有那么难啦……"
        ti say "嗯……"

        none say "晚上，咖啡店"
        ti say "打扰了……"
        self say "找个地方坐着吧"
        boss say "天诚，你来啦"
        self say "嗯……"
        boss say "这几位是……"
        self say "我的妹妹们，不准打馊主意"
        boss say "好好……"
        self say "不过，她们很喜欢你做的意大利面，所以能再做两份吗？"
        boss say "好"

        ti say "唔……上次的意大利面就是在这里买的吗……？"
        self say "嗯"
        ti say "我也想学学……做意大利面呢……"
        none say "天诚摸了摸天怡的头"
        ti say "唔……"

        boss say "面来啦"
        tt say "呜哇……好香……"
        boss say "嗯，快尝尝吧"
        none say "天忆早就握好叉子蓄势待发了"
        self say "诶，吃慢点……"
        tt say "唔嗯！……"

        if (r18) {
            none say "店长的房间"

            select {
                + "不做"
                + "做"
            }

            switch("0") {
                self say "今天……可以不做吗……"
                boss say "嗯……"
                self say "……"
                boss say "行吧，看在可爱妹妹的份上"
                self say "……不准动她们！"
                boss say "我知道的啦"
                self say "那我先出去了"
                boss say "嗯"
            }

            switch("1") {
                // TODO R18
            }

            context {
                it.ctx.removeLast()
            }
        }

        self say "对了，能不能教教她们怎么做意大利面？"
        boss say "想学吗……我这里有本手册，可以拿去看看"
        self say "啊……"
        none say "天诚接过手册"
        boss say "不用还了，就当是我送给她们的见面礼"
        self say "嗯……"

        none say "厨房"
        self say "好啦……我不会怪你的……"
        ti say "呜呜……可是……"
        none say "现场一片狼藉"
        tt say "唔……姐姐……"
        none say "天忆摸着天怡的头"
        tt say "好孩子不哭……"
        ti say "呜……"
        self say "天忆把天怡拉到卧室去吧，我收拾一下厨房"
        tt say "嗯！……"
        tt say "姐姐……走吧……"

        none say "到底发生了什么呢？"
        none say "不久前……"

        ti say "唔……然后是开火……"
        self say "嗯"
        ti say "姐姐……万一我搞砸了怎么办……"
        self say "诶？嗯……搞砸了就再来一次嘛……"
        ti say "唔……嗯！"
        ti say mahou("火灵", "飞升")
        none say "天怡施展魔法，但……"
        self say "等！……"
        none say "轰！"
        none say "过大的魔力输出把灶台引爆了"
        none say "天诚也赶紧抱住天怡，背对着灶台"

        none say "事后"

        self say "啊……果然还是得加防护措施才行……"
        tt say "姐姐……？"
        self say "诶，天忆？不去照顾天怡吗？"
        tt say "姐姐说要一个人待一会儿……"
        self say "是吗……"
        tt say "姐姐的伤……不要紧吧……"
        none say "天诚的背后被魔法伤到了"
        self say "不要紧的，天忆不用担心啦"
        tt say "唔嗯……天忆也来帮姐姐收拾吧！"
        self say "嗯"
        self say "天忆是乖孩子呢"
        tt say "诶……嘻嘻……"

        none say "卧室"
        none say "天诚敲了敲门"
        self say "天怡，我进来咯"
        none say "天怡似乎已经在床上睡着了"
        self say "……"
        none say "天诚坐在床上，看着熟睡的天怡"
        self say "可怜的孩子……"
        none say "天诚想着"
        none say "因为一点小失误，却变得如此自责"
        none say "一定是有什么过往吧"
        ti say "姐姐……呜……"
        self say "我在这里哦"
        ti say "……"
        self say "啊……是梦话吗……"

        ti say "呜……啊！……"
        ti say "姐姐！……对……对不起……"
        none say "天怡醒来，第一眼就看到在她身边的天诚"
        self say "……没关系的啦，我没有怪天怡……"
        ti say "呜……请惩罚天怡吧……"
        self say "诶……惩罚……？"
        ti say "呜嗯……"

        if (r18) {
            none say "天怡慢慢解开自己的衣服"
            none say "洁白的肌肤展现在天诚面前"

            ti say "姐姐……请惩罚我把……"

            select {
                + "惩罚"
                + "不惩罚"
            }

            switchLast("0") {
                // TODO R18
            }
        }

        none say "天诚摸了摸天怡的头"
        self say "傻孩子……我可不忍心惩罚你哦……"
        ti say "可是……我做错了事情……"
        self say "每个人都会犯错，包括我"
        self say "犯错并不可怕，可怕的是犯错之后没有反省和承认错误"
        self say "天怡已经反省和承认过错误了吧？"
        ti say "嗯……"
        self say "那天怡就是好孩子哦"
        self say "呐，这个给你"
        ti say "这个是……"
        self say "是天怡反省的奖励哦"
        none say "天诚递给天怡一颗糖"
        ti say "嗯……谢谢姐姐……"
        self say "嗯"

        if (r18) {
            switchLast("1") {
                none say "天诚帮天怡重新穿好了衣服"
            }
        }
    }.launch()
}
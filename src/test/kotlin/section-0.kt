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
    }
}
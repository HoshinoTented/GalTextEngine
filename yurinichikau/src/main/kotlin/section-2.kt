import org.hoshino9.engine.galtext.*

object Section3 : GalSection {
    override val name: String
        get() = "忆梦·心缘"

    override val launcher: GalLauncher<Context>
        get() = gal {
            switch(tenied_h) {
                self say "等等……天忆……"
                none say "天忆扑倒在天诚身上"
                none say "而在她们身边的则是熟睡的天怡"
                tt say "呜……姐姐……"
                tt say "天忆……受不了了……"
                self say "那至少……去浴场吧……天怡在这边的话……"
                tt say "姐姐……姐姐同意了？"
                self say "……"

                select {
                    tented_h_refuse with "拒绝天忆，用魔法解决"
                    tented_h with "同意"
                }

                none say "浴场"

                switch(tented_h_refuse) {
                    self say "来，先闭上眼睛"
                    tt say "呜诶……？"
                    self say "听话"
                    tt say "唔……嗯！"
                    self say "……抱歉"

                    none say "天诚把手放在天忆头上"
                    none say "突然，魔光闪现，天忆晕倒在天诚怀里"

                    self say "果然……这种事情，天忆还是不要知道的比较好呢……"

                    none say "过了一段时间……"
                    tt say "呜……头好晕……"
                    self say "醒了吗？"
                    tt say "诶……姐姐……唔……"
                    self say "怎么了？"
                    tt say "脑袋……有点晕晕的……而且好像忘掉了什么东西……"
                    self say "啊……"

                    select {
                        tented_h_lie to "欺骗天忆"
                        tented_h_no_lie to "告诉天忆真相"
                    }

                    switch(tented_h_lie) {
                        self say "刚才天忆泡澡晕过去了，不过还好，很快就醒过来了呢"
                        tt say "唔……好像……是这样的样子……"
                        self say "好啦，擦擦身子然后穿好衣服去睡觉吧……"
                        tt say "嗯！"
                    }

                    switch(tented_h_no_lie) {
                        self say "天忆……还记得吗？"
                        tt say "唔……记得什么？"
                        self say "天忆是不是……看到了我和天怡做那种事情呢？"
                        tt say "唔……诶……嗯！……"
                        self say "不过……这种事情对天忆还太早了一些啦……"
                        tt say "诶……天忆不可以做吗……"
                        self say "大概……现在不可以吧？"
                        tt say "呜嗯……对不起……"
                        self say "都说了我不喜欢对不起啦……"
                        tt say "呜啊……忘记了……"
                        self say "好啦，先去睡觉吧"
                        tt say "嗯……"
                    }
                }

                switch(tented_h) {
                    // TODO
                }
            }

            none say {
                + "又是一个新的早晨"
                + "窗外的树上站着几只鸟儿，欢快地歌唱着"
                + "天怡和天忆还躺在床上熟睡着"
            }

            none say "厨房"
            self say "呼。。今天的早餐就吃点中式面吧"

            none say "过了许久"
            self say "还没醒吗……"

            none say "卧室"
            self say "起！"
            self say "起！床！"
            self say "起！床！啦！"
            listOf(ti, tt) say "呜哇！！！！！！！！！！！！！！！！！"
            self say "真是的，时候不早了噢"
            tt say "呜……"
            ti say "嗯……"
            self say "早餐已经做好了，收拾好就准备下来吃早餐吧"
            ti say "知道了"

            tt say "嗯~好吃！"
            self say "喜欢就好"

            none say "早餐过后，天诚带着她们出门"
            ti say "唔……姐姐，今天要去哪里呀？"
            self say "带你们去看看学习的地方"
            ti say "学习……学校？"
            self say "嗯"
            ti say "诶……真的……真的可以去上学吗？"
            self say "那当然啦，虽然说我应该不会和你们分开，但是以防万一嘛"
            ti say "唔……所以是去学防身的东西……？"
            self say "也不全是啦，只是学魔法的内容而已，有些也可以拿来玩的哦"
            ti say "嗯……"
        }
}
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
        }
}
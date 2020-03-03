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
                }

                switch(tented_h) {
                    // TODO
                }
            }
        }
}
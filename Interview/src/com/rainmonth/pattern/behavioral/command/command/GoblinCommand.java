package com.rainmonth.pattern.behavioral.command.command;

import com.rainmonth.pattern.behavioral.command.army.Goblin;

/**
 * 哥布林对应的命令
 */
public class GoblinCommand implements Command {

    private final Goblin goblin;

    public GoblinCommand(Goblin goblin) {
        this.goblin = goblin;
    }

    @Override
    public void attack() {
        goblin.attack();
    }
}

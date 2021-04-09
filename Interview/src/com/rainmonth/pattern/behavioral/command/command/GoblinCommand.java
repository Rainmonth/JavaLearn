package com.rainmonth.pattern.behavioral.command.command;

import com.rainmonth.pattern.behavioral.command.army.Goblin;

public class GoblinCommand implements Command {

    private Goblin goblin;

    public GoblinCommand(Goblin goblin) {
        this.goblin = goblin;
    }

    @Override
    public void attack() {
        goblin.attack();
    }
}

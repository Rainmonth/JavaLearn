package com.rainmonth.pattern.behavioral.command.command;

import java.util.List;

/**
 * 这个可以看成组合模式的一个应用，本身由多个Command组成
 */
public class MircoCommand implements Command {
    private final List<Command> commands;

    public MircoCommand(List commands) {
        this.commands = commands;
    }

    @Override
    public void attack() {
        for (int i = 0; i < commands.size(); i++) {
            commands.get(i).attack();
        }
    }
}

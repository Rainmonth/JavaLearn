package com.rainmonth.pattern.behavioral.command.command;

import com.rainmonth.pattern.behavioral.command.army.Warrior;

/**
 * 武士对应的命令
 */
public class WarriorCommand implements Command {

	private final Warrior warrior;

	public WarriorCommand(Warrior warrior) {
		this.warrior = warrior;
	}

	@Override
	public void attack() {
		warrior.attack();
	}
}

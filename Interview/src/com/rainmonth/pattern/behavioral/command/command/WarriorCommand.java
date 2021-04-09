package com.rainmonth.pattern.behavioral.command.command;

import com.rainmonth.pattern.behavioral.command.army.Warrior;

public class WarriorCommand implements Command {

	private Warrior warrior;

	public WarriorCommand(Warrior warrior) {
		this.warrior = warrior;
	}

	@Override
	public void attack() {
		warrior.attack();
	}
}

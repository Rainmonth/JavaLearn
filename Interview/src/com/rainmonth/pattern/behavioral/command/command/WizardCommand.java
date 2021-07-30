package com.rainmonth.pattern.behavioral.command.command;

import com.rainmonth.pattern.behavioral.command.army.Wizard;

/**
 * 术士对应的命令
 */
public class WizardCommand implements Command {

	private final Wizard wizard;

	public WizardCommand(Wizard wizard) {
		this.wizard = wizard;
	}

	@Override
	public void attack() {
		wizard.spell();
	}
}

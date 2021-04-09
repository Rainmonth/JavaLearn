package com.rainmonth.pattern.behavioral.command.command;

import com.rainmonth.pattern.behavioral.command.army.Wizard;

public class WizardCommand implements Command {

	private Wizard wizard;

	public WizardCommand(Wizard wizard) {
		this.wizard = wizard;
	}

	@Override
	public void attack() {
		wizard.spell();
	}
}

package com.rainmonth.pattern.structural.decorator;

public abstract class CondimentDecorator implements Burger {

	protected Burger burger;

	public CondimentDecorator(Burger burger) {
		this.burger = burger;
	}

}

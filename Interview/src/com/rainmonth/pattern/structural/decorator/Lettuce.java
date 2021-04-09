package com.rainmonth.pattern.structural.decorator;

public class Lettuce extends CondimentDecorator {

	public Lettuce(Burger burger) {
		super(burger);
	}

	@Override
	public String getDescription() {
		return burger.getDescription() + ", Lettuce";
	}

	@Override
	public float cost() {
		return burger.cost() + 0.7f;
	}

}

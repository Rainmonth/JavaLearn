package com.rainmonth.pattern.structural.decorator;

public class WhopperBurger implements Burger {

	public String getDescription() {
		return "whopper";
	}

	@Override
	public float cost() {
		return 1.0f;
	}
}

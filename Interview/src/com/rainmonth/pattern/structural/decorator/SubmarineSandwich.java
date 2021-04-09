package com.rainmonth.pattern.structural.decorator;

public class SubmarineSandwich implements Burger {

	@Override
	public String getDescription() {
		return "submarine sandwich";
	}

	@Override
	public float cost() {
		return 1.10f;
	}

}

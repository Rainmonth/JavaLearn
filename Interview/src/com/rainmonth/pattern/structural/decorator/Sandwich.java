package com.rainmonth.pattern.structural.decorator;

public class Sandwich implements Burger {

	public String getDescription() {
		return "sandwich";
	}

	@Override
	public float cost() {
		return 0.9f;
	}

}

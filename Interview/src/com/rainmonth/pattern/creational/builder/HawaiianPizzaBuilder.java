package com.rainmonth.pattern.creational.builder;

public class HawaiianPizzaBuilder extends PizzaBuilder {
	public void buildDough()   { pizza.dough = "cross"; }
	public void buildSauce()   { pizza.sauce = "mild"; }
	public void buildTopping() { pizza.topping = "ham + pineapple"; }
}

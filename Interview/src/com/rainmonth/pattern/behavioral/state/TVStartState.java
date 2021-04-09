package com.rainmonth.pattern.behavioral.state;

/**
 * Created by karenlin on 2015/4/14.
 */
public class TVStartState implements State {
	@Override
	public void doAction() {
		System.out.println("TV is turned ON");
	}
}

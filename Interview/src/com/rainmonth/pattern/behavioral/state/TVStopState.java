package com.rainmonth.pattern.behavioral.state;

/**
 * ζεηΆζ
 */
public class TVStopState implements State {
	@Override
	public void doAction() {
		System.out.println("TV is turned OFF");
	}
}

package com.rainmonth.pattern.behavioral.state;

/**
 * 暂停状态
 */
public class TVStopState implements State {
	@Override
	public void doAction() {
		System.out.println("TV is turned OFF");
	}
}

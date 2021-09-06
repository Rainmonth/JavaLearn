package com.rainmonth.pattern.behavioral.state;

/**
 * 状态模式Client
 */
public class TVRemote {
	public static void main(String[] args) {

		TVContext context = new TVContext();

		context.setState(new TVStartState());
		context.doAction();

		context.setState(new TVStopState());
		context.doAction();

	}
}

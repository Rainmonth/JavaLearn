package com.rainmonth.pattern.behavioral.state;

/**
 * 持有状态引用的上下文环境
 * 通过它来响应不同状态的不同行为，实际上调用的时该状态所对应的行为
 */
public class TVContext {
    private State state;

    public void setState(State state) {
        this.state = state;
    }

    public void doAction() {
        this.state.doAction();
    }
}

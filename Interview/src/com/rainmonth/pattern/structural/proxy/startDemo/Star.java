package com.rainmonth.pattern.structural.proxy.startDemo;

/**
 * 明星对象
 * @author randy
 * @date 2021/6/1 9:59 上午
 */
public class Star implements IAcceptAnnounce {
    @Override
    public void productProxy(long proxyPrice) {
        System.out.println("productProxy");
    }

    @Override
    public void danceShow(long danceShowPrice) {
        System.out.println("danceShow");
    }

    @Override
    public void singShow(long singShowPrice) {
        System.out.println("singShow");
    }
}

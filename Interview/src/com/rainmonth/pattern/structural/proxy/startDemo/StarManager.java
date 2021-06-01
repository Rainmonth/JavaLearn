package com.rainmonth.pattern.structural.proxy.startDemo;

/**
 * 经纪人对象
 * @author randy
 * @date 2021/6/1 10:00 上午
 */
public class StarManager implements IAcceptAnnounce {

    private Star mStar;

    public StarManager(Star star) {
        this.mStar = star;
    }

    @Override
    public void productProxy(long proxyPrice) {
        if (proxyPrice < 200000) {
            System.out.println("小于20万的产品代言不接！");
            return;
        }

        mStar.productProxy(proxyPrice);
    }

    @Override
    public void danceShow(long danceShowPrice) {
        if (danceShowPrice < 10000) {
            System.out.println("小于10000元的演出不接！");
            return;
        }
        mStar.danceShow(danceShowPrice);
    }

    @Override
    public void singShow(long singShowPrice) {
        if (singShowPrice < 5000) {
            System.out.println("小于5000元的单曲费用不接！");
            return;
        }
        mStar.singShow(singShowPrice);
    }
}

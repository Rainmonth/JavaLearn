package com.rainmonth.pattern.structural.proxy.startDemo;

/**
 * @author randy
 * @date 2021/6/1 10:06 上午
 */
public class StartClient {
    public static void main(String[] args) {
        Star star = new Star();

        StarManager starManager = new StarManager(star);
        // 一个300000的产品代言
        starManager.productProxy(180000);

        // 一个8000的舞蹈表演
        starManager.danceShow(10000);

        // 一个6000的歌曲演唱
        starManager.singShow(6000);
    }
}

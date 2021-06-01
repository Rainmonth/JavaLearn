package com.rainmonth.pattern.structural.proxy.startDemo;

/**
 * 接受的通告类型
 * @author randy
 * @date 2021/6/1 10:02 上午
 */
public interface IAcceptAnnounce {
    /**
     * 产品形象代言
     * @param proxyPrice 代言费用
     */
    void productProxy(long proxyPrice);

    /**
     * 舞蹈表演
     * @param danceShowPrice 舞蹈表演费用
     */
    void danceShow(long danceShowPrice);

    /**
     * 演唱歌曲
     * @param singShowPrice 演唱歌曲费用
     */
    void singShow(long singShowPrice);
}

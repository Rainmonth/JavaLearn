package com.rainmonth.pattern.structural.adapter.demo;

/**
 * @author randy
 * @date 2021/7/16 5:58 下午
 */
public class Pig implements CrawlAnimal{
    @Override
    public String crawlKindName() {
        return "My kind is Pig";
    }

    @Override
    public void crawl() {
        System.out.println("I can crawl");
    }
}

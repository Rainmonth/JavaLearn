
package com.rainmonth.pattern.behavioral.observer;

/**
 * 只关注娱乐新闻
 */
public class GuavaDailyNewsDisplay implements Observer {
    private String entertainmentNews;

    @Override
    public void update(String headlineNews, String sportsNews, String financeNews, String entertainmentNews) {
        this.entertainmentNews = entertainmentNews;
        display();
    }

    public void display() {
        System.out.println("GuavaDaily entertainmentNews: " + entertainmentNews);
    }
}

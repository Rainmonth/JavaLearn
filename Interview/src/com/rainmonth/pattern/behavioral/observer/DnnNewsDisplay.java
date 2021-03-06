
package com.rainmonth.pattern.behavioral.observer;

/**
 * 关注头条、体育和财经新闻，不关注娱乐新闻
 */
public class DnnNewsDisplay implements Observer {
    private String headlineNews;
    private String sportsNews;
    private String financeNews;

    @Override
    public void update(String headlineNews, String sportsNews, String financeNews, String entertainmentNews) {
        this.headlineNews = headlineNews;
        this.sportsNews = sportsNews;
        this.financeNews = financeNews;
        display();
    }

    public void display() {
        System.out.println("Dnn headlineNews: " + headlineNews);
        System.out.println("Dnn sportsNews: " + sportsNews);
        System.out.println("Dnn finaceNews: " + financeNews);
    }
}

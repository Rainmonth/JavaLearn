package com.rainmonth.pattern.behavioral.strategy.book;

/**
 * Created by RandyZhang on 2017/10/19.
 */
public class BookEntity {
    private MemberStrategy bookSaleStrategy;

    public BookEntity(MemberStrategy bookSaleStrategy) {
        this.bookSaleStrategy = bookSaleStrategy;
    }

    public double getBookActualSalePrice(double bookSalePrice) {
        if (null != bookSaleStrategy) {
            return bookSaleStrategy.calculateActualSalePrice(bookSalePrice);
        } else {
            System.out.println("没有对应的销售策略");
            return 0d;
        }
    }
}

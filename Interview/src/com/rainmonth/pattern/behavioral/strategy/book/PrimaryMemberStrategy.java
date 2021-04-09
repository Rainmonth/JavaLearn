package com.rainmonth.pattern.behavioral.strategy.book;

/**
 * 初级会员销售策略
 * Created by RandyZhang on 2017/10/19.
 */
public class PrimaryMemberStrategy implements MemberStrategy {
    @Override
    public double calculateActualSalePrice(double bookSalePrice) {
        System.out.println("初级会员没有折扣");
        return bookSalePrice;
    }
}

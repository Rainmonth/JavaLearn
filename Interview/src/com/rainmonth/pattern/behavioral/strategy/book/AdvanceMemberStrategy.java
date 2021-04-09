package com.rainmonth.pattern.behavioral.strategy.book;

/**
 * 高级会员销售策略
 * Created by RandyZhang on 2017/10/19.
 */
public class AdvanceMemberStrategy implements MemberStrategy{
    @Override
    public double calculateActualSalePrice(double bookSalePrice) {
        System.out.println("高级会员打八折");
        return bookSalePrice * 0.9;
    }
}

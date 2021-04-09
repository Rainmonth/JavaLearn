package com.rainmonth.pattern.behavioral.strategy.book;

/**
 * 中级会员销售策略
 * Created by RandyZhang on 2017/10/19.
 */
public class IntermediateMemberStrategy implements MemberStrategy{
    @Override
    public double calculateActualSalePrice(double bookSalePrice) {
        System.out.println("中级会员打九折");
        return bookSalePrice * 0.9;
    }
}

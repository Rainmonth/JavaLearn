package com.rainmonth.pattern.behavioral.strategy.book;

/**
 * 会员计价策略接口
 * Created by RandyZhang on 2017/10/19.
 */
public interface MemberStrategy {
    /**
     * 计算书籍实际销售价格
     *
     * @param bookSalePrice 书籍销售价格
     * @return 实际售价
     */
    public double calculateActualSalePrice(double bookSalePrice);
}

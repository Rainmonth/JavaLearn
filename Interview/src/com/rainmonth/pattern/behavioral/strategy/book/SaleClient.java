package com.rainmonth.pattern.behavioral.strategy.book;

/**
 * 销售终端
 * Created by RandyZhang on 2017/10/19.
 */
public class SaleClient {
    public static void main(String[] args) {
        // 知道当前顾客是高级会员
        MemberStrategy advanceStrategy = new AdvanceMemberStrategy();
        // 获取他要购买的书
        BookEntity bookEntity = new BookEntity(advanceStrategy);
        // 获取卖给该会员的实际价格
        double actualSalePrice = bookEntity.getBookActualSalePrice(50);
        System.out.println("actualSalePrice=" + actualSalePrice);
    }
}

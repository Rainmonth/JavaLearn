package com.rainmonth.pattern.creational.prototype.checkout;

import com.rainmonth.pattern.creational.prototype.simple.RealPrototype;

/**
 * @author randy
 * @date 2021/7/16 2:39 下午
 */
public class CheckoutClient {

    public static void main(String[] args) {

        // 得到 RealPrototype的对象
        RealPrototype copyReal = (RealPrototype) PrototypeManager.getInstance().getPrototype(PrototypeManager.PROTOTYPE_REAL);
        AnotherPrototype copyAnother = (AnotherPrototype) PrototypeManager.getInstance().getPrototype(PrototypeManager.PROTOTYPE_ANOTHER);

        /*
        * 由此例可以看出原型这种几种管理的几个明显缺点：
        * 1. 容易产生 NullPointerException，得到的基础原型对象可能会被移除而不复存在了
        * 2. 容易产生 ClassCastException，得到的对象可能是抽象原型的另一种实现
        *
        * 所以要保证只有一种类型的具体对象，这样就可以避免可能发生的类型转换问题。
        */
    }
}

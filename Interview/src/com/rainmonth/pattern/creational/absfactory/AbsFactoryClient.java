package com.rainmonth.pattern.creational.absfactory;

import com.rainmonth.pattern.creational.absfactory.factory.AppleComputerFactory;
import com.rainmonth.pattern.creational.absfactory.factory.ComputerFactory;
import com.rainmonth.pattern.creational.absfactory.factory.HuaweiComputerFactory;

/**
 * @author randy
 * @date 2021/7/12 5:18 下午
 */
public class AbsFactoryClient {
    public static void main(String[] args) {
        ComputerFactory computerFactory = new AppleComputerFactory();

        computerFactory.computerInfo();

        ComputerFactory computerFactory1 = new HuaweiComputerFactory();

        computerFactory1.computerInfo();

    }
}

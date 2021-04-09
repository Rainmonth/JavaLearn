package com.rainmonth.pattern.behavioral.mediator.demo2;

/**
 * Created by RandyZhang on 2017/9/20.
 */
public class Client {
    public static void main(String[] args) {
        ConcreteMediator mediator = new ConcreteMediator();

        EmployeeA employeeA = new EmployeeA("张三", mediator);
        EmployeeB employeeB = new EmployeeB("李四", mediator);

        mediator.setEmployeeA(employeeA);
        mediator.setEmployeeB(employeeB);

        employeeA.sayHi("我有事要和李四说。");
        employeeB.sayHi("我下午有时间，下午商量。");
    }
}

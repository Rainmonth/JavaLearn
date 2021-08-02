package com.rainmonth.pattern.structural.composite.demo;

/**
 * @author randy
 * @date 2021/7/22 6:18 下午
 */
public class Client {
    public static void main(String[] args) {
        Employee ceo = new Employee("Randy", "CEO");

        Employee saleMgr = new Employee("Randy1", "Sales");

        Employee marketMgr = new Employee("Randy2", "Markets");

        Employee saleOne = new Employee("Randy3", "Sales");
        Employee saleTwo = new Employee("Randy4", "Sales");

        Employee marketOne = new Employee("Randy5", "Market");
        Employee marketTwo = new Employee("Randy6", "Market");

        ceo.addEmployee(saleMgr);
        ceo.addEmployee(marketMgr);

        saleMgr.addEmployee(saleOne);
        saleMgr.addEmployee(saleTwo);

        marketMgr.addEmployee(marketOne);
        marketMgr.addEmployee(marketTwo);

        System.out.println(ceo);
        for (Employee employee : ceo.subEmployees) {
            System.out.println("    " + employee);
            for (Employee employee1 : employee.subEmployees) {
                System.out.println("        " +employee1);
            }
        }
    }
}

package com.rainmonth.pattern.behavioral.strategy.employee;

public class Merchant extends EmployeeType {

    @Override
    public int payAmount(Employee employee) {
        return employee.getMonthSalary() + employee.getBonus();
    }
}

package com.rainmonth.pattern.behavioral.strategy.employee;

public class Salesman extends EmployeeType {

    @Override
    public int payAmount(Employee employee) {
        return employee.getMonthSalary() + employee.getCommission();
    }
}

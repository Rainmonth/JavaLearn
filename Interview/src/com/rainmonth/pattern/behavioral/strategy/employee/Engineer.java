package com.rainmonth.pattern.behavioral.strategy.employee;

public class Engineer extends EmployeeType {

    @Override
    public int payAmount(Employee employee) {
        return employee.getMonthSalary();
    }
}

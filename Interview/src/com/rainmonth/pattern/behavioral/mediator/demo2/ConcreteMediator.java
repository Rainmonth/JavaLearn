package com.rainmonth.pattern.behavioral.mediator.demo2;

/**
 * Created by RandyZhang on 2017/9/20.
 */
public class ConcreteMediator extends Mediator {
    EmployeeA employeeA;
    EmployeeB employeeB;

    public EmployeeA getEmployeeA() {
        return employeeA;
    }

    public void setEmployeeA(EmployeeA employeeA) {
        this.employeeA = employeeA;
    }

    public EmployeeB getEmployeeB() {
        return employeeB;
    }

    public void setEmployeeB(EmployeeB employeeB) {
        this.employeeB = employeeB;
    }

    @Override
    public void sayHi(String message, Employee employee) {
        if (employee == employeeA) {
            employeeA.getMessage(message);
        } else {
            employeeB.getMessage(message);
        }
    }
}

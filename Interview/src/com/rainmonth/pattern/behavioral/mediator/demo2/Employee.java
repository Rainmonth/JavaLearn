package com.rainmonth.pattern.behavioral.mediator.demo2;

/**
 * Created by RandyZhang on 2017/9/20.
 */
public class Employee {
    protected String name;
    protected Mediator mediator;

    public Employee(String name, Mediator mediator) {
        this.name = name;
        this.mediator = mediator;
    }
}

class EmployeeA extends Employee {

    public EmployeeA(String name, Mediator mediator) {
        super(name, mediator);
    }

    public void getMessage(String message) {
        System.out.println("员工" + name + "说:" + message);
    }

    public void sayHi(String message) {
        mediator.sayHi(message, this);
    }
}

class EmployeeB extends Employee {

    public EmployeeB(String name, Mediator mediator) {
        super(name, mediator);
    }

    public void getMessage(String message) {
        System.out.println("员工" + name + "说:" + message);
    }

    public void sayHi(String message) {
        mediator.sayHi(message, this);
    }
}

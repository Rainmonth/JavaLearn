package com.rainmonth.pattern.structural.composite.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author randy
 * @date 2021/7/22 6:10 下午
 */
public class Employee {
    public String name;
    public String dept;
    public List<Employee> subEmployees;

    public Employee(String name, String dept) {
        this.name = name;
        this.dept = dept;
        subEmployees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        subEmployees.add(employee);
    }

    public void removeEmployee(Employee employee) {
        subEmployees.remove(employee);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", dept='" + dept + '\'' +
                '}';
    }
}

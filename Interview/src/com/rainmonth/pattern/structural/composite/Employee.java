package com.rainmonth.pattern.structural.composite;

public interface Employee {

    public void add(Employee employee);

    public void remove(Employee employee);

    public Employee getChild(int i);

    public String getName();

    public String getTitle();

    public void print();
}

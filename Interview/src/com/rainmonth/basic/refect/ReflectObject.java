package com.rainmonth.basic.refect;

import java.util.Objects;

/**
 * 反射工具类测试对象
 *
 * @author RandyZhang
 * @date 2021/9/3 3:11 下午
 */
public class ReflectObject extends BaseObject implements ReflectInterface{

    public static String test = "11";

    private String name = "";

    private long id = 0;

    public ReflectObject() {
    }

    public ReflectObject(String name, long id) {
        this.name = name;
        this.id = id;
    }

//    @Override
//    public void print() {
//        super.print();
//        System.out.println(getName());
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReflectObject that = (ReflectObject) o;
        return id == that.id && name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id);
    }

    private void setNameAndId(String name, long id) {
        System.out.println("setNameAndId long");
        this.name = name;
        this.id = id;
    }

    private void setNameAndId(String name, Long id) {
        System.out.println("setNameAndId Long");
        this.name = name;
        this.id = id;
    }

    private void setIdAndName(long id, String name) {
        System.out.println("setIdAndName long");
        this.name = name;
        this.id = id;
    }

    private void setIdAndName(Long id, String name) {
        System.out.println("setIdAndName Long");
        this.name = name;
        this.id = id;
    }

//    @Override
//    public void testReflect() {
//        System.out.println("testReflect");
//    }

    @Override
    public String toString() {
        return "ReflectObject{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}

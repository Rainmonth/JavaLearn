package com.rainmonth.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 重写{@link Object#equals(Object)}方法必须要重写hashCode的实例说明
 * @author randy
 * @date 2021/8/4 11:01 上午
 */
public class EqualHashCodeDemo {
    public static void main(String[] args) {
        Student o1 = new Student();
        o1.name = "Randy";
        o1.num = 1;
        Student o2 = new Student();
        o2.name = "Randy";
        o2.num = 1;

        System.out.println("equals:" + Objects.equals(o1, o2));
        System.out.println("o1 hashCode:" + o1.hashCode());
        System.out.println("o2 hashCode:" + o2.hashCode());

        Map<Student, String> studentIdMap = new HashMap<>();

        // 在没有重写hashCode 的情况下，两个对象的hashCode肯定不同，而HashMap在调用put时会先判断hashCode是否相同，如果不同，就存储；如果
        // 相同再比较equals，equals如果相同，则不存储，不同则存储在散列的其他位置；

        // 由于没有重写hashCode,导致equals为true的对象被存在了HashMap的两个位置，这就是重写equals方法为什么一定要重写hashCode的原因
        studentIdMap.put(o1, "422111");
        studentIdMap.put(o2, "422112");

        System.out.println(studentIdMap.get(o1));
        System.out.println(studentIdMap.get(o2));
    }
}

class Student {
    public int num;
    public String name;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return num == student.num && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(num, name);
    }
}

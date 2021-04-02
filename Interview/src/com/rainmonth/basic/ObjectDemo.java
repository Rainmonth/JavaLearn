package com.rainmonth.basic;

/**
 * Object 类学习使用
 * @author randy
 * @date 2021/4/1 1:54 下午
 */
public class ObjectDemo {
    public static void main(String[] args) {
        DemoObject demoObject = new DemoObject(23);
        DemoObject clone;
        System.out.println("demoObj:" + demoObject);
        System.out.println("demoObj.getClass():" + demoObject.getClass());

        try {
            clone = (DemoObject) demoObject.clone();
            System.out.println("cloneObj:" + clone);

            System.out.println("getClass:" + (demoObject.getClass() == clone.getClass()));
            // 由于DemoObject 没有重写 equals() 方法，此时比较的时内存地址，返回 false
            System.out.println("equals:" + (demoObject.equals(clone)));
            // 比较基本数据类型值是否相等、引用类型引用的地址是否相等
            System.out.println("==:" + (demoObject == clone));
            System.out.println("hashCode:" + (demoObject.hashCode() == clone.hashCode()));
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        System.out.println("重写了equals方法");

        DemoObject2 demoObject2 = new DemoObject2(23);
        DemoObject2 clone2;

        try {
            clone2 = (DemoObject2) demoObject2.clone();
            System.out.println("cloneObj2:" + clone2);

            System.out.println("getClass:" + (demoObject2.getClass() == clone2.getClass()));
            // 由于DemoObject 没有重写 equals() 方法，此时比较的时内存地址，返回 false
            System.out.println("equals:" + (demoObject2.equals(clone2)));
            System.out.println("==:" + (demoObject2 == clone2));
            System.out.println("hashCode:" + (demoObject2.hashCode() == clone2.hashCode()));

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}

class DemoObject implements Cloneable {
    public int a = 10;

    public DemoObject(int a) {
        this.a = a;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
//        return new DemoObject(a);
        return super.clone();
    }

    @Override
    public String toString() {
        return "DemoObject{" +
                "a=" + a +
                '}';
    }
}

class DemoObject2 implements Cloneable {
    public int b = 11;

    public DemoObject2(int b) {
        this.b = b;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        return obj instanceof DemoObject2 && ((DemoObject2) obj).b == this.b;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "DemoObject2{" +
                "b=" + b +
                '}';
    }
}

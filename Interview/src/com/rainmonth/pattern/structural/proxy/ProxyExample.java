package com.rainmonth.pattern.structural.proxy;

class ProxyExample {
    public static void main(String[] args) {
        Image image1 = new ProxyImage("HiRes_10MB_Photo1");

        System.out.println("First time displayImage begin:");
        image1.displayImage(); // loading necessary
        System.out.println("Second time displayImage begin:");
        image1.displayImage(); // loading unnecessary
//		输出结果如下：
//		First time displayImage begin:
//      Loading   HiRes_10MB_Photo1
//      Displaying HiRes_10MB_Photo1
//      Second time displayImage begin:
//      Displaying HiRes_10MB_Photo1

    }
}
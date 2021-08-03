package com.rainmonth.pattern.behavioral.memento;

import java.util.Date;

public class Main {

    public static void main(String[] args) {
        Application application = new Application();
        Recovery recovery = new Recovery();

        System.out.println(application.getState());

        Backup backup = application.backup();  // 建立备忘
        recovery.add(backup); // 加入备忘录

        application.setState("customer setting");
        System.out.println(application.getState());

        Date date = backup.getDate(); // 假设 date 是使用者自行设定所要取得的还原时间！
        application.recover(recovery.retrieve(date)); // 取出备忘录来还原
        System.out.println(application.getState());
    }

}
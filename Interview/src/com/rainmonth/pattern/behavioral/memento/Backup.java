package com.rainmonth.pattern.behavioral.memento;

import java.util.Date;

/**
 * 备忘录类，保存了一个状态，同时还有保存的日期，根据日期可以来检索保存的备忘
 */
public class Backup {
    private String state;
    private Date date;

    public Backup(String state) {
        this.state = state;
        date = new Date();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Date getDate() {
        return date;
    }
}
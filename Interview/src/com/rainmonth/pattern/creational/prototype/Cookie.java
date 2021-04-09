package com.rainmonth.pattern.creational.prototype;

public class Cookie implements Cloneable {

	public String cookieName;
	public String cookieEndDate;

	public Object clone() throws CloneNotSupportedException {
		return (Cookie) super.clone();
	}
}
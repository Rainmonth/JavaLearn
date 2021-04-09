package com.rainmonth.collections;

import java.util.HashMap;
import java.util.Hashtable;

/**
 * HashMap、Hashtable 比较
 * @author randy
 * @date 2021/4/1 8:14 下午
 */
public class HashMapTableDemo {

    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();
        Hashtable<Integer, String> table = new Hashtable<>();

        try {
            map.put(1, null);
            table.put(1, null);
        } catch (NullPointerException e) {
            System.err.println(e);
        }

        try {
            map.put(null, "null");
            table.put(null, "null");
        } catch (NullPointerException e) {
            System.err.println(e);
        }

        System.out.println("map size:" + map.size());
        System.out.println("table size:" + table.size());
    }
}

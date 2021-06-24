package com.rainmonth.leetcode.helper;

/**
 * 单向列表Node定义
 * @author randy
 * @date 2021/6/24 1:15 下午
 */
public class ListNode<T> {
    public T data;                  // 数据
    public ListNode<T> next;        // 下一个节点

    public ListNode(T data, ListNode<T> next) {
        this.data = data;
        this.next = next;
    }

    public ListNode(T data) {
    }

    public ListNode() {
    }
}

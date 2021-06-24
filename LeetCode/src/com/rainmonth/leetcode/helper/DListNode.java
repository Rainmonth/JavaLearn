package com.rainmonth.leetcode.helper;

/**
 * 双向ListNode 节点
 * @author randy
 * @date 2021/6/24 1:16 下午
 */
public class DListNode<T> extends ListNode<T> {
    ListNode<T> prev;

    public DListNode(T data, ListNode<T> next, ListNode<T> prev) {
        super(data, next);
        this.prev = prev;
    }

    public DListNode() {
    }
}

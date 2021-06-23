package com.rainmonth.leetcode.tree;

public class Node<T extends Object> {
    public T data;         // 数据
    public int level;           // 层
    public Node<T> leftNode;       // 左子树
    public Node<T> rightNode;      // 右子树

    public Node(T data, int level, Node<T> leftNode, Node<T> rightNode) {
        this.data = data;
        this.level = level;
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }

    public Node(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return data + " ";
    }
}

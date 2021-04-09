package com.rainmonth.leetcode.tree;

public class Node {
    public String data;         // 数据
    public int level;           // 层
    public Node leftNode;       // 左子树
    public Node rightNode;      // 右子树

    public Node(String data, int level, Node leftNode, Node rightNode) {
        this.data = data;
        this.level = level;
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }

    @Override
    public String toString() {
        return data + " ";
    }
}

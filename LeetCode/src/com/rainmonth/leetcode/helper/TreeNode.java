package com.rainmonth.leetcode.helper;

/**
 * @author randy
 * @date 2021/6/24 1:14 下午
 */
public class TreeNode<T> {
    public T data;                  // 数据
    public int level;               // 层
    public TreeNode<T> leftNode;        // 左子树
    public TreeNode<T> rightNode;       // 右子树

    public TreeNode(T data, int level, TreeNode<T> leftNode, TreeNode<T> rightNode) {
        this.data = data;
        this.level = level;
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }

    public TreeNode(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return data + " ";
    }
}

package com.rainmonth.leetcode.tree.mothod;

import com.rainmonth.leetcode.helper.TreeNode;

/**
 * 先根遍历 递归 实现
 */
public class FirstRootRecursionTraversal implements TraversalMethod<String> {
    @Override
    public void treeTraversal(TreeNode<String> root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        treeTraversal(root.leftNode);
        treeTraversal(root.rightNode);
    }

    @Override
    public void traversalIntro() {
        System.out.println("先序（根）遍历实现（递归法）:");
    }
}

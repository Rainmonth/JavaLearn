package com.rainmonth.leetcode.tree.mothod;

import com.rainmonth.leetcode.helper.TreeNode;

/**
 * 后根遍历 递归 实现
 */
public class LastRootRecursionTraversal implements TraversalMethod<String> {
    @Override
    public void treeTraversal(TreeNode<String> root) {
        if (root == null) {
            return;
        }
        treeTraversal(root.leftNode);
        treeTraversal(root.rightNode);
        System.out.print(root.data + " ");
    }


    @Override
    public void traversalIntro() {
        System.out.println("后序（根）遍历实现（递归法）:");
    }
}

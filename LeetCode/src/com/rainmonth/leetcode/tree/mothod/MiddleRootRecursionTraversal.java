package com.rainmonth.leetcode.tree.mothod;

import com.rainmonth.leetcode.helper.TreeNode;

/**
 * 中根遍历 递归 实现
 */
public class MiddleRootRecursionTraversal implements TraversalMethod<String> {
    @Override
    public void treeTraversal(TreeNode<String> root) {
        if (root == null) {
            return;
        }
        treeTraversal(root.leftNode);
        System.out.print(root.data + " ");
        treeTraversal(root.rightNode);
    }


    @Override
    public void traversalIntro() {
        System.out.println("中序（根）遍历实现（递归法）:");
    }
}

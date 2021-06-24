package com.rainmonth.leetcode.tree;

import com.rainmonth.leetcode.helper.NodeHelper;
import com.rainmonth.leetcode.helper.TreeNode;

public class TreeTraverse {
    public static void main(String[] args) {
        TreeNode root = NodeHelper.generateTree();

        System.out.println("先根遍历（递归法）：");
        firstRootTraverse(root);

        System.out.println();

        System.out.println("中根遍历（递归法）：");
        middleRootTraverse(root);

        System.out.println();

        System.out.println("后根遍历（递归法）：");
        lastRootTraverse(root);

        System.out.println();
    }

    /**
     * 先根遍历（递归法），对节点的访问在<b>最先</b>
     */
    public static void firstRootTraverse(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        if (root.leftNode != null) {
            firstRootTraverse(root.leftNode);
        }
        if (root.rightNode != null) {
            firstRootTraverse(root.rightNode);
        }
    }

    /**
     * 中根遍历（递归法），对节点的访问在<b>中间</b>
     */
    public static void middleRootTraverse(TreeNode root) {
        if (root == null) {
            return;
        }
        middleRootTraverse(root.leftNode);
        System.out.print(root.data + " ");
        middleRootTraverse(root.rightNode);
    }

    /**
     * 后根遍历（递归法），对节点的访问在<b>最后</b
     */
    public static void lastRootTraverse(TreeNode root) {
        if (root == null) {
            return;
        }
        lastRootTraverse(root.leftNode);
        lastRootTraverse(root.rightNode);
        System.out.print(root.data + " ");
    }

    /**
     * 重建二叉树
     */
    public static void rebuildTree() {

    }
}

package com.rainmonth.leetcode.tree;

public class TreeTraverse {
    public static void main(String[] args) {
        Node root = NodeHelper.generateTree();

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
    public static void firstRootTraverse(Node root) {
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
    public static void middleRootTraverse(Node root) {
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
    public static void lastRootTraverse(Node root) {
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

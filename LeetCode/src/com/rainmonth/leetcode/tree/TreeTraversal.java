package com.rainmonth.leetcode.tree;

/**
 * 树遍历
 */
public class TreeTraversal {
    public static void main(String[] args) {
        Node tree = TreeHelper.generateTree();

        TreeManager treeManager = new TreeManager();
        System.out.println("--先序（根）遍历--");
        treeManager.setTraversalMethod(TreeManager.FIRST_ROOT_RECURSION);
        treeManager.treeTraversal(tree);

        System.out.println();
        treeManager.setTraversalMethod(TreeManager.FIRST_ROOT_ITERATION);
        treeManager.treeTraversal(tree);

        System.out.println();
        System.out.println("--中序（根）遍历--");
        treeManager.setTraversalMethod(TreeManager.MIDDLE_ROOT_RECURSION);
        treeManager.treeTraversal(tree);

        System.out.println();
        treeManager.setTraversalMethod(TreeManager.MIDDLE_ROOT_ITERATION);
        treeManager.treeTraversal(tree);

        System.out.println();
        System.out.println("--后序（根）遍历--");
        treeManager.setTraversalMethod(TreeManager.LAST_ROOT_RECURSION);
        treeManager.treeTraversal(tree);

        System.out.println();
        treeManager.setTraversalMethod(TreeManager.LAST_ROOT_ITERATION);
        treeManager.treeTraversal(tree);

        System.out.println();
        treeManager.setTraversalMethod(TreeManager.LAST_ROOT_TWO_STACK);
        treeManager.treeTraversal(tree);
    }
}
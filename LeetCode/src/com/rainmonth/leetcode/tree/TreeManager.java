package com.rainmonth.leetcode.tree;

import com.rainmonth.leetcode.tree.mothod.*;

/**
 * 二叉树算法管理
 *
 * 采用策略模式来实现
 */
public class TreeManager {
    public static final int FIRST_ROOT_RECURSION = 0;
    public static final int FIRST_ROOT_ITERATION = 1;
    public static final int MIDDLE_ROOT_RECURSION = 2;
    public static final int MIDDLE_ROOT_ITERATION = 3;
    public static final int LAST_ROOT_RECURSION = 4;
    public static final int LAST_ROOT_ITERATION = 5;
    public static final int LAST_ROOT_TWO_STACK = 6;

    private TraversalMethod traversalMethod;

    public void setTraversalMethod(int traversalStrategy) {
        switch (traversalStrategy) {
            case FIRST_ROOT_RECURSION:
            default:
                this.traversalMethod = new FirstRootRecursionTraversal();
                break;
            case FIRST_ROOT_ITERATION:
                this.traversalMethod = new FirstRootIterationTraversal();
                break;
            case MIDDLE_ROOT_RECURSION:
                this.traversalMethod = new MiddleRootRecursionTraversal();
                break;
            case MIDDLE_ROOT_ITERATION:
                this.traversalMethod = new MiddleRootIterationTraversal();
                break;
            case LAST_ROOT_RECURSION:
                this.traversalMethod = new LastRootRecursionTraversal();
                break;
            case LAST_ROOT_ITERATION:
                this.traversalMethod = new LastRootIterationTraversal();
                break;
            case LAST_ROOT_TWO_STACK:
                this.traversalMethod = new LastRootTwoStackTraversal();
                break;
        }
    }

    public void treeTraversal(Node root) {
        if (traversalMethod != null) {
            traversalMethod.traversalIntro();
            traversalMethod.treeTraversal(root);
        }
    }
}

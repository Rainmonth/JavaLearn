package com.rainmonth.leetcode.tree.mothod;

import com.rainmonth.leetcode.tree.Node;

import java.util.Stack;

/**
 * 中根遍历 迭代 实现
 * 1            A
 * /   \
 * 2         C      B
 * / \     / \
 * 3     E    D   F   G
 * \  /    /   \
 * 4      J  H   K     I
 * 思路：
 * 1.根节点入栈，进入其左子树，进而左子树的根节点入栈，进入下一层左子树，….,如此重复，直至当前节点为空·。
 * 2.若栈非空，则退栈，访问出栈节点，并进入其右子树。
 * 3.以2中的右子树的根节点作为根节点，开始迭代
 */
public class MiddleRootIterationTraversal implements TraversalMethod {
    @Override
    public void treeTraversal(Node root) {
        Stack<Node> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                System.out.println(stack);
                root = root.leftNode;
            }
            if (!stack.isEmpty()) {
                root = stack.pop();
                System.out.print(root.data + " ");
                root = root.rightNode;
            }
        }
//        treeTraversal(root.leftNode);
//        System.out.print(root.data + " ");
//        treeTraversal(root.rightNode);
    }


    @Override
    public void traversalIntro() {
        System.out.println("中序（根）遍历实现（迭代法）:");
    }
}

package com.rainmonth.leetcode.tree.mothod;

import com.rainmonth.leetcode.helper.TreeNode;

import java.util.Stack;

/**
 * 后根遍历 迭代 实现
 * 1            A
 * /   \
 * 2         C      B
 * / \     / \
 * 3     E    D   F   G
 * \  /    /   \
 * 4      J  H   K     I
 * 思路：
 * 1.根节点入栈，进入其左子树，进而左子树的根节点入栈，进入下一层左子树，……，如此重复，直至当前节点为空。
 * 2.若栈非空，读取栈顶元素，如果栈顶节点p的右子树为空，或者p的右孩子是刚访问的节点q，则退栈、访问p节点，并将p置为空，如果栈顶节点p有右子树且右子树为访问，则进入p的右子树。
 */
public class LastRootIterationTraversal implements TraversalMethod<String> {
    @Override
    public void treeTraversal(TreeNode<String> root) {
        Stack<TreeNode<String>> stack = new Stack<>();
        TreeNode<String> p = root;
        TreeNode<String> q = null;
        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                stack.push(p);// 根节点入栈
                p = p.leftNode;
            }

            if (!stack.isEmpty()) {
                p = stack.peek(); // 读取栈顶元素
                if (p.rightNode == null || p.rightNode == q) {
                    System.out.print(p.data + " ");
                    stack.pop();
                    q = p;
                    p = null;
                } else {
                    p = p.rightNode;
                }
            }
        }
    }


    @Override
    public void traversalIntro() {
        System.out.println("后序（根）遍历实现（迭代法）:");
    }
}

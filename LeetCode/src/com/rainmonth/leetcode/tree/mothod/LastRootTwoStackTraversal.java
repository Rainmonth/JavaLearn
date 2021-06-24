package com.rainmonth.leetcode.tree.mothod;

import com.rainmonth.leetcode.helper.TreeNode;

import java.util.Stack;

/**
 * 后序遍历 双栈实现
 * 1            A
 * /   \
 * 2         C      B
 * / \     / \
 * 3     E    D   F   G
 * \  /    /   \
 * 4      J  H   K     I
 */
public class LastRootTwoStackTraversal implements TraversalMethod<String> {

    @Override
    public void treeTraversal(TreeNode<String> root) {
        Stack<TreeNode<String>> stack = new Stack<>();
        Stack<TreeNode<String>> temp = new Stack<>();
        TreeNode<String> node = root;
        while (node != null || stack.size() > 0) {
            // 把当前节点和其右侧子结点推入栈
            while (node != null) {
                stack.push(node);
                temp.push(node);    // A B G I F
                System.out.println(temp);
                node = node.rightNode;
            }
            // 处理栈顶节点的左子树
            if (stack.size() > 0) {
                node = stack.pop();     // I [A B]
                node = node.leftNode;   //
            }
        }

        // temp 就是记录排好序的站点
        while (temp.size() > 0) {
            node = temp.pop();          // I
            System.out.print(node + "");
        }
    }

    @Override
    public void traversalIntro() {
        System.out.println("后续（根）遍历双栈实现，非迭代");
    }
}

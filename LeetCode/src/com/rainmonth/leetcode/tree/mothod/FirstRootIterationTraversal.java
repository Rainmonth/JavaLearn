package com.rainmonth.leetcode.tree.mothod;

import com.rainmonth.leetcode.helper.TreeNode;

import java.util.Stack;

/**
 * 先根遍历 迭代 实现
 * 算法原理：
 *
 *
 * <code>
 * 1            A
 * /   \
 * 2         C      B
 * / \     / \
 * 3     E    D   F   G
 * \  /    /   \
 * 4      J  H   K     I
 * </code>
 * 思路：
 * 1.访问根节点，根节点入栈并进入其左子树，进而访问左子树的根节点并入栈，在进入下一层左子树，……，如此重复，直至当前节点为空。
 * 2.如栈非空，则从栈顶退出上一层的节点，并进入该节点的右子树。
 */
public class FirstRootIterationTraversal implements TraversalMethod<String> {


    @Override
    public void treeTraversal(TreeNode<String> root) {
        Stack<TreeNode<String>> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) { // 现将所有左子树入栈
                System.out.print(root.data + " ");
                stack.push(root);
                root = root.leftNode;
            }
            if (!stack.isEmpty()) {
                root = stack.pop();
                root = root.rightNode;
            }
        }
    }

    @Override
    public void traversalIntro() {
        System.out.println("先序（根）遍历实现（迭代法）:");
    }
}

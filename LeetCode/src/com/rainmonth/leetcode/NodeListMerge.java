package com.rainmonth.leetcode;

import com.rainmonth.leetcode.tree.Node;
import com.rainmonth.leetcode.tree.NodeHelper;

/**
 * 链表合并
 * @author randy
 * @date 2021/6/23 1:17 下午
 */
public class NodeListMerge {
    public static void main(String[] args) {
        Node<Integer> root1 = NodeHelper.generateSortedList(10, 10, 10);
        NodeHelper.printRightNodeList(root1);

        Node<Integer> root2 = NodeHelper.generateSortedList(9, 5, 10);
        NodeHelper.printRightNodeList(root2);

        System.out.println();
        System.out.print("合并后结果:");
        NodeHelper.printRightNodeList(new Solution1().mergeTwoSortedList(root1, root2));
    }
}

class Solution1 {
    public Node<Integer> mergeTwoSortedList(Node<Integer> root1, Node<Integer> root2) {
        if (root1 == null) {
            return root2;
        }

        if (root2 == null) {
            return root1;
        }

        if (root1.data <= root2.data) {
            root1.rightNode = mergeTwoSortedList(root1.rightNode, root2);
            return root1;
        } else {
            root2.rightNode = mergeTwoSortedList(root1, root2.rightNode);
            return root2;
        }
    }
}

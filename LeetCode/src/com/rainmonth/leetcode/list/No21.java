package com.rainmonth.leetcode.list;

import com.rainmonth.leetcode.helper.ListNode;
import com.rainmonth.leetcode.helper.NodeHelper;

/**
 * 链表合并  合并两个有序链表
 * @author randy
 * @date 2021/6/23 1:17 下午
 */
public class No21 {
    public static void main(String[] args) {
        ListNode<Integer> root1 = NodeHelper.generateSortedList(10, 10, 10);
        NodeHelper.printRightNodeList(root1);

        ListNode<Integer> root2 = NodeHelper.generateSortedList(9, 5, 10);
        NodeHelper.printRightNodeList(root2);

        System.out.println();
        System.out.print("合并后结果:");
        NodeHelper.printRightNodeList(new Solution1().mergeTwoSortedList(root1, root2));
    }
}

class Solution1 {
    public ListNode<Integer> mergeTwoSortedList(ListNode<Integer> root1, ListNode<Integer> root2) {
        if (root1 == null) {
            return root2;
        }

        if (root2 == null) {
            return root1;
        }

        if (root1.data <= root2.data) {
            root1.next = mergeTwoSortedList(root1.next, root2);
            return root1;
        } else {
            root2.next = mergeTwoSortedList(root1, root2.next);
            return root2;
        }
    }
}

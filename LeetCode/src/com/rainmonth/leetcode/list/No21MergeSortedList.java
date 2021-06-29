package com.rainmonth.leetcode.list;

import com.rainmonth.leetcode.helper.ListNode;
import com.rainmonth.leetcode.helper.NodeHelper;

/**
 * 链表合并  合并两个有序链表
 *
 * @author randy
 * @date 2021/6/23 1:17 下午
 */
public class No21MergeSortedList {
    public static void main(String[] args) {
        ListNode<Integer> root1 = NodeHelper.generateSortedList(10, 10, 10);
        NodeHelper.printRightNodeList(root1);

        ListNode<Integer> root2 = NodeHelper.generateSortedList(9, 5, 10);
        NodeHelper.printRightNodeList(root2);

        System.out.println();
        System.out.print("合并后结果:");
//        NodeHelper.printRightNodeList(new Solution1().mergeTwoSortedList(root1, root2));
        NodeHelper.printRightNodeList(new Solution2().mergeTwoSortedList2(root1, root2));
    }
}

/**
 * 递归法，可以看成 头结点较小的链表的剩余部分和另一个链表merge的过程
 */
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

/**
 * 迭代法
 */
class Solution2 {
    public ListNode<Integer> mergeTwoSortedList2(ListNode<Integer> root1, ListNode<Integer> root2) {
        ListNode<Integer> preHead = new ListNode<>(-1);
        ListNode<Integer> pre = preHead;

        while (root1 != null && root2 != null) {
            if (root1.data <= root2.data) {
                pre.next = root1;
                root1 = root1.next;// 继续滑动root1
            } else {
                pre.next = root2;
                root2 = root2.next;// 继续滑动root2
            }
            pre = pre.next;     // 确定了一个后，继续滑动pre
        }
        pre.next = root1 == null ? root2.next : root1.next;
        return preHead.next;
    }
}

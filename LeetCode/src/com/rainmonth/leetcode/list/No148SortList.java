package com.rainmonth.leetcode.list;

import com.rainmonth.leetcode.helper.ListNode;
import com.rainmonth.leetcode.helper.NodeHelper;

/**
 * 给你链表的头结点head，请将其按 升序 排列并返回 排序后的链表。
 *
 * 进阶：
 *
 * 你可以在O(nlogn) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
 *
 *
 * @author randy
 * @date 2021/8/11 3:31 下午
 */
public class No148SortList {
    public static void main(String[] args) {
        ListNode<Integer> head = NodeHelper.generateListWithGivenValues(5, 3, 2, 4, 6);
    }
}

class No148Solution {
    ListNode<Integer> sortList(ListNode<Integer> head) {
        if (head == null) {
            return head;
        }
        while (head.next != null) {
            if (head.data <= head.next.data) {
                head.next = sortList(head.next);
            } else {
                ListNode<Integer> temp = head;
                head = head.next;
                head.next = temp;
            }
        }
        return head;
    }
}

package com.rainmonth.leetcode.list;

import com.rainmonth.leetcode.helper.ListNode;
import com.rainmonth.leetcode.helper.NodeHelper;

/**
 * 两两交换链表中的节点
 * 给定一个链表，两两交换相邻节点的值
 * @author randy
 * @date 2021/6/29 6:06 下午
 */
public class No24SwapPairs {
    public static void main(String[] args) {
        ListNode<Integer> root = NodeHelper.generateSortedList(10, 5, 5);
        NodeHelper.printRightNodeListWithIndex(root);
    }
}

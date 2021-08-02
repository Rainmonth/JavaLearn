package com.rainmonth.leetcode.list;

import com.rainmonth.leetcode.helper.ListNode;
import com.rainmonth.leetcode.helper.NodeHelper;

/**
 * 旋转链表
 * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
 * <href https://leetcode-cn.com/problems/rotate-list/>
 * <p>
 * [1, 2, 3, 4，5]
 * 移动1个位置：[5, 1, 2, 3, 4]
 * 移动2个位置：[4, 5, 1, 2, 3]
 *
 * @author RandyZhang
 * @date 2021/7/6 6:40 上午
 */
public class No61RotateList {
    public static void main(String[] args) {
        ListNode<Integer> head = NodeHelper.generateList(10, 5, 10);
        NodeHelper.printRightNodeList(head);

        NodeHelper.printRightNodeList(new No61Solution().solution(head, 2));
    }
}

/**
 * 1. 获取链表的长度
 * 2. 将链表闭合为环
 * 3. 处理下K，在处理后的第K个节点断开即可
 */
class No61Solution {
    public ListNode<Integer> solution(ListNode<Integer> head, int k) {
        if (head == null || head.next == null) {
            return head;
        }

        int length = 1;
        ListNode<Integer> temp = head;
        while (temp.next != null) {
            temp = temp.next;
            length++;
        }

        // 此时temp为链表最后一个节点
        int realK = k % length;
        if (realK == 0) {
            return head;
        }
        // 闭合为环
        temp.next = head;

        // 接下来根据尾部节点，找到头结点，并断开链表
        int newHeadStep = length - realK;
        while (newHeadStep-- > 0) {
            temp = temp.next;
        }
        ListNode<Integer> ret = temp.next;
        temp.next = null; // 断开链表
        return ret;
    }
}
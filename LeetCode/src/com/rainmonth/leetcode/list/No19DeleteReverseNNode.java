package com.rainmonth.leetcode.list;

import com.rainmonth.leetcode.helper.ListNode;
import com.rainmonth.leetcode.helper.NodeHelper;

/**
 * 删除链表的倒数第 N 个节点
 * @author randy
 * @date 2021/6/29 9:22 上午
 * [1, 2, 3, 5, 9]
 * 删除倒数第2个后
 * [1, 2, 3, 9]
 */
public class No19DeleteReverseNNode {
    public static void main(String[] args) {
        ListNode<Integer> head = NodeHelper.generateList(10, 5, 5);
        System.out.println("删除前：");
        NodeHelper.printRightNodeList(head);
        System.out.println("删除后：");
        NodeHelper.printRightNodeList(new No19Solution().deleteReverseNNode(head, 5));
    }
}

/**
 * 1. 获取链表的长度
 * 2. 倒数第N个节点判断
 *      - 头结点，则将头结点右移返回
 *      - 不是头结点，则找打第N+1各节点，其指针指向 倒数第N个节点的下一个节点
 */
class No19Solution {
    public ListNode<Integer> deleteReverseNNode(ListNode<Integer> head, int n) {
        if (head == null) {
            return null;
        }
        ListNode<Integer> pHead = new ListNode<>(-1);
        pHead.next = head;
        int listLength = 1;
        while (head.next != null) {
            head = head.next;
            listLength++;
        }
        head = pHead.next;
        if (n > listLength) { // 删除的节点长度超过链表长度
            return head;
        }

        if (n == listLength) {
            return head.next;
        }
        int temp = 1;
        while (head.next != null) {
            if (temp + n == listLength) {
                ListNode<Integer> deleteTarget = head.next;
                head.next = deleteTarget.next;
                break;
            } else {
                head = head.next;
                temp++;
            }
        }
        head = pHead.next;
        return head;
    }
}
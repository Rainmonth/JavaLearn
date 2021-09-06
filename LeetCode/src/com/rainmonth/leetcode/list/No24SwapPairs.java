package com.rainmonth.leetcode.list;

import com.rainmonth.leetcode.helper.ListNode;
import com.rainmonth.leetcode.helper.NodeHelper;

/**
 * 两两交换链表中的节点
 * 不仅要交换节点的值，还要交换节点
 *
 * 给定一个链表，两两交换相邻节点的值
 * 输入：[1,2,3,4,5,6]
 * 输出：[2,1,4,3,6,5]
 * @author randy
 * @date 2021/6/29 6:06 下午
 */
public class No24SwapPairs {
    public static void main(String[] args) {
        ListNode<Integer> root1 = NodeHelper.generateSortedList(10, 5, 5);
        NodeHelper.printRightNodeListWithIndex(root1);
        ListNode<Integer> result = new No24Solution1().swapPairs(root1);
        NodeHelper.printRightNodeListWithIndex(result);
        System.out.print("仅交换头两个节点：");
        NodeHelper.printRightNodeListWithIndex(new No24Extra().swapFistPairOfList(new No24Solution1().swapPairs(result)));


        ListNode<Integer> root2 = NodeHelper.generateSortedList(10, 5, 5);
        NodeHelper.printRightNodeListWithIndex(root2);
        NodeHelper.printRightNodeListWithIndex(new No24Solution2().swapPairs(root2));


        ListNode<Integer> root3 = NodeHelper.generateSortedList(10, 10, 50);
        NodeHelper.printRightNodeListWithIndex(root3);
        System.out.print("仅交换头两个节点：");
        NodeHelper.printRightNodeListWithIndex(new No24Extra().swapFistPairOfList(root3));
    }
}

/**
 * 1. 返回值， 交换完成的子链表
 * 2. 调用单元做了什么，设需要交换的单元为 head 和 next，head 链接后面交换完成的子链表，next 链家 head，完成交换
 * 3. 终止条件，root 为空 或 root.next 为空
 */
class No24Solution1 {
    public ListNode<Integer> swapPairs(ListNode<Integer> head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode<Integer> next = head.next;
        head.next = swapPairs(next.next);
        next.next = head;
        return next;

    }
}

class No24Solution2 {
    public ListNode<Integer> swapPairs(ListNode<Integer> head) {
        ListNode<Integer> prehead = new ListNode<>(-1);
        prehead.next = head;
        ListNode<Integer> temp = prehead;
//
//        [0, 1, 2]
        // 交换前面两个的值，并更新temp 为后面值得下一个值
        while (temp.next != null && temp.next.next != null) {
            ListNode<Integer> first = temp.next;
            ListNode<Integer> second = temp.next.next;
            temp.next = second;//
            first.next = second.next;
            second.next = first;

            // 此时 first 已经被交换了
            temp = first;
        }


        return prehead.next;
    }
}

/**
 * 交换链表的头两个节点
 */
class No24Extra {
    public ListNode<Integer> swapFistPairOfList(ListNode<Integer> head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode<Integer> next = head.next;

        head.next = next.next;
        next.next = head;


        return next;
    }
}

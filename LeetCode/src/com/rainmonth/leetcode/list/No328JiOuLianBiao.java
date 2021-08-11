package com.rainmonth.leetcode.list;

import com.rainmonth.leetcode.helper.ListNode;
import com.rainmonth.leetcode.helper.NodeHelper;

/**
 * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
 *
 * 请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。
 *
 * 示例 1:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 1->3->5->2->4->NULL
 * 示例 2:
 *
 * 输入: 2->1->3->5->6->4->7->NULL
 * 输出: 2->3->6->7->1->5->4->NULL
 * 说明:
 *
 * 应当保持奇数节点和偶数节点的相对顺序。
 * 链表的第一个节点视为奇数节点，第二个节点视为偶数节点，以此类推。
 *
 * @author randy
 * @date 2021/8/11 2:01 下午
 */
public class No328JiOuLianBiao {
    public static void main(String[] args) {
        ListNode<Integer> head = NodeHelper.generateListWithGivenValues(5, 4, 3, 7, 9, 10, 11);
        NodeHelper.printRightNodeList(head);

        ListNode<Integer> oddEvenHead = new No328Solution1().oddEvenList(head);
        NodeHelper.printRightNodeList(oddEvenHead);
    }
}

/**
 * 题目要求控件复杂度为1，时间复杂度为o(N)
 * 假设输入的为 奇数个数节点[5，4，3，7，9，10，11 ]
 * 假设输入的为 偶数个数节点[5，4，3，7，9，10 ]
 * 1. 得到第一个奇数链表头结点 odd（head,头结点），得到偶数链表头结点even（head.next,头结点下一个节点）
 * 2. 保存偶数链表头结点为 evenHead
 * 3. 分离链表分别得到奇数节点链表 head 和 偶数节点链表 evenHead
 * 4. 终止条件：偶数节点为空且偶数节点的下一个节点为空,终止后将奇数链表的最后一个节点指向偶数链表头结点
 */
class No328Solution1 {
    public ListNode<Integer> oddEvenList(ListNode<Integer> head) {
        if (head == null) {
            return head;
        }
        ListNode<Integer> evenHead = head.next;
        ListNode<Integer> odd = head, even = evenHead;
        // 滑动链表，将奇偶节点分离
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}

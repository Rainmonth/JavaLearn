package com.rainmonth.leetcode.helper;

import java.util.List;
import java.util.Random;

public class NodeHelper {
    /**
     * <p><code>
     * 1            A
     * /   \
     * 2         C      B
     * / \     / \
     * 3     E    D   F   G
     * \  /    /   \
     * 4      J  H   K     I
     * </code>
     *
     * </p>
     *
     * @return 根节点
     */
    public static TreeNode<String> generateTree() {
        TreeNode<String> nodeI = new TreeNode<>("I", 4, null, null);
        TreeNode<String> nodeK = new TreeNode<>("K", 4, null, null);
        TreeNode<String> nodeH = new TreeNode<>("H", 4, null, null);
        TreeNode<String> nodeJ = new TreeNode<>("J", 4, null, null);

        TreeNode<String> nodeG = new TreeNode<>("G", 3, null, nodeI);
        TreeNode<String> nodeF = new TreeNode<>("F", 3, nodeK, null);
        TreeNode<String> nodeD = new TreeNode<>("D", 3, nodeH, null);
        TreeNode<String> nodeE = new TreeNode<>("E", 3, null, nodeJ);

        TreeNode<String> nodeB = new TreeNode<>("B", 2, nodeF, nodeG);
        TreeNode<String> nodeC = new TreeNode<>("C", 2, nodeE, nodeD);

        return new TreeNode<>("A", 1, nodeC, nodeB);
    }

    /**
     * 生成有序链表
     *
     * @param base 链表头结点的基础值
     * @param num  链表的长度
     * @param seed 随机值得种子
     * @return 链表头结点
     */
    public static ListNode<Integer> generateSortedList(int base, int num, int seed) {
        Random random = new Random();
        ListNode<Integer> head = new ListNode<>(base);
        head.setIndex(0);
        ListNode<Integer> temp = head;
//        System.out.print(temp.data + " ");
        for (int i = 0; i < num - 1; i++) {
            int data = random.nextInt(seed);
//            System.out.print(data + " ");
            temp.next = new ListNode<>(temp.data + data);
            temp.next.setIndex(i + 1);
            temp = temp.next;
        }

        return head;
    }

    /**
     * 生成随机链表
     *
     * @param base 链表头结点的基础值
     * @param num  链表的长度
     * @param seed 随机值得种子
     * @return 链表头结点
     */
    public static ListNode<Integer> generateList(int base, int num, int seed) {
        Random random = new Random();
        ListNode<Integer> head = new ListNode<>(base);
        head.setIndex(0);
        ListNode<Integer> temp = head;
//        System.out.print(temp.data + " ");
        for (int i = 0; i < num - 1; i++) {
            int data = random.nextInt(seed);
//            System.out.print(data + " ");
            temp.next = new ListNode<>(data);
            temp.next.setIndex(i + 1);
            temp = temp.next;
        }

        return head;
    }


    /**
     * 根据给定的 数值生成 链表
     * @param values 给定的一组数值
     * @return 链表头结点
     */
    public static ListNode<Integer> generateListWithGivenValues(int... values) {
        ListNode<Integer> head = new ListNode<Integer>();
        ListNode<Integer> temp = head;
        for (int i = 0; i < values.length; i++) {
            if (i == 0) {
                temp.data = values[i];
                temp.setIndex(i);
            } else {
                temp.next = new ListNode<>(values[i]);
                temp.next.setIndex(i);
                temp = temp.next;
            }
        }
        return head;
    }


    /**
     * 打印链表
     *
     * @param headNode 链表头结点
     */
    public static void printRightNodeList(ListNode<Integer> headNode) {
        System.out.println();
        if (headNode != null) {
            System.out.print("生成的链表为：[");
            System.out.print(headNode.data);
            while (headNode.next != null) {
                System.out.print(" " + headNode.next.data);
                headNode = headNode.next;
            }
            System.out.print("]");
            System.out.println();
        }
    }

    /**
     * 打印链表
     *
     * @param headNode 链表头结点
     */
    public static void printRightNodeListWithIndex(ListNode<Integer> headNode) {
        System.out.println();
        if (headNode != null) {
            System.out.print("生成的链表为：[");
            System.out.print("[" + headNode.data + ", " + headNode.index + "]");
            while (headNode.next != null) {
                System.out.print(" [" + headNode.next.data + ", " + headNode.next.index + "]");
                headNode = headNode.next;
            }
            System.out.print("]");
            System.out.println();
        }
    }
}

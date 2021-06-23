package com.rainmonth.leetcode.tree;

import java.util.Random;

public class NodeHelper {
    /**
     * <p><code>
     * 1            A
     *            /   \
     * 2         C      B
     *         / \     / \
     * 3     E    D   F   G
     *        \  /    /   \
     * 4      J  H   K     I
     * </code>
     *
     * </p>
     *
     * @return 根节点
     */
    public static Node<String> generateTree() {
        Node<String> nodeI = new Node<String>("I", 4, null, null);
        Node<String> nodeK = new Node<String>("K", 4, null, null);
        Node<String> nodeH = new Node<String>("H", 4, null, null);
        Node<String> nodeJ = new Node<String>("J", 4, null, null);

        Node<String> nodeG = new Node<String>("G", 3, null, nodeI);
        Node<String> nodeF = new Node<String>("F", 3, nodeK, null);
        Node<String> nodeD = new Node<String>("D", 3, nodeH, null);
        Node<String> nodeE = new Node<String>("E", 3, null, nodeJ);

        Node<String> nodeB = new Node<String>("B", 2, nodeF, nodeG);
        Node<String> nodeC = new Node<String>("C", 2, nodeE, nodeD);

        return new Node<String>("A", 1, nodeC, nodeB);
    }

    /**
     * 生成有序链表
     * @param base 链表头结点的基础值
     * @param num 链表的长度
     * @param seed 随机值得种子
     * @return 链表头结点
     */
    public static Node<Integer> generateSortedList(int base, int num, int seed) {
        Random random = new Random();
        Node<Integer> head = new Node<>(base);
        Node<Integer> temp = head;
//        System.out.print(temp.data + " ");
        for (int i = 0; i < num - 1; i++) {
            int data = random.nextInt(seed);
//            System.out.print(data + " ");
            temp.rightNode = new Node<>(temp.data + data);
            temp = temp.rightNode;
        }

        return head;
    }

    /**
     * 打印链表
     * @param headNode 链表头结点
     */
    public static void printRightNodeList(Node<Integer> headNode) {
        System.out.println();
        if (headNode != null) {
            System.out.print("生成的链表为：[");
            System.out.print(headNode.data);
            while (headNode.rightNode != null) {
                System.out.print(" " + headNode.rightNode.data);
                headNode = headNode.rightNode;
            }
            System.out.print("]");
            System.out.println();
        }
    }
}

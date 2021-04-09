package com.rainmonth.leetcode.tree;

public class TreeHelper {
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
    public static Node generateTree() {
        Node nodeI = new Node("I", 4, null, null);
        Node nodeK = new Node("K", 4, null, null);
        Node nodeH = new Node("H", 4, null, null);
        Node nodeJ = new Node("J", 4, null, null);

        Node nodeG = new Node("G", 3, null, nodeI);
        Node nodeF = new Node("F", 3, nodeK, null);
        Node nodeD = new Node("D", 3, nodeH, null);
        Node nodeE = new Node("E", 3, null, nodeJ);

        Node nodeB = new Node("B", 2, nodeF, nodeG);
        Node nodeC = new Node("C", 2, nodeE, nodeD);

        Node nodeA = new Node("A", 1, nodeC, nodeB);

        return nodeA;
    }
}

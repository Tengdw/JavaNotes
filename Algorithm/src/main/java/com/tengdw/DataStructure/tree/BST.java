package com.tengdw.DataStructure.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Binary Search Tree
 *
 * @author: Tengdw t_dw@qq.com
 * @create: 2018-12-16 11:32
 **/
public class BST<E extends Comparable<E>> {

    private class Node {
        public E e;
        public Node right, left;

        public Node(E e) {
            this.e = e;
            left = null;
            right = null;
        }
    }

    private Node root;
    public int size;

    public BST() {
        root = null;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(E e) {
        root = add(root, e);

    }

    /**
     * 向以node为根的二分搜索树中插入元素e
     *
     * @param node
     * @param e
     * @return 插入新节点后二分搜索树的根
     */
    private Node add(Node node, E e) {
//        if (e.equals(node.e)) {
//            return;
//        // 如果e小于当前节点内的元素且不存在左节点，存入左节点
//        } else if (e.compareTo(node.e) < 0 && node.left == null) {
//            node.left = new Node(e);
//            size++;
//            return;
//        // 如果e大于当前节点内的元素且不存在右节点，存入右节点
//        } else if (e.compareTo(node.e) > 0 && node.right == null) {
//            node.right = new Node(e);
//            size++;
//            return;
//        }
        //返回插入新节点后二分搜索树的根
        if (node == null) {
            size++;
            return new Node(e);
        }
        if (e.compareTo(node.e) < 0) {
            node.left = add(node.left, e);
        } else if (e.compareTo(node.e) > 0) {
            node.right = add(node.right, e);
        }
        return node;
    }

    /**
     * 二分树中是否包含元素e
     *
     * @param e
     * @return
     */
    public boolean contains(E e) {
        return contains(root, e);
    }

    //看以node为根的二分搜索树中是否包含元素e
    private boolean contains(Node node, E e) {
        if (node == null) {
            return false;
        }
        if (e.compareTo(node.e) == 0) {
            return true;
        } else if (e.compareTo(node.e) < 0) {
            return contains(node.left, e);
            //e.compareTo(node.e) > 0
        } else {
            return contains(node.right, e);
        }
    }

    public void preOrder() {
        preOrder(root);
    }

    //前序遍历
    private void preOrder(Node node) {
        if (node == null)
            return;
        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    /**
     * 中序遍历
     * 使用迭代 {@link com.tengdw.LeetCode.Problem94.Solution#inorderTraversal}
     */
    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node node) {
        if (node == null)
            return;
        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    public void postOrder() {
        postOrder(root);
    }

    //后序遍历
    private void postOrder(Node node) {
        if (node == null)
            return;
        inOrder(node.left);
        inOrder(node.right);
        System.out.println(node.e);
    }

    //二分搜索树层序遍历 广度优先遍历
    public void levelOrder() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node cur = queue.remove();
            System.out.println(cur.e);

            if (cur.left != null) {
                queue.add(cur.left);
            }
            if (cur.right != null) {
                queue.add(cur.right);
            }
        }
    }

    //寻找二分搜索树的最小元素
    public E minimum() {
        if (size == 0) {
            throw new IllegalArgumentException("BST is empty.");
        }
        return minimum(root).e;
    }

    private Node minimum(Node node) {
        if (node.left == null) {
            return node;
        }
        return minimum(node.left);
        // 使用循环
//        Node cur = node;
//        while (cur.left != null) {
//            cur = cur.left;
//        }
//        return cur;
    }

    //寻找二分搜索树的最大元素
    public E maximum() {
        if (size == 0) {
            throw new IllegalArgumentException("BST is empty.");
        }
        return maximum(root).e;
    }

    private Node maximum(Node node) {
        if (node.right == null) {
            return node;
        }
        return maximum(node.right);
    }

    /**
     * 删除最小值所在的节点
     *
     * @return
     */
    public E removeMin() {
        E ret = minimum();
        root = removeMin(root);
        return ret;
    }

    /**
     * 删除以node为根的二分搜索树的最小节点
     *
     * @param node
     * @return 删除节点后新的二分搜索树的根
     */
    private Node removeMin(Node node) {
        if (node.left == null) {
            //存在没有左子节点的情况，那么删除的就是当前的节点，然后右子节点替换到当前位置
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }

    /**
     * 删除最大值所在的节点
     *
     * @return
     */
    public E removeMax() {
        E ret = maximum();
        root = removeMax(root);
        return ret;
    }

    /**
     * 删除以node为根的二分搜索树的最大节点
     *
     * @param node
     * @return 删除节点后新的二分搜索树的根
     */
    private Node removeMax(Node node) {
        if (node.right == null) {
            Node leftNode = node.left;
            node.left = null;
            size--;
            return leftNode;
        }
        node.right = removeMax(node.right);
        return node;
    }

    /**
     * 从二分搜索树中删除元素为e的节点
     *
     * @param e
     */
    public void remove(E e) {
        root = remove(root, e);
    }

    /**
     * @param node
     * @param e
     * @return 删除节点后新的二分搜索树的根
     */
    private Node remove(Node node, E e) {
        if (node == null) {
            return null;
        }
        if (e.compareTo(node.e) < 0) {
            node.left = remove(node.left, e);
            return node;
        } else if (e.compareTo(node.e) > 0) {
            node.right = remove(node.right, e);
            return node;
            // e == node.e
        } else {
            // 待删除节点左子树为空的情况（左孩子不存在，右孩子替换到当前位置）
            if (node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            }
            // 待删除节点右子树为空的情况
            if (node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            }
            /*
             * 待删除节点左右子树均不为空的情况
             * 找到比待删除节点大的最小节点，即待删除节点右子树的最小节点
             * 用这个节点顶替待删除节点的位置
             */
            Node successor = minimum(node.right);
            successor.right = removeMin(node.right);
//            size++;
            successor.left = node.left;
            node.left = node.right = null;
//            size--;
            return successor;
        }
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        generaterBSTString(root, 0, res);
        return res.toString();
    }

    //生成以node为根节点深度为depth的描述二叉树的字符串
    private void generaterBSTString(Node node, int depth, StringBuilder res) {
        if (node == null) {
            res.append(generaterDepthStr(depth) + "null\n");
            return;
        }
        res.append(generaterDepthStr(depth) + node.e + "\n");
        generaterBSTString(node.left, depth + 1, res);
        generaterBSTString(node.right, depth + 1, res);
    }

    private String generaterDepthStr(int depth) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            res.append("--");
        }
        return res.toString();
    }


}

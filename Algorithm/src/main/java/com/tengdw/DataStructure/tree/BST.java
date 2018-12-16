package com.tengdw.DataStructure.tree;

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
    private int size;

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

    public void inOrder() {
        inOrder(root);
    }
    //中序遍历
    private void inOrder(Node node) {
        if (node == null)
            return;
        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    public void postOrder() {
        postOrder();
    }
    //后序遍历
    private void postOrder(Node node) {
        if (node == null)
            return;
        inOrder(node.left);
        inOrder(node.right);
        System.out.println(node.e);
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

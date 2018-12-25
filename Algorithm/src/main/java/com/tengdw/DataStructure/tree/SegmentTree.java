package com.tengdw.DataStructure.tree;

/**
 * 线段树
 *
 * @author: Tengdw t_dw@qq.com
 * @create: 2018-12-24 21:52
 **/
public class SegmentTree<E> {

    private E[] tree; //满二叉树的数组表示
    private E[] data;
    private Merge<E> merge;

    public SegmentTree(E[] arr, Merge<E> merge) {
        this.merge = merge;
        data = (E[]) new Object[arr.length];
        for (int i = 0; i < arr.length; i++)
            data[i] = arr[i];
        //数组 data 和他相对应的线段树，该线段树占用的空间最大是data的4倍
        tree = (E[]) new Object[4 * arr.length];
        buildSegmentTree(0, 0, data.length - 1);
    }

    /**
     * 在 treeIndex 的位置创建表示区间[l..r]的线段树
     *
     * @param treeIndex
     * @param l         左端点
     * @param r         右端点
     */
    private void buildSegmentTree(int treeIndex, int l, int r) {
        if (l == r) {
            tree[treeIndex] = data[l];
            return;
        }
        //treeIndex所表示的节点的两个孩子节点的索引
        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);
        int mid = l + (r - l) / 2;
        buildSegmentTree(leftTreeIndex, l, mid);
        buildSegmentTree(rightTreeIndex, mid + 1, r);
        //两个小线段->当前线段
        tree[treeIndex] = merge.merge(tree[leftTreeIndex], tree[rightTreeIndex]);
    }

    public int getSize() {
        return data.length;
    }

    public E get(int index) {
        if (index < 0 || index >= data.length)
            throw new IllegalArgumentException("Index is illegal.");
        return data[index];
    }

    /**
     * 返回完全二叉树的数组表示中，索引 index 左孩子节点的索引
     *
     * @param index 索引
     * @return 索引 index 左孩子节点的索引
     */
    private int leftChild(int index) {
        return 2 * index + 1;
    }

    /**
     * 返回完全二叉树的数组表示中，索引 index 右孩子节点的索引
     *
     * @param index 索引
     * @return 索引 index 右孩子节点的索引
     */
    private int rightChild(int index) {
        return 2 * index + 2;
    }

    /**
     * 返回 [queryL, queryR] 的值
     *
     * @param queryL
     * @param queryR
     * @return
     */
    public E query(int queryL, int queryR) {
        if (queryL < 0 || queryL >= data.length ||
                queryR < 0 || queryR >= data.length || queryL > queryR)
            throw new IllegalArgumentException("Index is illegal.");
        return query(0, 0, data.length - 1, queryL, queryR);
    }

    /**
     * 在以treeID为根的线段树中[l, r]的范围里，搜索区间[queryL, queryR]的值
     */
    private E query(int treeIndex, int l, int r, int queryL, int queryR) {
        if (l == queryL && r == queryR)
            return tree[treeIndex];
        int mid = l + (l + r) / 2;
        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);
        // 要查找的最左边界比当前节点的右孩子节点的最左边界要大，
        // 则需要去右孩子中继续查找
        if (queryL >= mid + 1)
            return query(rightTreeIndex, mid + 1, r, queryL, queryR);
        // 要查找的最右边界比当前节点的左孩子节点的最右边界要小，
        // 则需要去左孩子中继续查找
        else if (queryR <= mid)
            return query(leftTreeIndex, l, mid, queryL, queryR);
        // 要查找的最右边界在当前节点的右孩子节点中 要查找的最左边界在当前节点的左孩子节点中
        E leftResult = query(leftTreeIndex, l, mid, queryL, mid);
        E rightResult = query(rightTreeIndex, mid + 1, r, mid + 1, queryR);
        // 合并结果
        return merge.merge(leftResult, rightResult);
    }

    /**
     * 将 index 位置的值更新为e
     * @param index
     * @param e
     */
    public void set(int index, E e) {
        if (index < 0 || index >= data.length)
            throw new IllegalArgumentException("Index is illegal.");
        data[index] = e;
        /**维护tree{@link tree}*/
        set(0, 0, data.length - 1, index, e);
    }

    /**
     * 维护tree{@link SegmentTree#tree}
     * 在以treeIndex为根的线段树中更新index的值为e
     * @param treeIndex
     * @param l
     * @param r
     * @param index
     * @param e
     */
    private void set(int treeIndex, int l, int r, int index, E e) {
        if (l == r) {
            tree[treeIndex] = e;
            return;
        }
        int mid = l + (r - l) / 2;
        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);
        // 与 query() 的逻辑差不多
        if (index >= mid + 1) {
            set(rightTreeIndex, mid + 1, r, index, e);
        } else { // index <= mid
            set(leftTreeIndex, l, mid, index, e);
        }
        tree[treeIndex] = merge.merge(tree[leftTreeIndex], tree[rightTreeIndex]);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append('[');
        for (int i = 0; i < tree.length; i++) {
            if (tree[i] != null)
                res.append(tree[i]);
            else
                res.append("null");

            if (i != tree.length - 1)
                res.append(", ");
        }
        res.append(']');
        return res.toString();
    }
}

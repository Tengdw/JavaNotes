package com.tengdw.DataStructure.heap;

import com.tengdw.DataStructure.array.Array;

/**
 * 最大堆 (基于数组实现)
 *
 * @author: Tengdw t_dw@qq.com
 * @create: 2018-12-22 23:26
 **/
public class MaxHeap<E extends Comparable<E>> {

    private Array<E> data;

    public MaxHeap(int capaCity) {
        data = new Array<>(capaCity);
    }

    public MaxHeap() {
        data = new Array<>();
    }

    //heapify 将任意数组整理成堆的形状
    //将非叶子节点的所有节点逐个进行下沉操作，最后可以构建成一个堆
    public MaxHeap(E[] arr) {
        data = new Array<>(arr);
        for (int i = parent(arr.length - 1); i >= 0; i--)
            siftDowm(i);
    }

    /**
     * 堆中的元素个数
     *
     * @return
     */
    public int size() {
        return data.getSize();
    }

    /**
     * 堆是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return data.isEmpty();
    }

    /**
     * 获取index的父节点在数组中的索引
     *
     * @param index
     * @return
     */
    private int parent(int index) {
        if (index == 0)
            throw new IllegalArgumentException("index-0 doesn't hava parent.");
        return (index - 1) / 2;
    }

    /**
     * 返回完全二叉树的数组表示中，一个索引所表示的元素的左孩子节点的索引
     *
     * @param index
     * @return
     */
    private int leftChild(int index) {
        return index * 2 + 1;
    }

    /**
     * 返回完全二叉树的数组表示中，一个索引所表示的元素的右孩子节点的索引
     *
     * @param index
     * @return
     */
    private int rightChild(int index) {
        return index * 2 + 2;
    }

    /**
     * 像堆中添加元素
     *
     * @param e
     */
    public void add(E e) {
        data.addLast(e);
        //维护最大堆
        siftUp(data.getSize() - 1);
    }

    //“上浮”元素
    private void siftUp(int k) {
        //父节点小于当前节点，当前节点需要上浮（即与父节点交换位置）
        while (k > 0 && data.get(parent(k)).compareTo(data.get(k)) < 0) {
            data.swap(k, parent(k));
            //进行下一轮与父节点的比较
            k = parent(k);
        }
    }

    /**
     * 看堆中的最大元素
     *
     * @return
     */
    public E findMax() {
        if (data.getSize() == 0)
            throw new IllegalArgumentException("Can not findMax when heap is empty");
        return data.get(0);
    }

    /**
     * 取出堆中最大元素
     *
     * @return
     */
    public E extractMax() {
        E ret = findMax();
        data.swap(0, data.getSize() - 1);
        data.removeLast();
        siftDowm(0);
        return ret;
    }

    /**
     * 元素“下沉”维护堆，取出堆中的最大元素(data[0])后我们将堆中最小的元素交换过来，
     * 此时堆顶的元素最小，“下沉”也就是将这个堆顶的元素与最大的孩子节点做交换
     *
     * @param k
     */
    private void siftDowm(int k) {
        while (leftChild(k) < data.getSize()) {
            //得到k的左孩子的索引
            int j = leftChild(k);
            //右孩子存在并且右孩子大于左孩子
            if (j + 1 < data.getSize() && data.get(j + 1).compareTo(data.get(j)) > 0)
                j++;//即j = rightChild(k)
            // data[j] 是 leftChild 和 rightChild 中的最大值
            //比较data[k]与最大孩子的大小，大于或等于则满足堆的性质,否则交换位置进行下一轮“下沉”
            if (data.get(k).compareTo(data.get(j)) >= 0)
                break;
            data.swap(k, j);
            k = j;
        }
    }

    /**
     * 取出堆中最大的元素，并替换成元素e
     * @param e
     * @return
     */
    public E replace(E e) {
        E ret = findMax();
        data.set(0, e);
        siftDowm(0);
        return ret;
    }

}

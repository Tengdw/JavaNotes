package com.tengdw.DataStructure.queue;

import com.tengdw.DataStructure.heap.MaxHeap;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;

/**
 * 优先队列 基于堆实现
 * @author: Tengdw t_dw@qq.com
 * @create: 2018-12-23 15:53
 **/
public class PriorityQueue<E extends Comparable<E>> implements Queue<E> {

    private MaxHeap<E> maxHeap;

    public PriorityQueue() {
        maxHeap = new MaxHeap<>();
    }

    @Override
    public void enqueue(E e) {
        maxHeap.add(e);
    }

    @Override
    public E dequeue() {
        return maxHeap.extractMax();
    }

    @Override
    public E getFront() {
        return maxHeap.findMax();
    }

    @Override
    public int getSize() {
        return maxHeap.size();
    }

    @Override
    public boolean isEmpty() {
        return maxHeap.isEmpty();
    }
}

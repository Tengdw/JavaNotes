package com.tengdw.LeetCode;

/**
 * 设计循环队列
 *
 * @author Tengdw t_dw@qq.com
 * @description
 * @date 2019/1/7 17:58
 */
public class LeetCode622 {
    class MyCircularQueue {

        private int[] data;
        private int size;
        private int front, tail;

        /** Initialize your data structure here. Set the size of the queue to be k. */
        public MyCircularQueue(int k) {
            data = new int[k];
            size = 0;
            front = 0;
            tail = 0;
        }

        /** Insert an element into the circular queue. Return true if the operation is successful. */
        public boolean enQueue(int value) {
            if (isFull()) return false;
            return true;
        }

        /** Delete an element from the circular queue. Return true if the operation is successful. */
        public boolean deQueue() {
            if (isEmpty()) return false;
            return true;
        }

        /** Get the front item from the queue. */
        public int Front() {
            if (isEmpty()) return -1;
            return data[front];
        }

        /** Get the last item from the queue. */
        public int Rear() {
            if (isEmpty()) return -1;
            return data[front];
        }

        /** Checks whether the circular queue is empty or not. */
        public boolean isEmpty() {
            return front == tail;
        }

        /** Checks whether the circular queue is full or not. */
        public boolean isFull() {
            return size == data.length;
        }
    }
}

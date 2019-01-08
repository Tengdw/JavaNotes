package com.tengdw.LeetCode;

import org.junit.Test;

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
        // tail 为最后一个元素的下一个索引，preTail 为最后一个元素的索引
        private int front, tail, preTail;

        /** Initialize your data structure here. Set the size of the queue to be k. */
        public MyCircularQueue(int k) {
            data = new int[k + 1];
            size = 0;
            front = 0;
            tail = preTail = 0;
        }

        /** Insert an element into the circular queue. Return true if the operation is successful. */
        public boolean enQueue(int value) {
            if (isFull()) return false;
            data[tail] = value;
            preTail = tail;
            tail = (tail + 1) % data.length;
            size++;
            return true;
        }

        /** Delete an element from the circular queue. Return true if the operation is successful. */
        public boolean deQueue() {
            if (isEmpty()) return false;
            data[front] = 0;
            front = (front + 1) % data.length;
            size--;
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
            return data[preTail];
        }

        /** Checks whether the circular queue is empty or not. */
        public boolean isEmpty() {
            return front == tail;
        }

        /** Checks whether the circular queue is full or not. */
        public boolean isFull() {
            return size == data.length - 1;
        }
    }

    @Test
    public void test() {
        MyCircularQueue circularQueue = new MyCircularQueue(3);
        System.out.println(circularQueue.enQueue(1));  // 返回true

        System.out.println(circularQueue.enQueue(2));  // 返回true

        System.out.println(circularQueue.enQueue(3));  // 返回true

        System.out.println(circularQueue.enQueue(4));  // 返回false,队列已满

        System.out.println(circularQueue.Rear());  // 返回3

        System.out.println(circularQueue.isFull());  // 返回true

        System.out.println(circularQueue.deQueue());  // 返回true

        System.out.println(circularQueue.enQueue(4));  // 返回true

        System.out.println(circularQueue.Rear());  // 返回4
    }
}

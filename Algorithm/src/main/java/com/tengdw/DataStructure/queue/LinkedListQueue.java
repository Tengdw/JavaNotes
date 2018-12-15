package com.tengdw.DataStructure.queue;

import com.tengdw.DataStructure.LinkedList.LinkedList;

/**
 * 使用链表实现队列
 * @author: Tengdw t_dw@qq.com
 * @create: 2018-12-12 23:27
 **/
public class LinkedListQueue<E> implements Queue<E> {

    private class Node {
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node head, tail;
    private int size;

    public LinkedListQueue() {
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * 入队操作，从链表尾入队
     * @param e
     */
    @Override
    public void enqueue(E e) {
        // 当队列为空时
        if (tail == null) {
            tail = new Node(e);
            head = tail;
        } else {
            tail.next = new Node(e);
            tail = tail.next;
        }
        size++;
    }

    /**
     * 出队操作，从链表头部入队
     * @return
     */
    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Can not dequeue from an empty queue.");
        }
        Node retNode = head;
        head = head.next;
        //删除已经出队的head的next引用
        retNode.next = null;
        //考虑到出队后链表中没有元素
        if (head == null) {
            tail = null;
        }
        size--;
        return retNode.e;
    }

    @Override
    public E getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Queue is empty.");
        }
        return head.e;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Queue: front [");
        Node cur = head;
        while (cur != null) {
            res.append(cur + "->");
            cur = cur.next;
        }
        res.append("NULL");
        res.append("] tail");
        return res.toString();
    }
}

package com.tengdw.DataStructure.queue;

/**
 * @author: Tengdw t_dw@qq.com
 * @create: 2018-12-09 12:59
 **/
public interface Queue<E> {
    /**
     * 入队
     * @param e
     */
    void enqueue(E e);

    /**
     * 出队
     * @return
     */
    E dequeue();

    /**
     * 获取队首元素
     * @return
     */
    E getFront();

    int getSize();

    boolean isEmpty();
}

package com.tengdw.DataStructure.stack;

/**
 * @author: Tengdw t_dw@qq.com
 * @create: 2018-12-09 11:08
 **/
public interface Stack<E> {
    int getSize();
    boolean isEmpty();
    void push(E e);
    E pop();
    E peek();
}

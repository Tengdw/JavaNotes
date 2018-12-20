package com.tengdw.DataStructure.set;

/**
 * @author: Tengdw t_dw@qq.com
 * @create: 2018-12-17 22:59
 **/
public interface Set<E> {

    void add(E e);
    void remove(E e);
    boolean contains(E e);
    int getSize();
    boolean isEmpty();
}

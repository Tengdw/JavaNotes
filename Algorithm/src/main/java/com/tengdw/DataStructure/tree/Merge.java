package com.tengdw.DataStructure.tree;

/**
 * 线段树两个小线段的合并操作
 * @author: Tengdw t_dw@qq.com
 * @create: 2018-12-24 22:25
 **/
public interface Merge<E> {

    E merge(E a, E b);
}

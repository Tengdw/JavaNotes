package com.tengdw.DataStructure.set;

import com.tengdw.DataStructure.tree.BST;

/**
 * 基于二分搜索树的集合，元素不能重复
 * @author: Tengdw t_dw@qq.com
 * @create: 2018-12-17 23:00
 **/
public class BSTSet<E extends Comparable<E>> implements Set<E> {

    private BST<E> bst;

    public BSTSet() {
        bst = new BST<>();
    }

    @Override
    public void add(E e) {
        bst.add(e);
    }

    @Override
    public void remove(E e) {
        bst.remove(e);
    }

    @Override
    public boolean contains(E e) {
        return bst.contains(e);
    }

    @Override
    public int getSize() {
        return bst.size;
    }

    @Override
    public boolean isEmpty() {
        return bst.isEmpty();
    }
}

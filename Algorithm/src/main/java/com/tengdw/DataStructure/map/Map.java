package com.tengdw.DataStructure.map;

/**
 * @author: Tengdw t_dw@qq.com
 * @create: 2018-12-20 23:17
 **/
public interface Map<K, V> {

    void add(K key, V value);

    V remove(K key);

    boolean contains(K key);

    V get(K key);

    void set(K key, V value);

    int getSize();

    boolean isEmpty();
}

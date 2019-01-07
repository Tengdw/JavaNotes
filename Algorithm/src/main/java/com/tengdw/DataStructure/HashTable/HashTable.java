package com.tengdw.DataStructure.HashTable;

import java.util.Hashtable;
import java.util.Map;
import java.util.TreeMap;

/**
 * 哈希表
 *
 * @author: Tengdw t_dw@qq.com
 * @create: 2019-01-01 19:39
 **/
public class HashTable<K, V> {

    private static final int[] capacity = {53, 97, 193, 389, 769, 1543, 3079, 6151, 12289, 24593, 49157,
            98317, 196613, 393241, 786433, 1572869, 3145739, 6291469, 12582917, 25165843, 50331653,
            10663319, 201326611, 402653189, 805306457, 1610612741};

    //数组最大容量(upperTol * M)和最小容量(lowerTol * M)
    private static final int upperTol = 10;
    private static final int lowerTol = 2;
    private int capacityIndex = 0;

    private TreeMap<K, V>[] hashtable;
    private int M; //hashtable的长度
    private int size; //元素数量

    public HashTable() {
        this.M = capacity[capacityIndex];
        size = 0;
        hashtable = new TreeMap[M];
        for (int i = 0; i < M; i++)
            hashtable[i] = new TreeMap<>();
    }

    public int getSize() {
        return size;
    }

    public void add(K key, V value) {
        TreeMap<K, V> map = hashtable[hash(key)];
        if (map.containsKey(key)) {
            map.put(key, value);
        } else {
            map.put(key, value);
            size++;
            if (size >= upperTol * M && capacityIndex + 1 < capacity.length) {
                capacityIndex++;
                resize(capacity[capacityIndex]);
            }
        }
    }

    public V remove(K key) {
        TreeMap<K, V> map = hashtable[hash(key)];
        V ret = null;
        if (map.containsKey(key)) {
            ret = map.remove(key);
            size--;
            if (size < lowerTol * M && capacityIndex - 1 >= 0) {
                capacityIndex--;
                resize(capacity[capacityIndex]);
            }
        }
        return ret;
    }

    public void set(K key, V value) {
        TreeMap<K, V> map = hashtable[hash(key)];
        if (!map.containsKey(key))
            throw new IllegalArgumentException(key + " doesn't exist!");
        map.put(key, value);
    }

    public boolean contains(K key) {
        return hashtable[hash(key)].containsKey(key);
    }

    public V get(K key) {
        return hashtable[hash(key)].get(key);
    }

    private int hash(K key) {
        return (key.hashCode() & 0x7FFFFFFF) % M;
    }

    private void resize(int newM) {
        TreeMap<K, V>[] newHashTable = new TreeMap[newM];
        //初始化行的treeMap数组
        for (int i = 0; i < newM; i++)
            newHashTable[i] = new TreeMap<>();
        int oldM = M;
        this.M = newM;
        for (int i = 0; i < oldM; i++) {
            TreeMap<K, V> map = hashtable[i];
            for (Map.Entry<K, V> entry : map.entrySet()) {
                newHashTable[hash(entry.getKey())].put(entry.getKey(), entry.getValue());
            }
        }
    }
}

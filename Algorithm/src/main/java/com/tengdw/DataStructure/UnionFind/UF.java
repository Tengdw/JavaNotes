package com.tengdw.DataStructure.UnionFind;

/**
 * 并查集
 *
 * @author: Tengdw t_dw@qq.com
 * @create: 2018-12-27 22:45
 **/
public interface UF {

    int getSize();

    /**
     * 两个元素是否是相连的
     * @param p
     * @param q
     * @return
     */
    boolean isConnected(int p, int q);

    /**
     * 将两个元素合并在同一个集合中
     * @param p
     * @param q
     */
    void unionElements(int p, int q);
}

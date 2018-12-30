package com.tengdw.DataStructure.UnionFind;

/**
 * 这一版的并查集实现中 parent[i] 存放的是指针，指向元素所在的集合
 * i 存放的是真正的值
 *
 * @author: Tengdw t_dw@qq.com
 * @create: 2018-12-27 22:55
 **/
public class UnionFind implements UF {

    private int[] parent;
    private int[] rank; //sz[i]表示以i为根的集合所表示的树的层数

    public UnionFind(int size) {
        parent = new int[size];
        rank = new int[size];
        // 初始化, 每一个id[i]指向自己, 没有合并的元素
        for (int i = 0; i < size; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    @Override
    public int getSize() {
        return parent.length;
    }

    /**
     * 查找元素p所对应的集合编号
     * O(h)复杂度 h为树的高度
     *
     * @param p
     * @return
     */
    private int find(int p) {
        if (p < 0 && p >= parent.length)
            throw new IllegalArgumentException("p is out of bound.");
        if (p != parent[p])
            // 路径压缩 子节点全部指向根节点
            parent[p] = find(parent[p]);
        return parent[p];
    }

    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }


    @Override
    public void unionElements(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot)
            return;
        //将rank低的集合合并到rank高的集合
        if (rank[pRoot] < rank[qRoot]) {
            parent[pRoot] = qRoot;
        } else if (rank[pRoot] > rank[qRoot]) {
            parent[qRoot] = pRoot;
        } else {// sz[pRoot] = sz[qRoot]
            parent[qRoot] = pRoot;
            rank[pRoot] += 1;
        }
    }
}

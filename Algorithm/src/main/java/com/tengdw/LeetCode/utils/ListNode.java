package com.tengdw.LeetCode.utils;

/**
 * @author Tengdw t_dw@qq.com
 * @description
 * @date 2018/12/19 10:24
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }
    @Override
    public String toString(){

        StringBuilder s = new StringBuilder();
        ListNode cur = this;
        while(cur != null){
            s.append(cur.val + "->");
            cur = cur.next;
        }
        s.append("NULL");
        return s.toString();
    }
}

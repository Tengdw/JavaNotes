package com.tengdw.LeetCode;

/**
 * 求众数 https://leetcode-cn.com/problems/majority-element/
 * 参考： http://www.cnblogs.com/grandyang/p/4233501.html
 * @author Tengdw t_dw@qq.com
 * @date 2018/10/15 17:54
 */
public class LeetCode169 {
    public static void main(String[] args) {
        int[] ints = new int[]{3,2,3};
        int i = majorityElement(ints);
        System.out.println(i);
    }
    public static int majorityElement(int[] nums) {
        int res = 0, count = 0;
        for (int num : nums) {
            if (num == res) {
                count++;
            } else if (count == 0) {
                res = num;
                count = 1;
            }else {
                count--;
            }
        }
        return res;
    }
}

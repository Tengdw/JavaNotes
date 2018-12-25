package com.tengdw.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * 求众数
 * https://leetcode-cn.com/problems/majority-element/
 * 参考：http://www.cnblogs.com/grandyang/p/4606822.html
 * @author Tengdw t_dw@qq.com
 * @date 2018/10/15 17:22
 */
public class LeetCode229 {
    public static void main(String[] args) {
        int[] ints = new int[]{1,1,1,3,3,2,2,2};
        List<Integer> list = majorityElement(ints);
        System.out.println(list.toString());
    }
    public static List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        // 任意一个数组出现次数大于n/3的众数最多有两个 m n 记录那两个数 cm cn 记录出现的次数
        int m = 0, n = 0, cm = 0, cn = 0;
        // 第一次循环得到数组中出现次数最多的两个数
        for (int num : nums) {
            if (num == m) {
                cm++;
            } else if (num == n) {
                cn++;
            } else if (cm == 0) {
                m = num;
                cm = 1;
            } else if (cn == 0) {
                n = num;
                cn = 1;
            } else {
                cm--;
                cn--;
            }
        }
        // 第二次循环得到两个数在数组中出现的次数
        cm = cn = 0;
        for (int num : nums) {
            if (num == m) {
                cm++;
            } else if (num == n) {
                cn++;
            }
        }
        if (cm > nums.length / 3) {
            res.add(m);
        }
        if (cn > nums.length / 3) {
            res.add(n);
        }
        return res;
    }
}

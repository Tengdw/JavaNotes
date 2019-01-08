package com.tengdw.LeetCode;

import org.junit.Test;

/**
 * 计算各个位数不同的数字个数
 *
 * @author Tengdw t_dw@qq.com
 * @description
 * @date 2019/1/8 11:42
 */
public class LeetCode357 {
    /*
    n
    f(0)  1
    f(1)  10   0,1,2,3...10
    f(2)  91   9*9 + f(1)    9x9+10
    f(3)  739  f(2)*8        9x9x8+10
    f(4)  5275 f(3)*7        9x9x8x7+10

    超过11位总会有两个相同的数
     */
    class Solution {
        public int countNumbersWithUniqueDigits(int n) {
            if (n == 0) return 1;
            int res = 10, t = 9;
            if (n > 10) n = 10;
            for (int i = 1; i < n; i++) {
                t *= (10 - i);
                res += t;
            }
            return res;
        }
    }

    @Test
    public void test() {
        int i = new Solution().countNumbersWithUniqueDigits(2);
        System.out.println(i);
    }
}

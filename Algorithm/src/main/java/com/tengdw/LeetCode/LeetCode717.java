package com.tengdw.LeetCode;

import org.junit.Test;

/**
 * 1比特与2比特字符
 *
 * @author: Tengdw t_dw@qq.com
 * @create: 2019-01-12 20:39
 **/
public class LeetCode717 {
    //每次遇到1，那么后面要么为0，要么为1，跳过这个数字，也就是遇到1跳偶数步，遇到0跳奇数步
    class Solution {
        public boolean isOneBitCharacter(int[] bits) {
            int i = 0;
            for (; i < bits.length - 1; i++)
                if (bits[i] == 1) i++;
            return i != bits.length;
        }
    }

    @Test
    public void test() {
        int[] bits = {1,1,1,0};
        boolean result = new Solution().isOneBitCharacter(bits);
        System.out.println(result);
    }
}

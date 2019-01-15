package com.tengdw.LeetCode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 数组的度
 *
 * @author: Tengdw t_dw@qq.com
 * @create: 2019-01-13 10:53
 **/
public class LeetCode697 {
    class Solution {
        public int findShortestSubArray(int[] nums) {
            //  元素    [出现次数，该元素的左索引，该元素的右索引]
            Map<Integer, int[]> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                int[] numMap = map.getOrDefault(nums[i], new int[3]);
                if (numMap[0] == 0)
                    numMap[1] = i;
                numMap[0]++;
                numMap[2] = i;
                map.put(nums[i], numMap);
            }
            int max = 0;//记录元素出现频数的最大值
            int len = 0;
            for (Map.Entry<Integer, int[]> entry : map.entrySet()) {
                int[] v = entry.getValue();
                if (v[0] > max) {
                    max = v[0];
                    len = v[2] - v[1];
                }
                if (v[0] == max)
                    len = v[2] - v[1] < len ? v[2] - v[1] : len;
            }
            return len + 1;
        }
    }

    @Test
    public void test() {
        int[] nums = {1,2,2,3,1,4,2};
        int i = new Solution().findShortestSubArray(nums);
        System.out.println(i);
    }
}

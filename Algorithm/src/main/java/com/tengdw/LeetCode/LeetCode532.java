package com.tengdw.LeetCode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 数组中的K-diff数对
 *
 * @author Tengdw t_dw@qq.com
 * @description
 * @date 2019/1/18 16:46
 */
public class LeetCode532 {
    class Solution {
        public int findPairs(int[] nums, int k) {
            int count = 0;
            if (k < 0) return count;
            Map<Integer, Integer> map = new HashMap<>();
            for (int num : nums)
                map.put(num, map.getOrDefault(num, 0) + 1);
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (k == 0)
                    count = entry.getValue() >= 2 ? count + 1 : count;
                else if (map.containsKey(entry.getKey() + k))
                    count++;
            }
            return count;
        }
    }

    @Test
    public void test() {
        int[] nums = {3, 1, 4, 1, 5};
        int k = 0;
        int ans = new Solution().findPairs(nums, k);
        System.out.println(ans);
    }
}

package com.tengdw.MiOJ;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Tengdw t_dw@qq.com
 * @description
 * @date 2018/12/28 17:49
 */
public class MiOJ7 {
    private static String solution(String line) {
        String[] split = line.split(",");
        int size = split.length;
        int[] nums = new int[size];
        for (int i = 0; i < size; i++)
            nums[i] = Integer.valueOf(split[i]);

        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        // int min=nums[0];
        for (int num : nums) {
            if (num > max)
                max = num;
            map.put(num, 1);
        }
        for (int i = 1; i < max; i++)
            if (map.getOrDefault(i, -1) == -1)
                return i + "";

        return max + 1 + "";
    }
}

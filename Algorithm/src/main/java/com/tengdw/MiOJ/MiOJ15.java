package com.tengdw.MiOJ;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 和为零的三元组
 * 参考 https://blog.csdn.net/qq_36573828/article/details/80985411
 *
 * @author Tengdw t_dw@qq.com
 * @description
 * @date 2018/12/29 15:01
 */
public class MiOJ15 {
    //最直接的三层遍历找和为零的 时间复杂度 O(n^3)
    private static String solution(String line) {
        String[] split = line.split(",");
        int[] nums = new int[split.length];
        for (int i = 0; i < split.length; i++)
            nums[i] = Integer.valueOf(split[i]);
        Arrays.sort(nums);
        List<String> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        String str = nums[i] + "," + nums[j] + "," + nums[k];
                        if (!result.contains(str))
                            result.add(str);
                    }
                }
            }
        }
        return result.size() + "";
    }

    public static void main(String[] args) {
        System.out.println(solution("-1,0,1,2,-1,-4"));
    }
}

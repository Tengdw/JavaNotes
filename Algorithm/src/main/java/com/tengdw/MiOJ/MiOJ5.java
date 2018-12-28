package com.tengdw.MiOJ;


import java.util.Arrays;

/**
 * 找出旋转有序数列的中间值
 *
 * @author Tengdw t_dw@qq.com
 * @description
 * @date 2018/12/28 17:14
 */
public class MiOJ5 {
    private static String solution(String line) {
        String[] split = line.split(",");
        int[] nums = new int[split.length];
        for (int i = 0; i < split.length; i++)
            nums[i] = Integer.valueOf(split[i]);
        Arrays.sort(nums);
        return nums[split.length / 2] + "";
    }

    public static void main(String[] args) {
        String solution = solution("12,13,14,5,6,7,8,9,10");
        System.out.println(solution);
    }
}

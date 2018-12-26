package com.tengdw.MiOJ;

import org.junit.Test;

/**
 * @author Tengdw t_dw@qq.com
 * @description
 * @date 2018/12/26 18:02
 */
public class MiOJ119 {
    private static String solution(String line) {
        String[] split = line.split(" ");
        int[] nums = new int[split.length];
        for (int i = 0; i < split.length; i++)
            nums[i] = Integer.valueOf(split[i]);
        int step = 0;
        if (nums.length == 1) {
            return "true";
        }
        while (step < nums.length - 1) {
            if (nums[step] == 0)
                return "false";
            step += nums[step];
            if (step >= nums.length - 1)
                return "true";
        }
        return "false";
    }

    @Test
    public void test() {
        String solution = solution("0");
        System.out.println(solution);
    }
}

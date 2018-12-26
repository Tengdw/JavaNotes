package com.tengdw.MiOJ;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 最长连续数列
 *
 * @author Tengdw t_dw@qq.com
 * @description
 * @date 2018/12/26 16:35
 */
public class MiOJ4 {
    private static String solution(String line) {
        String[] numsStr = line.split(",");
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < numsStr.length; i++)
            set.add(Integer.valueOf(numsStr[i]));
        int result = 0;
        for (int num : set) {
            if (!set.contains(num - 1)) {
                int currNum = num;
                int currStreak = 1;
                while (set.contains(currNum + 1)) {
                    currNum += 1;
                    currStreak += 1;
                }
                result = result < currStreak ? currStreak : result;
            }
        }
        return result + "";
    }

    private static String solution2(String line) {
        String[] numsStr = line.split(",");
        int[] nums = new int[numsStr.length];
        Map<Integer, Boolean> map = new HashMap<>();
        for (int i = 0; i < numsStr.length; i++) {
            Integer num = Integer.valueOf(numsStr[i]);
            map.put(num, true);
            nums[i] = num;
        }
        int result = 0;
        for (int i = 0; i < numsStr.length; i++) {
            if (map.containsKey(nums[i])) {
                map.remove(nums[i]);
                int pre = nums[i] - 1;
                int next = nums[i] + 1;
                while (map.containsKey(pre))
                    map.remove(pre--);
                while (map.containsKey(next))
                    map.remove(next++);
                int tempLength = next - pre - 1;
                result = result < tempLength ? tempLength : result;
            }
        }
        return result + "";
    }

    @Test
    public void test() {
        String solution = solution("100,4,200,1,3,2");
        System.out.println(solution);
    }
}

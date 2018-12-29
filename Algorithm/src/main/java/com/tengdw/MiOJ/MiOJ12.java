package com.tengdw.MiOJ;

/**
 * 找出可能的合的组合
 * <p>
 * 给出一组不重复的正整数，从这组数中找出所有可能的组合使其加合等于一个目标正整数 M，如：
 * <p>
 * 一组数为 1, 2, 3，目标数为 4，那么可能的加合组合为： 1, 1, 1, 1 1, 1, 2 1, 2, 1 1, 3 2, 1, 1 2, 2 3, 1
 * 注意相同的组合数字顺序不同也算一种，所以这个例子的结果是 7 种。
 *
 * 本题采用深搜，通俗的将就是枚举所有情况，我们通过递归的方式来完成。
 * 我们从右往左进行。每进行一步都有三种选择
 * 1.选择当前的数
 * 2.选择当前的数向前一位
 * 3.不选择当前的数向前以为
 *
 * @author Tengdw t_dw@qq.com
 * @description
 * @date 2018/12/29 12:02
 */
public class MiOJ12 {

    static int sum;

    private static String solution(String line) {
        String[] split = line.split(" ");
        int n = Integer.valueOf(split[1]);
        String[] numsStr = split[0].split(",");
        int min = Integer.valueOf(numsStr[0]);
        int max = Integer.valueOf(numsStr[numsStr.length - 1]);
        find(n, min, max);
        return String.valueOf(sum);
    }

    public static void find(int goal, int goal1, int goal2) {
        if (goal2 < goal1 || goal < 0)
            return;
        if (goal == 0) {
            sum++;
            return;
        }
        find(goal - goal2, goal1, goal2);
        find(goal, goal1, goal2 - 1);
        find(goal - goal2, goal1, goal2 - 1);
    }


    public static void main(String[] args) {
        String solution = solution("1,2,3 4");
        System.out.println(solution);
    }
}

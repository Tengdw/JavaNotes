package com.tengdw.MiOJ;

/**
 * 寻找归一数字
 * @author Tengdw t_dw@qq.com
 * @description
 * @date 2019/1/2 16:47
 */
public class MiOJ43 {
    private static String solution(String line) {
        if ("1".equals(line))
            return "true";
        if (line.length() == 1)
            return "false";
        char[] chars = line.toCharArray();
        int num = 0;
        for (int i = 0; i < chars.length; i++) {
            num += (chars[i] - '0') * (chars[i] - '0');
        }
        return solution(num + "");
    }

    public static void main(String[] args) {
        System.out.println(solution("500"));
    }
}

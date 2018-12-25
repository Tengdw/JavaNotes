package com.tengdw.MiOJ;

/**
 * A + B
 *
 * @author Tengdw t_dw@qq.com
 * @description
 * @date 2018/12/25 15:41
 */
public class MiOJ1 {
    private static String solution(String line) {
        // please write your code here
        String[] str = line.split(" ");
        long l = Long.valueOf(str[0]) + Long.valueOf(str[1]);
        return l + "";
        // return ans;
    }
}

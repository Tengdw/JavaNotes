package com.tengdw.MiOJ;

/**
 * 在一个有序的经过旋转的数组里查找一个数
 * @author Tengdw t_dw@qq.com
 * @description
 * @date 2018/12/29 14:55
 */
public class MiOJ14 {
    private static String solution(String line) {
        String[] split = line.split(" ");
        String n = split[1];
        String[] numsStr = split[0].split(",");
        for (int i = 0; i < numsStr.length; i++)
            if (n.equals(numsStr[i]))
                return i + "";
        return "-1";
    }

    public static void main(String[] args) {
        System.out.println(solution("4,5,6,7,0,1,2 6"));
    }
}

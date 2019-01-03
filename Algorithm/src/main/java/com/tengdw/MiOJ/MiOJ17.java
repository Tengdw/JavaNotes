package com.tengdw.MiOJ;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

/**
 * 小写数字转大写数字
 *
 * @author Tengdw t_dw@qq.com
 * @description
 * @date 2018/12/29 15:33
 */
public class MiOJ17 {

    private static String solution(String line) {
        String[] nums = new String[]{"零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖"};
        String[] units = new String[]{"", "拾", "佰", "仟", "万", "拾", "佰", "仟", "亿", "拾", "佰", "千"};
        char[] a = line.toCharArray();
        String str = "";
        if (line.length() == 1) {
            str += nums[a[0] - '0'] + "元整";
            return str;
        }
        for (int i = 0; i < a.length; i++) {
            str += nums[a[i] - '0'];
            str += units[a.length - i - 1];
        }
        str += "元整";
        str = str.replaceAll("拾零", "拾")
                .replaceAll("零拾", "零")
                .replaceAll("零佰", "零")
                .replaceAll("零仟", "零")
                .replaceAll("零万", "万");
        for (int i = 0; i < 6; i++) {
            str = str.replaceAll("零零", "零")
                    .replaceAll("零万", "万")
                    .replaceAll("零亿", "亿")
                    .replaceAll("零零", "零")
                    .replaceAll("零元", "元");
        }


        return str;
    }

    public static void main(String[] args) {
        System.out.println(solution("60133004540"));
        System.out.println(solution("0"));
    }
}

package com.tengdw.MiOJ;

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

    /*
    壹贰叁肆伍陆柒捌玖拾
           万
    89 0000   0000
       亿    万
    450  0000  0000
    654  3512  4546
    4654 1253 456
     */
    private static String solution(String line) {
        String[] nums = new String[]{"零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖", "拾"};
        String[] units = new String[]{"个", "拾", "佰", "仟", "万", "亿"};
        Stack<String> stack = new Stack<>();
        int length = line.length();
        while (length > 0) {
            String sub;
            if (length - 4 < 0) sub = line.substring(0, length);
            else sub = line.substring(length - 4, length);
            stack.push(sub);
            length -= 4;
        }
        StringBuilder sb = new StringBuilder();
        int u1 = stack.size(); //大单位
        while (!stack.isEmpty()) {
            String pop = stack.pop();
            // 2050 2005 2500 2525
            char[] temp = pop.toCharArray();
            int u = pop.length() - 1; //小单位
            for (int i = 0; i < temp.length; i++) {
                int t = Integer.valueOf(temp[i] + "");
                boolean flag = false; //百位为0 十位不为0
                if (i == temp.length - 1 && t == 0) {
                    continue;
                } else if (i == temp.length - 1) {
                    sb.append(nums[t]);
                } else if (t == 0 && i == 1) {
                    sb.append(nums[0]);
                } else if (t == 0 && i == 2) {
                    continue;
                } else {
                    sb.append(nums[t] + units[u]);
                }
                u--;
            }
            if (u1 > 1) {
                sb.append(units[2 + u1]);
            }
            u1--;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(solution("65430004540"));
    }
}

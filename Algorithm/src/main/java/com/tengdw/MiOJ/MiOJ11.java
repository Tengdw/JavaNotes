package com.tengdw.MiOJ;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 构建短字符串
 * @author Tengdw t_dw@qq.com
 * @description
 * @date 2018/12/29 11:44
 */
public class MiOJ11 {
    private static String solution(String line) {
        String[] split = line.split(" ");
        char[] charsA = split[0].toCharArray();
        char[] charsB = split[1].toCharArray();
        List<String> list = new ArrayList<>();
        if (charsA.length > charsB.length) {
            for (int i = 0; i < charsA.length; i++)
                list.add(charsA[i] + "");
            for (char c : charsB) {
                if (list.contains(c + ""))
                    list.remove(c + "");
                else
                    return "false";
            }
            return "true";
        } else {
            for (int i = 0; i < charsB.length; i++)
                list.add(charsB[i] + "");
            for (char c : charsA) {
                if (list.contains(c + ""))
                    list.remove(c + "");
                else
                    return "false";
            }
            return "true";
        }
    }

    public static void main(String[] args) {
        String solution = solution("uak areuok");
        System.out.println(solution);
    }
}

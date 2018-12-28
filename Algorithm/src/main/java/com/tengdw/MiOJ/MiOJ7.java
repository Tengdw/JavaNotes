package com.tengdw.MiOJ;

import java.util.ArrayList;

/**
 * @author Tengdw t_dw@qq.com
 * @description
 * @date 2018/12/28 17:49
 */
public class MiOJ7 {
    private static String solution(String line) {
        String[] split = line.split(" ");
        int size = split.length;
        ArrayList<Integer> list = new ArrayList<>(size);
        for (int i = 0; i < size; i++)
            list.add(Integer.valueOf(split[i]));
        while (size-- > 0) {
            Integer num = list.get(size - 1);
            if (!list.contains(num - 1)) {

            }
        }
    }
}

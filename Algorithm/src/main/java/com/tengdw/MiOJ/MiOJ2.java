package com.tengdw.MiOJ;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Tengdw t_dw@qq.com
 * @description
 * @date 2018/12/25 15:41
 */
public class MiOJ2 {
    private static String solution(String line) {
        String[] str = line.split(" ");
        List<String> list = new ArrayList<>();
        for (String s : str) {
            if (list.contains(s))
                list.remove(s);
            else
                list.add(s);
        }
        return list.get(0);
    }
}

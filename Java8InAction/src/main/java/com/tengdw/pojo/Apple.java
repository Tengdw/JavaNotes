package com.tengdw.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author Tengdw t_dw@qq.com
 * @date 2018/10/11 17:52
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Apple {

    private String color;
    private int weight;

    public static boolean isGreenApple(Apple apple) {
        return "green".equals(apple.getColor());
    }

    public static boolean isHeavyApple(Apple apple) {
        return apple.getWeight() > 150;
    }
}

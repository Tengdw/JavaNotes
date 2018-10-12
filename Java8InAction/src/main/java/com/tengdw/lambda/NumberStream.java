package com.tengdw.lambda;

import com.tengdw.pojo.Dish;

import java.util.OptionalInt;
import java.util.stream.Stream;

import static com.tengdw.pojo.Dish.menu;

/**
 * @author Tengdw t_dw@qq.com
 * @date 2018/10/12 17:52
 */
public class NumberStream {
    public static void main(String[] args) {

        //映射到数值流
        int sum = menu.stream()
                .mapToInt(Dish::getCalories) // 返回一个IntStream
                .sum();
        //转换回对象流
        Stream<Integer> integerStream = menu.stream()
                .mapToInt(Dish::getCalories)
                .boxed(); // 装箱
        OptionalInt maxCalories = menu.stream()
                .mapToInt(Dish::getCalories)
                .max();
        int max = maxCalories.orElse(1);
        System.out.println(max);
    }
}

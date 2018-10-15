package com.tengdw.lambda.session5;

import com.tengdw.pojo.Dish;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.OptionalInt;
import java.util.stream.IntStream;
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
        IntStream.range(0, 100)
                .filter(i -> i % 2 == 0)
                .forEach(System.out::print);
        System.out.println();
        /*数值流应用：勾股数 我们用new int[]{3, 4, 5} 定义一组勾股数*/
        IntStream.rangeClosed(1, 100)
                .boxed() // rangeClosed得到的是IntStream，flatMap操作返回的是Stream<T> ，这里需要把IntStream转为Stream<int>
                .flatMap(a -> IntStream.rangeClosed(a, 100) //没有必要再从1开始了，否则就会造成重复的三元数，例如(3,4,5)和(4,3,5)。
                        .mapToObj(b -> new double[]{a, b, Math.sqrt(a * a + b * b)}))
                        .filter(d -> d[2] % 1 == 0)
                .forEach(ints -> System.out.print(ints[0] + ", " + ints[1] + ", " + ints[2] + "|"));
        System.out.println();

    }
}

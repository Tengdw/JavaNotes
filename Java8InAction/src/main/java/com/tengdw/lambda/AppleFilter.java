package com.tengdw.lambda;

import com.tengdw.pojo.Apple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author Tengdw t_dw@qq.com
 * @date 2018/10/10 14:51
 */
public class AppleFilter {

    public static void main(String[] args) {
        List<Apple> inventory = Arrays.asList(new Apple("green", 50), new Apple("green", 150),
                new Apple("green", 200), new Apple("red", 50), new Apple("red", 100),
                new Apple("red", 220));
        List<Apple> appleList = filterApples(inventory, Apple::isGreenApple);
        System.out.println(appleList);
        /**过滤器*/
        // 筛选出重量大于100的苹果
        List<Apple> collect = inventory.stream()
                .filter(e -> e.getWeight() >= 100)
                .collect(Collectors.toList());
        System.out.println(collect);
        /** 比较器*/
        List<Apple> collect1 = inventory.stream()
                .sorted(Comparator.comparingInt(Apple::getWeight) // 按重量递减
                        .reversed() // 逆序
                        .thenComparing(Apple::getColor)) // 两个苹果一样重时按颜色排序
                .collect(Collectors.toList());
        System.out.println(collect1);
        inventory.sort(Comparator.comparing(Apple::getWeight));
        System.out.println(inventory);
        /**谓词复合*/
        Predicate<Apple> redApple = apple -> "red".equals(apple.getColor());
        // redApple的非
        Predicate<Apple> notRedApple = redApple.negate();
        Predicate<Apple> redAndHeavyAppleOrGreen = redApple.and(apple -> apple.getWeight() > 150)
                .or(apple -> "green".equals(apple.getColor()));

        List<Apple> collect2 = inventory.stream()
                .filter(redAndHeavyAppleOrGreen)
                .collect(Collectors.toList());
        System.out.println(collect2);
        /**函数复合*/
        Function<Integer, Integer> f = x -> x + 1;
        Function<Integer, Integer> g = x -> x * 2;
        // 相当于 f(g(x))
        Function<Integer, Integer> h1 = f.compose(g);
        // 相当于 g(f(x))
        Function<Integer, Integer> h2 = f.andThen(g);
        int result1 = h1.apply(1);
        int result2 = h2.apply(1);
        System.out.println(result1);
        System.out.println(result2);
    }




    static List<Apple> filterApples(List<Apple> inventory, Predicate<Apple> p) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple: inventory){
            if (p.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }


}

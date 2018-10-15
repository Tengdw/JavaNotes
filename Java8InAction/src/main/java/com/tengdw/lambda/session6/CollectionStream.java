package com.tengdw.lambda.session6;

import com.tengdw.pojo.Dish;

import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.tengdw.pojo.Dish.menu;

/**
 * @author Tengdw t_dw@qq.com
 * @date 2018/10/15 16:20
 */
public class CollectionStream {
    public static void main(String[] args) {
        // 菜单里有多少种菜
        Long howManyDishes = menu.stream()
                .collect(Collectors.counting());
        long howManyDishes1 = menu.stream().count();
        System.out.println(howManyDishes);

        //查找流中的最大值和最小值
        Comparator<Dish> dishComparator = Comparator.comparingInt(Dish::getCalories);
        Optional<Dish> mostCalorieDish = menu.stream().collect(Collectors.maxBy(dishComparator));

        /** 汇总*/
        Integer totalCalories = menu.stream().collect(Collectors.summingInt(Dish::getCalories));
        System.out.println(totalCalories);
        Double avgCalories = menu.stream().collect(Collectors.averagingInt(Dish::getCalories));
        System.out.println(avgCalories);
        IntSummaryStatistics statistics = menu.stream().collect(Collectors.summarizingInt(Dish::getCalories));
        System.out.println(statistics);

        /** 连接字符串*/
        //拼接所有菜名
        String shortMenu = menu.stream()
                .map(Dish::getName)
                .collect(Collectors.joining());
        System.out.println(shortMenu);
        // 拼接所有菜名 中间以 ， 分割
        shortMenu = menu.stream()
                .map(Dish::getName)
                .collect(Collectors.joining(", "));
        System.out.println(shortMenu);

        /**广义的归约汇总*/
        totalCalories = menu.stream().collect(Collectors.reducing(0,
                Dish::getCalories, (i, j) -> i + j));
        System.out.println(totalCalories);
        mostCalorieDish = menu.stream()
                .collect(Collectors.reducing((d1, d2) -> d1.getCalories() > d2.getCalories() ? d1 : d2));

    }
}

package com.tengdw.lambda.session6;

import com.tengdw.pojo.Dish;

import java.util.*;

import static com.tengdw.pojo.Dish.menu;
import static java.util.Comparator.*;
import static java.util.stream.Collectors.*;

/**
 * @author Tengdw t_dw@qq.com
 * @date 2018/10/15 16:20
 */
public class CollectionStream {
    public static void main(String[] args) {
        // 菜单里有多少种菜
        Long howManyDishes = menu.stream()
                .collect(counting());
        long howManyDishes1 = menu.stream().count();
        System.out.println(howManyDishes);

        //查找流中的最大值和最小值
        Comparator<Dish> dishComparator = comparingInt(Dish::getCalories);
        Optional<Dish> mostCalorieDish = menu.stream().collect(maxBy(dishComparator));

        /** 汇总*/
        Integer totalCalories = menu.stream().collect(summingInt(Dish::getCalories));
        System.out.println(totalCalories);
        Double avgCalories = menu.stream().collect(averagingInt(Dish::getCalories));
        System.out.println(avgCalories);
        IntSummaryStatistics statistics = menu.stream().collect(summarizingInt(Dish::getCalories));
        System.out.println(statistics);

        /** 连接字符串*/
        //拼接所有菜名
        String shortMenu = menu.stream()
                .map(Dish::getName)
                .collect(joining());
        System.out.println(shortMenu);
        // 拼接所有菜名 中间以 ， 分割
        shortMenu = menu.stream()
                .map(Dish::getName)
                .collect(joining(", "));
        System.out.println(shortMenu);

        /**广义的归约汇总*/
        totalCalories = menu.stream().collect(reducing(0,
                Dish::getCalories, (i, j) -> i + j));
        System.out.println(totalCalories);
        mostCalorieDish = menu.stream()
                .collect(reducing((d1, d2) -> d1.getCalories() > d2.getCalories() ? d1 : d2));
        totalCalories = menu.stream().collect(reducing(0, Dish::getCalories, Integer::sum));
        System.out.println(totalCalories);

        /**分组*/
        Map<Dish.Type, List<Dish>> dishesByType = menu.stream()
                .collect(groupingBy(Dish::getType));
        System.out.println(dishesByType);
        // 按照热量分组
        Map<CaloricLevel, List<Dish>> dishesByCaloricLevel = menu.stream().collect(groupingBy(dish -> groupByCaloricLevel(dish)
        ));
        System.out.println(dishesByCaloricLevel);
        /*多级分组*/
        Map<Dish.Type, Map<CaloricLevel, List<Dish>>> dishesByTypeCaloricLevel = menu.stream()
                .collect(groupingBy(Dish::getType,
                        groupingBy(dish -> groupByCaloricLevel(dish))));
        System.out.println(dishesByTypeCaloricLevel);
        /*按子组收集数据*/
        Map<Dish.Type, Long> typeCounting = menu.stream()
                .collect(groupingBy(Dish::getType, counting()));
        System.out.println(typeCounting);
        System.out.println(Long.MAX_VALUE);
        //查找每个子组中热量最高的Dish
        Map<Dish.Type, Dish> mostCaloricByType = menu.stream()
                .collect(groupingBy(Dish::getType,
                        collectingAndThen(
                                maxBy(
                                        comparingInt(Dish::getCalories)),
                                Optional::get)));
        System.out.println(mostCaloricByType);
    }

    enum CaloricLevel { DIET, NORMAL, FAT }

    public static CaloricLevel groupByCaloricLevel(Dish dish) {
        if (dish.getCalories() <= 400) {
            return CaloricLevel.DIET;
        } else if (dish.getCalories() <= 700) {
            return CaloricLevel.NORMAL;
        } else {
            return CaloricLevel.FAT;
        }
    }
}

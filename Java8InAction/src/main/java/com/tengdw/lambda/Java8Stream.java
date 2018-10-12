package com.tengdw.lambda;

import com.tengdw.pojo.Dish;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.tengdw.pojo.Dish.menu;

/**
 * @author Tengdw t_dw@qq.com
 * @date 2018/10/12 11:10
 */
public class Java8Stream {

    public static void main(String[] args) {
        List<String> collect1 = menu.stream()
                .filter(dish -> dish.getCalories() > 400) //过滤卡路里大于400的
                .sorted(Comparator.comparingInt(Dish::getCalories)) // 按卡路里顺序
                .map(Dish::getName) //提取菜名
                .collect(Collectors.toList());
        System.out.println(collect1);
        /**并行流*/
        List<String> collect2 = menu.parallelStream()
                .filter(dish -> dish.getCalories() > 400) //过滤卡路里大于400的
                .sorted(Comparator.comparingInt(Dish::getCalories)) // 按卡路里顺序
                .map(Dish::getName) //提取菜名
                .collect(Collectors.toList());
        System.out.println(collect2);
        // 分类
        Map<Dish.Type, List<Dish>> collect3 = menu.stream().collect(Collectors.groupingBy(Dish::getType));
        System.out.println(collect3);

        List<String> collect4 = menu.stream()
                .filter(dish -> dish.getCalories() > 300)
                .map(Dish::getName)
                .limit(3) //截短流
                .collect(Collectors.toList());
        System.out.println(collect4);

        /**筛选各异元素*/
        List<Integer> numbers = Arrays.asList(1, 2, 3, 1, 2, 3, 4, 5, 6);
        numbers.stream()
                .filter(n -> n % 2 == 0)
                .distinct() //会返回一个元素各异（根据流所生成元素的hashCode和equals方法实现）的流
                .forEach(System.out::println);

        /**跳过元素*/
        List<Dish> collect5 = menu.stream()
                .filter(dish -> dish.getCalories() > 300)
                .skip(2)
                .collect(Collectors.toList());
        System.out.println(collect5);

        /**映射*/
        /**对流中每一个元素应用函数*/
        //集合中每个单词的长度
        List<String> words = Arrays.asList("Java 8", "Lambdas", "In", "Action");
        List<Integer> wordLengths = words.stream()
                .map(String::length)
                .collect(Collectors.toList());
        System.out.println(wordLengths);
        // 计算每到菜菜名的长度
        List<Integer> collect6 = menu.stream()
                .map(Dish::getName)
                .map(String::length)
                .collect(Collectors.toList());
        System.out.println(collect6);

        /**流的扁平化*/
        // ["Goodbye", "World"] -> ["H","e","l", "o","W","r","d"]
        String[] arrayOfWords = {"Hello", "World"};
        Stream<String> streamOfWords = Arrays.stream(arrayOfWords);
        List<String> collect7 = Stream.of(arrayOfWords)
                .map(ward -> ward.split("")) // 将每个单词转为其字母构成的数组，这里应该有Hello和World两个流
                .flatMap(Arrays::stream) // 将各个生成流扁平化为单个流
                .distinct()
                .collect(Collectors.toList());
        System.out.println(collect7);

        /*给定两个数字列表，如何返回所有的数对呢？例如，给定列表[1, 2, 3]和列表[3, 4]，应
        该返回[(1, 3), (1, 4), (2, 3), (2, 4), (3, 3), (3, 4)]。为简单起见，你可以用有两个元素的数组来代
        表数对。*/
        List<Integer> numbers1 = Arrays.asList(1, 2, 3);
        List<Integer> numbers2 = Arrays.asList(3, 4);
        List<int[]> collect8 = numbers1.stream()
                .flatMap(i ->
                        numbers2.stream()
                                .map(j -> new int[]{i, j}))
                .collect(Collectors.toList());
        collect8.forEach(s -> System.out.print(Arrays.toString(s)));

        /*如何扩展前一个例子，只返回总和能被3整除的数对呢？例如(2, 4)和(3, 3)是可以的。*/
        numbers1.stream()
                .flatMap(i -> numbers2.stream()
                        .filter(j -> (i + j) % 3 == 0)
                        .map(j -> new int[]{i, j}))
                .collect(Collectors.toList());

        /**查找和匹配*/
        /*检查谓词是否至少匹配一个元素*/
        //anyMatch方法可以回答“流中是否有一个元素能匹配给定的谓词”
        if (menu.stream().anyMatch(Dish::isVegetarian)) {
            System.out.println("The menu is (somewhat) vegetarian friendly!!");
        }
        /*检查谓词是否匹配所有元素*/
        boolean b = menu.stream().allMatch(dish -> dish.getCalories() < 1000);
        //noneMatch与allMatch相反
        boolean b1 = menu.stream().noneMatch(dish -> dish.getCalories() < 1000);

        /*查找元素*/
        Optional<Dish> any = menu.stream().filter(Dish::isVegetarian).findAny();
    }
}

package com.tengdw.lambda.session5;

import java.util.stream.Stream;

/**
 * @author Tengdw t_dw@qq.com
 * @date 2018/10/15 15:09
 */
public class UnlimitedStream {

    public static void main(String[] args) {
        // 迭代
        Stream.iterate(0, i -> i + 2)
                .limit(10)
                .forEach(System.out::println);

        /**
         * 斐波纳契元组序列
         */
        Stream.iterate(new int[]{0, 1}, i -> new int[]{i[1], i[0] + i[1]})
                .limit(20)
                .forEach(t -> System.out.print("(" + t[0] + "," + t[1] + ")" + "|"));
        System.out.println();
        //生成
        Stream.generate(Math::random)
                .limit(5)
                .forEach(System.out::println);
    }
}

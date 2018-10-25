package com.tengdw.lambda.session8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Lambda调试
 * @author Tengdw t_dw@qq.com
 * @date 2018/10/25 16:27
 */
public class LambdaDebugging {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 1, 2, 3, 4, 5, 6);
        List<Integer> collect = numbers.stream()
                .peek(n -> System.out.println("from stream:" + n))
                .map(n -> n + 17)
                .peek(n -> System.out.println("after map:" + n))
                .filter(n -> n % 2 == 0)
                .peek(n -> System.out.println("after filter:" + n))
                .limit(3)
                .peek(n -> System.out.println("after limit:" + n))
                .collect(Collectors.toList());
        System.out.println(collect);
    }
}

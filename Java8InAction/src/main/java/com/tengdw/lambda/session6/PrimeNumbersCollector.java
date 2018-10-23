package com.tengdw.lambda.session6;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collector;

import static java.util.stream.Collector.Characteristics.IDENTITY_FINISH;

/**
 * 自定义收集器
 * 素数收集器
 * @author Tengdw t_dw@qq.com
 * @date 2018/10/23 10:36
 */
public class PrimeNumbersCollector implements Collector<Integer, Map<Boolean, List<Integer>>,
        Map<Boolean, List<Integer>>> {

    /**
     * 建立新的结果容器
     * @return
     */
    @Override
    public Supplier<Map<Boolean, List<Integer>>> supplier() {
        //实现规约过程，初始化true和false两个空列表
        return () -> new HashMap<Boolean, List<Integer>>(){{
            put(true, new ArrayList<>());
            put(false, new ArrayList<>());
        }};
    }

    /**
     * 将元素添加到结果容器
     * @return
     */
    @Override
    public BiConsumer<Map<Boolean, List<Integer>>, Integer> accumulator() {
        return (Map<Boolean, List<Integer>> acc, Integer candidate) ->
            acc.get(isPrime(acc.get(true), //将已经找到的质数列表传递给isPrime方法
                    candidate))
                    //根据isPrime方法的返回值，从Map中取质 数或非质数列表，把当前的被测数加进去
                    .add(candidate);
    }

    /**
     * 合并两个结果容器
     * @return
     */
    @Override
    public BinaryOperator<Map<Boolean, List<Integer>>> combiner() {
        return (Map<Boolean, List<Integer>> map1, Map<Boolean, List<Integer>> map2) -> {
            map1.get(true).addAll(map2.get(true));
            map1.get(false).addAll(map2.get(false));
            return map1;
        };
    }

    /**
     * 对结果容器应用最终转换
     * @return
     */
    @Override
    public Function<Map<Boolean, List<Integer>>, Map<Boolean, List<Integer>>> finisher() {
        //收集过程最后无需转换，因此用 identity 函数收尾
        return Function.identity();
    }

    /**
     * Characteristics是一个包含三个项目的枚举。
     * UNORDERED——归约结果不受流中项目的遍历和累积顺序的影响。
     *  CONCURRENT——accumulator函数可以从多个线程同时调用，且该收集器可以并行归
     * 约流。如果收集器没有标为UNORDERED，那它仅在用于无序数据源时才可以并行归约。
     *  IDENTITY_FINISH——这表明完成器方法返回的函数是一个恒等函数，可以跳过。这种
     * 情况下，累加器对象将会直接用作归约过程的最终结果。这也意味着，将累加器A不加检
     * 查地转换为结果R是安全的。
     * @return
     */
    @Override
    public Set<Characteristics> characteristics() {
        return Collections.unmodifiableSet(EnumSet.of(IDENTITY_FINISH));
    }

    /**
     * @see CollectionStream#isPrime(int) 之前这个方法是用小于测试数字平方根的数来做除数
     * 现在改为小于测试数字平方根的质数做除数，如果出现取余等于0则这个数不是质数
     * @param primes
     * @param candidate
     * @return
     */
    public boolean isPrime(List<Integer> primes, int candidate) {
        int candidateRoot = (int) Math.sqrt(candidate);
        return takeWhile(primes, i -> i <= candidateRoot)
                .stream()
                .noneMatch(p -> candidate % p == 0);
    }

    public <A> List<A> takeWhile(List<A> list, Predicate<A> p) {
        int i = 0;
        for (A item : list) {
            // 检查当前项目时候满足谓词（item <= candidateRoot）
            if (!p.test(item)) {
                //如果不满足，返回该项目之前的前缀子列表
                return list.subList(0, i);
            }
            i++;
        }
        return list;
    }
}
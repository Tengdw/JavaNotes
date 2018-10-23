package com.tengdw.lambda.session7;

import java.util.concurrent.ForkJoinPool;
import java.util.function.Function;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class ParallelStream {

    public static void main(String[] args) {
        System.out.println("Sequential sum done in:" +
                measureSumPerf(ParallelStream::sequentialSum, 10_000_000) + " msecs");
        System.out.println("iterativeSum sum done in:" +
                measureSumPerf(ParallelStream::iterativeSum, 10_000_000) + " msecs");
        System.out.println("parallelSum sum done in:" +
                measureSumPerf(ParallelStream::parallelSum, 10_000_000) + " msecs");
        System.out.println("parallelRangedSum sum done in:" +
                measureSumPerf(ParallelStream::parallelRangedSum, 10_000_000) + " msecs");
        System.out.println("forkJoinSum sum done in:" +
                measureSumPerf(ParallelStream::forkJoinSum, 10_000_000) + " msecs");
    }


    public static long measureSumPerf(Function<Long, Long> adder, long n) {
        long fastest = Long.MAX_VALUE;
        for (int i = 0; i < 10; i++) {
            long start = System.nanoTime();
            long sum = adder.apply(n);
            long duration = (System.nanoTime() - start) / 1_000_000;
//            System.out.println("Result: " + sum);
            if (duration < fastest) fastest = duration;
        }
        return fastest;
    }
    /**
     * 求 1~n 所有数字的和
     * @param n
     * @return
     */
    public static long sequentialSum(long n) {
        return Stream.iterate(1L, i -> i+1)
                .limit(n)
                .reduce(0L, Long::sum);
    }

    public static long iterativeSum(long n) {
        long result = 0;
        for (long i = 1L; i <= n; i++) {
            result += i;
        }
        return result;
    }

    /**使用并行流*/
    /* 实际上这个执行时间最长
         iterate生成的是装箱的对象，必须拆箱成数字才能求和；
         我们很难把iterate分成多个独立块来并行执行。
    */
    public static long parallelSum(long n) {
        return Stream.iterate(1L, i -> i+1)
                .limit(n)
                .parallel()
                .reduce(0L, Long::sum);
    }

    public static long parallelRangedSum(long n) {
        return LongStream.rangeClosed(1, n)
                .parallel()
                .reduce(0L, Long::sum);
    }

    public static long forkJoinSum(long n) {
        long[] numbers = LongStream.rangeClosed(1, n).toArray();
        ForkJoinSumCalculator task = new ForkJoinSumCalculator(numbers);
        return new ForkJoinPool().invoke(task);
    }
}

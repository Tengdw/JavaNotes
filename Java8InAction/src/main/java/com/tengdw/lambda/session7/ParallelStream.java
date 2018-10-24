package com.tengdw.lambda.session7;

import java.util.concurrent.ForkJoinPool;
import java.util.function.Function;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class ParallelStream {

    final static String SENTENCE =
            " Nel mezzo del cammin di nostra vita " +
                    "mi ritrovai in una selva oscura" +
                    " ché la dritta via era smarrita ";

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
        //迭代式字数统计
        System.out.println("Found " + countWordsIteratively(SENTENCE) + " words");
        //使用流来统计
        Stream<Character> stream = IntStream.range(0, SENTENCE.length())
                .mapToObj(SENTENCE::charAt);
        System.out.println("Found " + countWords(stream) + " words");
        //这种写法会出错
//        System.out.println("Found " + countWords(stream.parallel()) + " words");
        //实现Spliterator来统计字数
        WordCounterSpliterator spliterator = new WordCounterSpliterator(SENTENCE);
        Stream<Character> spliteratorStream = StreamSupport.stream(spliterator, true);
        System.out.println("Found " + countWords(spliteratorStream) + " words");

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

    /**
     * 一个迭代式字数统计方法
     * @param s
     * @return
     */
    private static int countWordsIteratively(String s) {
        int counter = 0;
        boolean lastSpace = true;
        for (char c : s.toCharArray()) {
            if (Character.isWhitespace(c)) {
                lastSpace = true;
            } else {
                if (lastSpace) {
                    counter++;
                }
                lastSpace = false;
            }
        }
        return counter;
    }

    /**
     * 使用流来统计字数
     * @param stream
     * @return
     */
    private static int countWords(Stream<Character> stream) {
        WordCounter wordCounter = stream.reduce(new WordCounter(0, true),
                WordCounter::accumulate, WordCounter::combine);
        return wordCounter.getCounter();
    }
}

class WordCounter {
    private final int counter;
    private final boolean lastSpace;

    public WordCounter(int counter, boolean lastSpace) {
        this.counter = counter;
        this.lastSpace = lastSpace;
    }

    /**和迭代算法一样 ，accumulate 方法一个个遍历Character*/
    public WordCounter accumulate(Character c) {
        if (Character.isWhitespace(c)) {
            return lastSpace ? this : new WordCounter(counter, true);
        } else {
            //上一个字符是空格，而当前遍历的字符不是空格时，将单词计数器加一
            return lastSpace ? new WordCounter(counter + 1, false) : this;
        }
    }

    /**合并两个WordCounter，把其计数器加起来*/
    public WordCounter combine(WordCounter wordCounter) {
        return new WordCounter(counter + wordCounter.getCounter(),
                wordCounter.lastSpace);
    }

    public int getCounter() {
        return counter;
    }
}

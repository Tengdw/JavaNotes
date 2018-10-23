package com.tengdw.lambda.session7;

import java.util.concurrent.RecursiveTask;

/**
 * 用分支/合并框架执行并行求和
 * @author Tengdw t_dw@qq.com
 * @date 2018/10/23 16:18
 */
public class ForkJoinSumCalculator extends RecursiveTask<Long> {
    //带求和的数组
    private final long[] numbers;
    //子任务处理的数组的起始位置
    private final int start;
    //子任务处理的数组的终止位置
    private final int end;

    //不再将任务分解为子任务的数组大小
    public static final long THRESHOLD = 10_000;

    public ForkJoinSumCalculator(long[] numbers) {
        this(numbers, 0, numbers.length);
    }

    public ForkJoinSumCalculator(long[] numbers, int start, int end) {
        this.numbers = numbers;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        int length = end - start;
        //数组长度小于子任务的数组大小直接计算结果
        if (length <= THRESHOLD) {
            return computeSequentially();
        }
        //创建一个子任务为数组的前一半求和
        ForkJoinSumCalculator leftTask = new ForkJoinSumCalculator(numbers,
                start, start + length/2);
        //利用另一个ForkJoinPool线程异步执行新创建的子任务
        leftTask.fork();
        ForkJoinSumCalculator rightTask = new ForkJoinSumCalculator(numbers,
                start + length/2, end);
        //同步执行第二个子任务，有可能允许进一步递归划分
        Long rightResult = rightTask.compute();
        // 读取子任务结果
        Long leftResult = leftTask.join();
        return rightResult + leftResult;
    }

    private long computeSequentially() {
        long sum = 0;
        for (int i = start; i < end; i++) {
            sum += numbers[i];
        }
        return sum;
    }
}

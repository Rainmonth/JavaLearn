package com.rainmonth.concurrent.threadpool;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.LongStream;

/**
 * @author randy
 * @date 2021/6/17 5:17 下午
 */
public class ForkJoinPoolDemo {
    public static void main(String[] args) {
        long[] numbers = LongStream.rangeClosed(1, 10000000).toArray();
        System.out.println("采用普通for循环:");
        Instant start = Instant.now();
        Calculator calculator1 = new ForLoopCalculator();
        long result = calculator1.sumUp(numbers);
        Instant end = Instant.now();
        System.out.println("result1:" + result + ", 耗时：" + Duration.between(start, end).toMillis() + "ms");

        System.out.println("采用普通线程池:");
        start = Instant.now();
        Calculator calculator2 = new ExecutorServiceCalculator();
        result = calculator2.sumUp(numbers);
        end = Instant.now();
        System.out.println("result2:" + result + ", 耗时：" + Duration.between(start, end).toMillis() + "ms");

        System.out.println("采用ForkJoinPool:");
        start = Instant.now();
        Calculator calculator3 = new ForkJoinCalculator();
        result = calculator3.sumUp(numbers);
        end = Instant.now();
        System.out.println("result3:" + result + ", 耗时：" + Duration.between(start, end).toMillis() + "ms");

        System.out.println("采用并行流：");
        start = Instant.now();
        long tempResult = LongStream.rangeClosed(1, 10000000).parallel().reduce(0, Long::sum);
        end = Instant.now();
        System.out.println("result4:" + tempResult + ", 耗时：" + Duration.between(start, end).toMillis() + "ms");
    }
}

interface Calculator {
    /**
     * 对传进来的 numbers 做求和处理
     * @param numbers 要求和的数组
     * @return 求和的结果
     */
    long sumUp(long[] numbers);
}

class ForLoopCalculator implements Calculator {

    @Override
    public long sumUp(long[] numbers) {
        long total = 0;
        for (long i : numbers) {
            // 模拟耗时操作
            total += (i / 3 * 3 / 3 * 3 / 3 * 3 / 3 * 3);
        }
        return total;
    }
}

class ExecutorServiceCalculator implements Calculator {

    private int parallism;
    private ExecutorService pool;

    public ExecutorServiceCalculator() {
        parallism = Runtime.getRuntime().availableProcessors(); // CPU的核心数 默认就用cpu核心数了
        pool = Executors.newFixedThreadPool(parallism);
    }

    //处理计算任务的线程
    private static class SumTask implements Callable<Long> {
        private long[] numbers;
        private int from;
        private int to;

        public SumTask(long[] numbers, int from, int to) {
            this.numbers = numbers;
            this.from = from;
            this.to = to;
        }

        @Override
        public Long call() {
            long total = 0;
            for (int i = from; i <= to; i++) {
                // 模拟耗时操作
                total += (numbers[i] / 3 * 3 / 3 * 3 / 3 * 3 / 3 * 3);
            }
            return total;
        }
    }


    @Override
    public long sumUp(long[] numbers) {
        List<Future<Long>> results = new ArrayList<>();

        // 把任务分解为 n 份，交给 n 个线程处理   4核心 就等分成4份呗
        // 然后把每一份都扔个一个SumTask线程 进行处理
        int part = numbers.length / parallism;
        for (int i = 0; i < parallism; i++) {
            int from = i * part; //开始位置
            int to = (i == parallism - 1) ? numbers.length - 1 : (i + 1) * part - 1; //结束位置

            //扔给线程池计算
            results.add(pool.submit(new SumTask(numbers, from, to)));
        }

        // 把每个线程的结果相加，得到最终结果 get()方法 是阻塞的
        // 优化方案：可以采用CompletableFuture来优化  JDK1.8的新特性
        long total = 0L;
        for (Future<Long> f : results) {
            try {
                total += f.get();
            } catch (Exception ignore) {
            }
        }

        return total;
    }
}

class ForkJoinCalculator implements Calculator {
    private final ForkJoinPool pool;

    public ForkJoinCalculator() {
//        ForkJoinPool 提供的公用线程池
//        this.pool = ForkJoinPool.commonPool();
        this.pool = new ForkJoinPool();
    }

    @Override
    public long sumUp(long[] numbers) {
        Long result = pool.invoke(new SumTask(numbers, 0, numbers.length - 1));
        pool.shutdown();
        return result;
    }

    private static class SumTask extends RecursiveTask<Long> {

        private final long[] numbers;
        private final int from;
        private final int to;

        public SumTask(long[] numbers, int from, int to) {
            this.numbers = numbers;
            this.from = from;
            this.to = to;
        }

        @Override
        protected Long compute() {
            if (to - from < 500000) { // 调整这个值，可以控制最终胜出子任务数量的大小
                long total = 0;
                for (int i = from; i <= to; i++) {
                    // 模拟耗时操作
                    total += (numbers[i] / 3 * 3 / 3 * 3 / 3 * 3 / 3 * 3);
                }
                return total;
            } else {
                int middle = (to + from) / 2;
                SumTask leftTask = new SumTask(numbers, from, middle);
                SumTask rightTask = new SumTask(numbers, middle + 1, to);
                leftTask.fork();
                rightTask.fork();
                return leftTask.join() + rightTask.join();
            }
        }
    }
}

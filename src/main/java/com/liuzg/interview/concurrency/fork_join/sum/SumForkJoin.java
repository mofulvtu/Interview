package com.liuzg.interview.concurrency.fork_join.sum;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
/**
 * <pre>
 *  Desc:  forkJoin 实现累加
 * </pre>
 *
 * @author liuzg
 * @date  2020/7/6 21:05
 **/
public class SumForkJoin {

    private static class SumTask extends RecursiveTask<Integer> {

        //阈值
        private final static int THRESHOLD = MakArray.ARRAY_LENGTH / 10;
        private int[] src;
        private int fromIndex;
        private int toIndex;

        public SumTask(int[] src, int fromIndex, int toIndex) {
            this.src = src;
            this.fromIndex = fromIndex;
            this.toIndex = toIndex;
        }

        @Override
        protected Integer compute() {
            if (toIndex - fromIndex < THRESHOLD) {
                int count = 0;
                for (int i = fromIndex; i <= toIndex; i++) {
//                    SleepTools.ms(2);
                    count = count + src[i];
                }
                return count;
            } else {
                int mid = (fromIndex + toIndex) / 2;
                SumTask left = new SumTask(src, fromIndex, mid);
                SumTask right = new SumTask(src, mid + 1, toIndex);
                invokeAll(left, right);
                return left.join() + right.join();
            }
        }
    }


    public static void main(String[] args) {
        int[] array = MakArray.makeArray();
        ForkJoinPool pool = new ForkJoinPool();
        SumTask task = new SumTask(array, 0, array.length - 1);

        long start = System.currentTimeMillis();
        pool.invoke(task);
        long end = System.currentTimeMillis();

        System.out.println("Fork Join 花费时间：" + (end - start) + "ms");


    }


}

package com.liuzg.interview.concurrency.fork_join.sort;

import java.util.Arrays;
import java.util.concurrent.RecursiveTask;

/**
 * <pre>
 *  Desc: forkJoin 排序
 * </pre>
 *
 * @author liuzg
 * @date 2020/7/6 23:00
 **/
public class FkSort {

    static class SumTask extends RecursiveTask<int[]> {

        private static final int THRESHOLD = 2;
        private int[] src;

        public SumTask(int[] src) {
            this.src = src;
        }

        @Override
        protected int[] compute() {
            if (src.length <= THRESHOLD) {
                return InsertSort.sort(src);
            } else {
                int mid = src.length / 2;
                SumTask left = new SumTask(Arrays.copyOfRange(src, 0, mid));
                SumTask right = new SumTask(Arrays.copyOfRange(src, mid + 1, src.length));
                invokeAll(left, right);
                int[] leftResult = left.join();
                int[] rightReult = left.join();
                return src;
            }
        }
    }

}

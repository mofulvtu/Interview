package com.liuzg.interview.concurrency.fork_join.sum;

/**
 * <pre>
 *  Desc:  单线程累加
 * </pre>
 *
 * @author liuzg
 * @date 2020/7/5 22:26
 **/
public class SumNormal {

    public static void main(String[] args) {
        int[] array = MakArray.makeArray();
        int sum = 0;

        long start = System.currentTimeMillis();
        for (int i = 0; i < array.length; i++) {
//            SleepTools.ms(2);
            sum = sum + array[i];
        }
        long end = System.currentTimeMillis();
        System.out.println("单线程花费：" + (end - start) + "ms");

    }
}

package com.liuzg.interview.concurrency.fork_join.sum;

import java.util.Random;

/**
 * <pre>
 *  Desc:  生成数组
 * </pre>
 *
 * @author liuzg
 * @date 2020/7/5 22:21
 **/
public class MakArray {

    public static final int ARRAY_LENGTH = 5000000;

    public static int[] makeArray() {
        Random random = new Random();
        int[] result = new int[ARRAY_LENGTH];
        for (int i = 0; i < ARRAY_LENGTH; i++) {
            result[i] = random.nextInt(ARRAY_LENGTH * 3);
        }
        return result;
    }
}


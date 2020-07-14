package com.liuzg.interview.concurrency.fork_join.sort;

import com.liuzg.interview.concurrency.fork_join.sum.MakArray;

import java.util.Arrays;

/**
 * <pre>
 *  Desc:  简单插入排序
 * </pre>
 *
 * @author liuzg
 * @date 2020/7/6 22:25
 **/
public class InsertSort {

    public static int[] sort(int[] array) {
        if (array.length == 0) {
            return array;
        } else {
            int currentValue;
            for (int i = 0; i < array.length - 1; i++) {
                int preIndex = i;// 已经排序的索引
                currentValue = array[i + 1];//待排序数值
                while (preIndex >= 0 && currentValue < array[preIndex]) {
                    array[preIndex + 1] = array[preIndex];
                    preIndex--;
                }
                array[preIndex + 1] = currentValue;

            }
            return array;

        }
    }


    public static void main(String[] args) {
        int[] sort = InsertSort.sort(MakArray.makeArray());
        Arrays.stream(sort).forEach(System.out::println);
    }
}

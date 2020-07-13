package com.liuzg.interview.concurrency.tools;

import com.liuzg.interview.concurrency.SleepTools;

import java.util.concurrent.CountDownLatch;

/**
 * <pre>
 *  Desc:  CountDownLatch  发令枪
 *         让线程并发执行，比如：  解析excel时，每个sheet页对应一个线程，等所有sheet页线程解析完成后在进行汇总
 *
 *         await() 等待
 *         countDown() 闩锁减一
 * </pre>
 *
 * @author liuzg
 * @date 2020/7/13 22:26
 **/
public class UseCountDownLatch {

    private static CountDownLatch latch = new CountDownLatch(6);

    private static class InitThread implements Runnable {
        @Override
        public void run() {
            System.out.println("InitThread_" + Thread.currentThread().getId() + " init work ");
            latch.countDown();
            for (int i = 0; i < 2; i++) {
                System.out.println("InitThread_" + Thread.currentThread().getId() + " continue  work ");
            }
        }
    }

    private static class BusiThread implements Runnable {
        @Override
        public void run() {
            try {
                latch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int i = 0; i < 2; i++) {
                System.out.println("BusiThread_" + Thread.currentThread().getId() + " do business ");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {

        new Thread(() -> {
            SleepTools.ms(1);
            System.out.println("Thread_" + Thread.currentThread().getId() + " step 1st......");
            latch.countDown();
            System.out.println("begin step 2nd.......");
            SleepTools.ms(1);
            System.out.println("Thread_" + Thread.currentThread().getId() + " step 2nd......");
            latch.countDown();
        }).start();

        new Thread(new BusiThread()).start();

        for (int i = 0; i < 4; i++) {
            new Thread(new InitThread()).start();
        }

        latch.await();
        System.out.println("Main finish");


    }
}

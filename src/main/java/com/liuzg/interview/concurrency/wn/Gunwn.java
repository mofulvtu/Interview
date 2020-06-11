package com.liuzg.interview.concurrency.wn;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <pre>
 *  Desc: 生产者消费者问题
 *        生产者： 枪压入子弹
 *        消费者： 枪射出子弹
 *
 *        用队列来控制每次先进先出
 * </pre>
 *
 * @author liuzg
 * @date 2020/6/11 21:36
 **/
public class Gunwn {

    private final static Queue<String> bulletClip = new LinkedList<>();

    // 生产
    public void put() {
        synchronized (this) {

            while (bulletClip.size() >= 20) {
                try {
                    System.out.println(Thread.currentThread().getName() + " find bullets is filled, now last " + bulletClip.size());
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            bulletClip.offer(String.valueOf(bulletClip.size() + 1));
            notify();
            System.out.println(Thread.currentThread().getName() + " add one bullet, now last " + bulletClip.size());
        }
    }

    //消费
    public void get() {
        synchronized (this) {
            while (bulletClip.size() <= 0) {
                try {
                    System.out.println(Thread.currentThread().getName() + " find bullets is empty");
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            String poll = bulletClip.poll();
            notify();
            System.out.println(Thread.currentThread().getName() + " remove one bullet " + poll + " now last " + bulletClip.size());
        }
    }


    static class Product implements Runnable {

        Gunwn gunwn;

        public Product(Gunwn gunwn) {
            this.gunwn = gunwn;
        }

        @Override
        public void run() {

            while (true) {
                gunwn.put();
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class Consumer implements Runnable {

        Gunwn gunwn;

        public Consumer(Gunwn gunwn) {
            this.gunwn = gunwn;
        }


        @Override
        public void run() {

            while (true) {
                gunwn.get();
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public static void main(String[] args) {
        Gunwn gunwn = new Gunwn();

        for (int i = 0; i < 5; i++) {
            new Thread(new Product(gunwn)).start();
        }

        for (int i = 0; i < 10; i++) {
            new Thread(new Consumer(gunwn)).start();
        }
    }

}

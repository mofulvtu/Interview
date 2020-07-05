package com.liuzg.interview.concurrency.pool;

import java.sql.Connection;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * <pre>
 *  Desc:  测试数据库连接池
 * </pre>
 *
 * @author liuzg
 * @date 2020/7/5 21:32
 **/
public class DBPoolTest {
    static DBPool pool = new DBPool(10);
    static CountDownLatch end;

    public static void main(String[] args) throws Exception {
        int threadNum = 50;
        int count = 20;
        end = new CountDownLatch(threadNum);
        AtomicInteger got = new AtomicInteger();
        AtomicInteger notGot = new AtomicInteger();

        for (int i = 0; i < threadNum; i++) {
            Thread thread = new Thread(new Worker(count, got, notGot), "worker_" + i);
            thread.start();
        }

        end.await();
        System.out.println("总共尝试了: " + (threadNum * count));
        System.out.println("成功连接的次数：  " + got);
        System.out.println("没拿到连接次数： " + notGot);
    }


    static class Worker implements Runnable {

        private int count;
        private AtomicInteger got;
        private AtomicInteger notGot;

        public Worker(int count, AtomicInteger got, AtomicInteger notGot) {
            this.count = count;
            this.got = got;
            this.notGot = notGot;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName());
            while (count > 0) {
                try {
                    Connection connection = pool.fetchConnection(1);
                    if (connection != null) {
                        try {
                            connection.createStatement();
                            connection.commit();
                            Thread.sleep(1);
                        } finally {
                            pool.releaseConnection(connection);
                            got.incrementAndGet();
                        }
                    } else {
                        notGot.incrementAndGet();
                        System.out.println(Thread.currentThread().getName() + " 等待超时！");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    count--;
                }
            }

            end.countDown();
        }
    }
}

package com.liuzg.interview.concurrency.threadlocal;

/**
 * <pre>
 *  Desc: 
 * </pre>
 *
 * @author liuzg
 * @date  2020/6/3 22:21
 **/
public class NoThreadLocal {
    static Integer count = new Integer(0);

    /**
     * 运行3个线程
     */
    public void StartThreadArray() {
        Thread[] runs = new Thread[3];
        for (int i = 0; i < runs.length; i++) {
            runs[i] = new Thread(new TestTask(i));
        }
        for (Thread thread : runs) {
            thread.start();
        }
    }

    /**
     * count是类属性，线程间共享。
     */
    public static class TestTask implements Runnable {
        int id;

        public TestTask(int id) {
            this.id = id;
        }

        public void run() {
            System.out.println(Thread.currentThread().getName() + ":start");
            count = count + id;
            System.out.println(Thread.currentThread().getName() + ":" + count);
        }
    }

    public static void main(String[] args) {
        NoThreadLocal test = new NoThreadLocal();
        test.StartThreadArray();
    }
}

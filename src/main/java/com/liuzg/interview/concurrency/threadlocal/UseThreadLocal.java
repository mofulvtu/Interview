package com.liuzg.interview.concurrency.threadlocal;

/**
 * <pre>
 *  Desc: ThreadLocal的使用，线程之间不影响
 * </pre>
 *
 * @author liuzg
 * @date 2020/6/3 21:52
 **/
public class UseThreadLocal {

    private static ThreadLocal<Integer> intLocal = ThreadLocal.withInitial(() -> 0);

    /**
     * 运行3个线程
     */
    public void StartThreadArray() {
        Thread[] runs = new Thread[3];
        for (int i = 0; i < runs.length; i++) {
            runs[i] = new Thread(new TestThread(i));
        }
        for (Thread thread : runs) {
            thread.start();
        }
    }

    /**
     * 类说明：测试线程，线程的工作是将ThreadLocal变量的值变化，并写回，看看线程之间是否会互相影响
     */
    public static class TestThread implements Runnable {
        int id;

        public TestThread(int id) {
            this.id = id;
        }

        public void run() {
            System.out.println(Thread.currentThread().getName() + ":start");
            Integer s = intLocal.get();
            s = s + id;
            intLocal.set(s);
            System.out.println(Thread.currentThread().getName() + ":" + intLocal.get());
            intLocal.remove();
        }
    }

    public static void main(String[] args) {
        UseThreadLocal test = new UseThreadLocal();
        test.StartThreadArray();
    }
}

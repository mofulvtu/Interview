package com.liuzg.interview.concurrency.safe_end;

/**
 * <pre>
 *  Desc:  实现接口Runnable的线程中断
 * </pre>
 *
 * @author liuzg
 * @date 2020/6/2 20:57
 **/
public class EndRunnable {

    private static class UserRunnable implements Runnable {

        @Override
        public void run() {
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println(Thread.currentThread().getName() + " is implements Runnable");
            }
            System.out.println(Thread.currentThread().getName() + " interrupt flag is " + Thread.currentThread().isInterrupted());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        UserRunnable userRunnable = new UserRunnable();
        Thread endThread = new Thread(userRunnable, "endThread");
        endThread.start();
        Thread.sleep(20);
        endThread.interrupt();
    }
}

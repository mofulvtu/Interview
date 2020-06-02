package com.liuzg.interview.concurrency.safe_end;
/**
 * <pre>
 *  Desc:  安全中断线程
 *
 * </pre>
 *
 * @author liuzg
 * @date  2020/6/2 20:55
 **/
public class EndThread {
    private static class UserThread extends Thread {

        public UserThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            String threadName = Thread.currentThread().getName();
            while (!isInterrupted()) {
                System.out.println(threadName + " is running");
                System.out.println(threadName + " inner interrupt flag =" + isInterrupted());
            }
            System.out.println(threadName + " interrupt flag =" + isInterrupted());
        }
    }

    public static void main(String[] args) throws InterruptedException{
        Thread endThread =  new UserThread("endThread");
        endThread.start();
        Thread.sleep(10);
        endThread.interrupt();//中断线程，设置线程标志位为 true
    }
}

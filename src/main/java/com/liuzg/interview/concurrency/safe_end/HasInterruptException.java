package com.liuzg.interview.concurrency.safe_end;

/**
 * <pre>
 *  Desc: 安全中断线程
 * </pre>
 *
 * @author liuzg
 * @date 2020/6/2 21:06
 **/
public class HasInterruptException {
    private static class UserThread extends Thread {

        public UserThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            while (!isInterrupted()) {
                try {

                    Thread.sleep(30);
                } catch (InterruptedException e) {
                    System.out.println(Thread.currentThread().getName() + " in InterruptedException interrupt flag " + isInterrupted());
                    // 阻塞方法会将中断标志位修改为 false
                    //interrupt();
                    e.printStackTrace();
                }

                System.out.println(Thread.currentThread().getName() + " is extend Thread");
            }
            System.out.println(Thread.currentThread().getName() + " interrupt flag =" + isInterrupted());
        }
    }

    public static void main(String[] args) throws InterruptedException{
        Thread endThread = new UserThread("hasInterruptEx");
        endThread.start();
        Thread.sleep(20);
        endThread.interrupt();//中断线程，设置线程标志位为 true
    }
}

package com.liuzg.interview.concurrency.wn;

/**
 * <pre>
 *  Desc:  测试wait/notify/notifyAll
 * </pre>
 *
 * @author liuzg
 * @date 2020/6/4 22:06
 **/
public class TestWaitNotify {
    private static Express express = new Express(0, Express.CITY);

    /*检查里程数变化的线程,不满足条件，线程一直等待*/
    private static class CheckKm extends Thread {
        @Override
        public void run() {
            express.waitKm();
        }
    }

    /*检查地点变化的线程,不满足条件，线程一直等待*/
    private static class CheckSite extends Thread {
        @Override
        public void run() {
            express.waitSite();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 3; i++) {
            new CheckKm().start();
        }
        for (int i = 0; i < 3; i++) {
            new CheckSite().start();
        }

        Thread.sleep(1000);
        express.changeKm();
        express.changeSite();
    }
}

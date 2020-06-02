package com.liuzg.interview.concurrency.vola;


import com.liuzg.interview.concurrency.SleepTools;

/**
 * <pre>
 *  Desc: volatile关键字保证可见性，无法保证原子性，适合一写多读场景
 * </pre>
 *
 * @author liuzg
 * @date 2020/6/2 22:32
 **/
public class VolatileCase {
    private static volatile boolean ready;
    private static int number;

    private static class PrintThread extends Thread {
        @Override
        public void run() {
            System.out.println("PrintThread is running.......");
            while (!ready) ;
            System.out.println("number = " + number);
        }
    }

    public static void main(String[] args) {
        new PrintThread().start();
        SleepTools.second(1);
        number = 10;
        ready = true;
        SleepTools.second(5);
        System.out.println("main is ended");
    }
}

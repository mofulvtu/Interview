package com.liuzg.interview.concurrency.syn;


import com.liuzg.interview.concurrency.SleepTools;

/**
 * <pre>
 *  Desc: 实例锁和类锁是不同的，两者可以并行
 * </pre>
 *
 * @author liuzg
 * @date  2020/6/2 22:06
 **/
public class InstanceAndClass {

    private static class SynClass extends Thread {
        @Override
        public void run() {
            System.out.println("TestClass is running...");
            synClass();
        }
    }

    private static class InstanceSyn implements Runnable {
        private InstanceAndClass SynClassAndInstance;

        public InstanceSyn(InstanceAndClass SynClassAndInstance) {
            this.SynClassAndInstance = SynClassAndInstance;
        }

        @Override
        public void run() {
            System.out.println("TestInstance is running..." + SynClassAndInstance);
            SynClassAndInstance.instance();
        }
    }

    private synchronized void instance() {
        SleepTools.second(1);
        System.out.println("synInstance is going..." + this.toString());
        SleepTools.second(1);
        System.out.println("synInstance ended " + this.toString());
    }

    /**
     * 类方法
     */
    private static synchronized void synClass() {
        SleepTools.second(1);
        System.out.println("synClass going...");
        SleepTools.second(1);
        System.out.println("synClass end");
    }

    public static void main(String[] args) {
        InstanceAndClass synClassAndInstance = new InstanceAndClass();
        Thread t1 = new SynClass();
        Thread t3 = new SynClass();
        Thread t2 = new Thread(new InstanceSyn(synClassAndInstance));
        t2.start();
        t3.start();
        SleepTools.second(1);
        t1.start();
    }
}

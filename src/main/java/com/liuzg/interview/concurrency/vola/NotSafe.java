package com.liuzg.interview.concurrency.vola;

/**
 * <pre>
 *  Desc: volatile关键字保证可见性，无法保证原子性，适合一写多读场景
 * </pre>
 *
 * @author liuzg
 * @date 2020/6/2 22:38
 **/
public class NotSafe {
    private volatile long count = 0;

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    //count进行累加
    public void incCount() {
        count++;
    }

    //线程
    private static class Count extends Thread {

        private NotSafe simplOper;

        public Count(NotSafe simplOper) {
            this.simplOper = simplOper;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10000; i++) {
                simplOper.incCount();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        NotSafe simplOper = new NotSafe();
        //启动两个线程
        Count count1 = new Count(simplOper);
        Count count2 = new Count(simplOper);
        count1.start();
        count2.start();
        Thread.sleep(50);
        System.out.println(simplOper.count);
    }
}

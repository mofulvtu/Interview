package com.liuzg.interview.concurrency.syn;

/**
 * <pre>
 *  Desc:  i++ 操作经过反编译可以看出创建了不同的对象，所以Integer不能作为锁
 * </pre>
 *
 * @author liuzg
 * @date 2020/6/2 22:20
 **/
public class TestIntegerSyn {


    private static class Worker implements Runnable {

        private Integer i;

        public Worker(Integer i) {
            this.i = i;
        }

        @Override
        public void run() {
            synchronized (i) {
                Thread thread = Thread.currentThread();
                System.out.println(thread.getName() + "--@" + System.identityHashCode(i));
                i++;
                System.out.println(thread.getName() + "-------" + i + "-@" + System.identityHashCode(i));
                try {
                    Thread.sleep(30);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(thread.getName() + "-------" + i + "--@" + System.identityHashCode(i));
            }

        }

    }


    public static void main(String[] args) throws InterruptedException {
        Worker worker = new Worker(1);
        //Thread.sleep(50);
        for (int i = 0; i < 5; i++) {
            new Thread(worker).start();
        }
    }

}

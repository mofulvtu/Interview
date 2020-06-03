package com.liuzg.interview.concurrency.threadlocal;


import com.liuzg.interview.concurrency.SleepTools;

/**
 * <pre>
 *  Desc: ThreadLocal的线程如果改变的是类属性，则不安全
 *         Number属性去掉static则相互不影响
 * </pre>
 *
 * @author liuzg
 * @date 2020/6/3 22:11
 **/
public class ThreadLocalUnsafe implements Runnable {

    public static ThreadLocal<Number> value = new ThreadLocal<>();
    public static Number number = new Number(0);//去掉static则相互不影响


    public void run() {
        //每个线程计数加一
        number.setNum(number.getNum() + 1);
        //将其存储到ThreadLocal中
        value.set(number);
        SleepTools.ms(2);
        //输出num值
        System.out.println(Thread.currentThread().getName() + "=" + value.get().getNum());
    }

    private static class Number {

        private int num;

        public Number(int num) {
            this.num = num;
        }

        public int getNum() {
            return num;
        }

        public void setNum(int num) {
            this.num = num;
        }

        @Override
        public String toString() {
            return "Number [num=" + num + "]";
        }

    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new Thread(new ThreadLocalUnsafe()).start();
        }
    }

}

package com.liuzg.interview.concurrency.wn;

/**
 * <pre>
 *  Desc: 快递类实体
 * </pre>
 *
 * @author liuzg
 * @date 2020/6/4 22:07
 **/
public class Express {
    public final static String CITY = "ShangHai";
    private static Integer km;/*快递运输里程数*/
    private static String site;/*快递到达地点*/
    private final static Object kmLock = new Object();
    private final static Object siteLock = new Object();

    public Express() {
    }

    public Express(int km, String site) {
        this.km = km;
        this.site = site;
    }

    /* 变化公里数，然后通知处于wait状态并需要处理公里数的线程进行业务处理*/
    public void changeKm() {
        synchronized (kmLock) {

            this.km = 101;
            kmLock.notifyAll();
        }
    }

    /* 变化地点，然后通知处于wait状态并需要处理地点的线程进行业务处理*/
    public void changeSite() {
        synchronized (siteLock) {
            this.site = "BeiJing";
            siteLock.notifyAll();
        }
    }

    /*线程等待公里的变化*/
    public void waitKm() {
        synchronized (kmLock) {

            while (this.km < 100) {
                try {
                    kmLock.wait();
                    System.out.println("Check Km thread[" + Thread.currentThread().getId() + "] is be notified");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("the Km is " + this.km + ",I will change db");
        }
    }

    /*线程等待目的地的变化*/
    public void waitSite() {
        synchronized (siteLock) {

            while (this.site.equals(CITY)) {//快递到达目的地
                try {
                    siteLock.wait();
                    System.out.println("Check Site thread[" + Thread.currentThread().getId() + "] is be notified");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("the site is " + this.site + ",I will call user");
        }
    }
}

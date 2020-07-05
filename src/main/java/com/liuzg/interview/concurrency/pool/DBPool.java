package com.liuzg.interview.concurrency.pool;

import java.sql.Connection;
import java.util.LinkedList;

/**
 * <pre>
 *  Desc: 连接池实现
 * </pre>
 *
 * @author liuzg
 * @date 2020/7/5 16:52
 **/
public class DBPool {

    //定义存放连接容器
    private static LinkedList<Connection> pool = new LinkedList<>();

    //初始化池大小
    public DBPool(int initialSize) {
        if (initialSize > 0) {
            for (int i = 0; i < initialSize; i++) {
                pool.addLast(SqlConnectionImpl.fetchConnection());
            }
        }
    }

    //释放连接，通知其他线程
    public void releaseConnection(Connection connection) {
        if (connection != null) {
            synchronized (pool) {
                pool.addLast(connection);
                pool.notifyAll();
            }
        }
    }

    //获取连接
    public Connection fetchConnection(long mills) throws InterruptedException {
        synchronized (pool) {
            //无超时
            if (mills <= 0) {
                while (pool.isEmpty()) {
                    pool.wait();
                }
                return pool.removeFirst();
            } else {
                //有超时

                //超时时刻
                long future = System.currentTimeMillis() + mills;
                //等待时长
                long remaining = mills;

                while (pool.isEmpty() && remaining > 0) {
                    pool.wait(remaining);
                    //唤醒后重新计算等待时长
                    remaining = future - System.currentTimeMillis();
                }
                Connection connection = null;
                if (!pool.isEmpty()) {
                    connection = pool.removeFirst();
                }
                return connection;
            }
        }
    }
}

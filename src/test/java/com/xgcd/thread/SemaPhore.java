package com.xgcd.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Created by Administrator on 2020/3/12 0012.
 */
public class SemaPhore {
    public static void main(String[] args) {
        // 创建线程池
        ExecutorService pool = Executors.newCachedThreadPool();
        // 设置信号量
        Semaphore semaphore = new Semaphore(5);
        // 模拟客户端访问
        for (int index = 0; index < 20; index++) {
            final int no = index;
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    try {
                        // 获取许可
                        semaphore.acquire();
                        System.out.println("Accessing: " + no);
                        Thread.sleep((long) (Math.random() * 6000));
                        // 释放
                        semaphore.release();
                        // 显示当前信号量
                        System.out.println("------------availablePermits: " + semaphore.availablePermits());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            pool.execute(runnable);
        }

        // 退出线程池
        pool.shutdown();
    }
}

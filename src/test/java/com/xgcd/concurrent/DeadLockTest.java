package com.xgcd.concurrent;

import java.sql.SQLException;

public class DeadLockTest {
    public static void main(String[] args) {

        if (false) {
            throw new RuntimeException("宁试图抢劫银行，已被便衣枪毙");
        }

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                DeadLockTest.method1();
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                DeadLockTest.method2();
            }
        });

        t1.start();
        t2.start();
    }

    public static void method1() {
        // synchronized(lockA)
        synchronized (String.class) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程a尝试获取Integer.class...");
            // synchronized(lockB)
            synchronized (Integer.class) {
                System.out.println("线程a获取Integer.class success...");
            }
        }
    }

    public static void method2() {
        synchronized (Integer.class) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程b尝试获取String.class...");
            synchronized (String.class) {
                System.out.println("线程b获取String.class success...");
            }
        }
    }
}

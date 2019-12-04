package com.xgcd.springboot.multithread;

public class CreateThread {
    public static void main(String[] args) {

//        // 实现Runnable接口,重写run()
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                while (true) {
//                    System.out.println("实现Runnable接口,当前线程名:" + Thread.currentThread().getName());
//                }
//            }
//        }).start();
//
//        // 继承Thread类
//        new Thread() {
//            public void run() {
//                while (true) {
//                    System.out.println("继承Thread类,当前线程名:" + Thread.currentThread().getName());
//                }
//            }
//        }.start();

        // 执行谁?执行结果为4:Thread-0
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.out.println("3:" + Thread.currentThread().getName());
                }
            }
        }) {
            public void run() {//此方法为子类覆盖父类的run方法
                while (true) {
                    System.out.println("4:" + Thread.currentThread().getName());
                }
            }
        }.start();

    }
}

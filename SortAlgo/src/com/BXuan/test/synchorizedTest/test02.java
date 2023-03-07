package com.BXuan.test.synchorizedTest;

import java.util.Date;

public class test02 implements Runnable{
    static test02 test02 = new test02();

    final Object lock1 = new Object();
    final Object lock2 = new Object();

    @Override
    public void run() {
        synchronized (lock1){
            System.out.println("这是第一把锁，我是线程" + Thread.currentThread());
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("这是第一把锁，我是线程" + Thread.currentThread() + "--------结束");
        }
        synchronized (lock2){
            System.out.println("这是第二把锁，我是线程" + Thread.currentThread());
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("这是第二把锁，我是线程" + Thread.currentThread() + "--------结束");
        }
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(test02);
        Thread thread2 = new Thread(test02);
        thread1.start();
        thread2.start();
    }
}

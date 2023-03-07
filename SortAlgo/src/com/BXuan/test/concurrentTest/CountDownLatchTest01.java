package com.BXuan.test.concurrentTest;

public class CountDownLatchTest01 {
    public static void main(String[] args) throws InterruptedException {
        Thread thread01 = new Thread(new Runnable() {
            @Override
            public void run() {

            }
        });
        Thread thread02 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程2已完成");
            }
        });

        thread01.start();
        thread02.start();
        thread01.join();
        thread02.join();
        System.out.println("所有线程工作完成");
    }
}

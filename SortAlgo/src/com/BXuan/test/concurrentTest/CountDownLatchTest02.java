package com.BXuan.test.concurrentTest;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest02 {
    public static void main(String[] args) throws InterruptedException {

        CountDownLatch countDownLatch = new CountDownLatch(2);

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("1");
                countDownLatch.countDown();
                System.out.println("2");
                countDownLatch.countDown();
            }
        }).start();
        // await会阻塞当前线程直至countDownLatch执行完成
        countDownLatch.await();
        System.out.println("3");
    }
}

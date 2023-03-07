package com.BXuan.test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestRunnable03 {
    CountDownLatch count = new CountDownLatch(1);
    // 开启公平锁
    Lock lock = new ReentrantLock(true);
    int flag = 1;
    volatile int num = 0;

    public void currentA(){
        lock.lock();
        try {
            Thread.sleep(1000);
            num++;
            System.out.println("A :" + Thread.currentThread() + num);
        }catch (Exception e){

        }finally {
            lock.unlock();
        }

    }
    public void currentB(){
        lock.lock();
        try {
            Thread.sleep(1000);
            num++;
            System.out.println("B :" + Thread.currentThread() + num);
        }catch (Exception e){

        }finally {
            lock.unlock();
        }

    }
    public void currentC(){
        lock.lock();
        try {
            Thread.sleep(1000);
            num++;
            System.out.println("C :" + Thread.currentThread() + num);
        }catch (Exception e){

        }finally {
            lock.unlock();
        }

    }
    public void count(){
        count.countDown();
    }
    public static void main(String[] args) {
        TestRunnable03 testRunnable03 = new TestRunnable03();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    testRunnable03.count.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                for (int i = 0; i < 34; i++) {
                    testRunnable03.currentA();
                }
                testRunnable03.count();
            }
        }, "线程A").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                testRunnable03.count();
                for (int i = 0; i < 33; i++) {
                    testRunnable03.currentB();
                }

            }
        }, "线程B").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                testRunnable03.count();
                for (int i = 0; i < 33; i++) {
                    testRunnable03.currentC();
                }
                testRunnable03.count();
            }
        }, "线程C").start();
    }
}

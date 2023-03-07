package com.BXuan.test.synchorizedTest;

public class test03 implements Runnable{
    @Override
    public void run() {
        method();
    }

    public synchronized void method(){
        System.out.println("我是线程" + Thread.currentThread());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("我是线程" + Thread.currentThread() + "--------结束");
    }
    static test03 test03 = new test03();

    public static void main(String[] args) {
        Thread thread1 = new Thread(test03);
        Thread thread2 = new Thread(test03);
        thread1.start();
        thread2.start();
    }
}

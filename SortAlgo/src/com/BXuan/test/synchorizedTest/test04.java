package com.BXuan.test.synchorizedTest;

public class test04 implements Runnable{

    @Override
    public void run() {
        method();
    }

    public static synchronized void method(){
        System.out.println("我是线程" + Thread.currentThread());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("我是线程" + Thread.currentThread() + "--------结束");
    }

    static test04 test0401 = new test04();
    static test04 test0402 = new test04();

    public static void main(String[] args) {
        Thread thread1 = new Thread(test0401);
        Thread thread2 = new Thread(test0402);
        thread1.start();
        thread2.start();
    }
}

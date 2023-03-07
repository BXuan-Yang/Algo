package com.BXuan.test.synchorizedTest;

public class test05 implements Runnable{

    static test05 test0501 = new test05();
    static test05 test0502 = new test05();

    public static void main(String[] args) {
        Thread thread1 = new Thread(test0501);
        Thread thread2 = new Thread(test0502);
        thread1.start();
        thread2.start();
    }

    @Override
    public void run() {
        synchronized (com.BXuan.test.synchorizedTest.test05.class){
            System.out.println("我是线程" + Thread.currentThread());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("我是线程" + Thread.currentThread() + "-----结束");
        }
    }
}

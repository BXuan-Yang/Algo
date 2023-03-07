package com.BXuan.test;

public class TestRunnable02 {
    volatile int flag = 1;
    volatile int num = 1;

    public void currentA(){
        while (flag != 1){
            try {
                Thread.sleep(1000);
//                System.out.println("A wait");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        flag = 2;
        System.out.println("A :" + Thread.currentThread() + num++);
    }
    public void currentB(){
        while (flag != 2){
            try {
                Thread.sleep(1000);
//                System.out.println("B wait");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        flag = 3;
        System.out.println("B :" + Thread.currentThread() + num++);
    }
    public void currentC(){
        while (flag != 3){
            try {
                Thread.sleep(1000);
//                System.out.println("C wait");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        flag = 1;
        System.out.println("C :" + Thread.currentThread() + num++);
    }
    public static void main(String[] args) {
        TestRunnable02 testRunnable02 = new TestRunnable02();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 34; i++) {
                    testRunnable02.currentA();
                }
            }
        }, "线程1").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 33; i++) {
                    testRunnable02.currentB();
                }
            }
        }, "线程2").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 33; i++) {
                    testRunnable02.currentC();
                }
            }
        }, "线程3").start();
    }
}

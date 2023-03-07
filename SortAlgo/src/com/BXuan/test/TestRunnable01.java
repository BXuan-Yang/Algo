package com.BXuan.test;

public class TestRunnable01 {
    static int flag = 1;
    static int number = 1;

    public synchronized void printA(){
        while (flag != 1) {
            try {
//                System.out.println("A wait here");
                Thread.sleep(1000);
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        flag = 2;
        System.out.println("current Thread A:" + number++);
        this.notifyAll();
    }
    public synchronized void printB(){
        while (flag != 2) {
            try {
//                System.out.println("B wait here");
                Thread.sleep(1000);
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        flag = 3;
        System.out.println("current Thread B:" + number++);
        this.notifyAll();
    }
    public synchronized void printC(){
        while (flag != 3) {
            try {
//                System.out.println("C wait here");
                Thread.sleep(1000);
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        flag = 1;
        System.out.println("current Thread C:" + number++);
        this.notifyAll();
    }
    public static void main(String[] args) {
        TestRunnable01 print = new TestRunnable01();

        new Thread(new Runnable() {

            @Override
            public void run() {
                for (int i = 0; i < 34; i++) {
                    print.printA();
                }
            }
        }, "线程一").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 33; i++) {
                    print.printB();
                }
            }
        }, "线程二").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 33; i++) {
                    print.printC();
                }
            }
        }, "线程三").start();
    }
}

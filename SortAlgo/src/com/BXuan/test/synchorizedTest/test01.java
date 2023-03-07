package com.BXuan.test.synchorizedTest;

public class test01 implements Runnable{

    static test01 test01 = new test01();

    public static void main(String[] args) {
        Thread thread1 = new Thread(test01);
        Thread thread2 = new Thread(test01);
        thread1.start();
        thread2.start();
    }

    @Override
    public void run() {
        synchronized (this){
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

//public class SynchronizedObjectLock implements Runnable {
//    static SynchronizedObjectLock instence = new SynchronizedObjectLock();
//
//    @Override
//    public void run() {
//        // 同步代码块形式——锁为this,两个线程使用的锁是一样的,线程1必须要等到线程0释放了该锁后，才能执行
//        synchronized (this) {
//            System.out.println("我是线程" + Thread.currentThread().getName());
//            try {
//                Thread.sleep(3000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println(Thread.currentThread().getName() + "结束");
//        }
//    }
//
//    public static void main(String[] args) {
//        Thread t1 = new Thread(instence);
//        Thread t2 = new Thread(instence);
//        t1.start();
//        t2.start();
//    }
//}


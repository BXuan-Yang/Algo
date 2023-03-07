package com.BXuan.test.concurrentTest;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ExchangerTest {
    private static final Exchanger<String> exchanger = new Exchanger<>();

    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(2);
        pool.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    String A = "银行流水A";
                    exchanger.exchange(A);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        pool.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    String B = "银行流水B";
                    String A = exchanger.exchange(B);
                    System.out.println(A.equals(B));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}

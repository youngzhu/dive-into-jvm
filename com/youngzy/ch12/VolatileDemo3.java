package com.youngzy.ch12;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author youngzy
 * @since 2022-05-28
 */
public class VolatileDemo3 {
    static AtomicInteger sum = new AtomicInteger(0);
    static volatile boolean done = false;

    static class Counter extends Thread {
        int n;

        @Override
        public void run() {
            while (!done) {
                int i = sum.incrementAndGet();
                if (i == 10_000) {
                    done = true;
                    return;
                }
                n++;
            }
        }
    }

    public static void main(String[] args) {
        Counter c1 = new Counter();
        Counter c2 = new Counter();

        c1.start();
        c2.start();

        // 等待所有计数线程结束
        System.out.println(Thread.activeCount());
        while (Thread.activeCount()>2) {
            Thread.yield();
        }
        System.out.println(Thread.activeCount());

        System.out.println(c1.n + ", " + c2.n);
        System.out.println("c1.n + c2.n=" + (c1.n + c2.n));
        System.out.println(sum);
    }
}

package com.youngzy.ch12;

/**
 * 谁先数到 10000 比赛结束
 *
 * @author youngzy
 * @since 2022-05-28
 */
public class VolatileDemo4 {
    static volatile boolean done = false;

    static class Counter extends Thread {
        int n;

        @Override
        public void run() {
            while (!done) {
                n++;
                if (n == 100_000) {
                    done = true;
                }
            }
        }
    }

    static final int THREADS_COUNT = 10;

    public static void main(String[] args) {
        Counter[] counters = new Counter[THREADS_COUNT];
        for (int i = 0; i < THREADS_COUNT; i++) {
            counters[i] = new Counter();
            counters[i].start();
        }

        // 等待所有计数线程结束
        System.out.println(Thread.activeCount());
        while (Thread.activeCount()>2) {
            Thread.yield();
        }
        System.out.println(Thread.activeCount());

        for (Counter c : counters) {
            System.out.println(c.n);
        }
    }
}

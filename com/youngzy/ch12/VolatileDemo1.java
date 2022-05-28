package com.youngzy.ch12;

/**
 * @author youngzy
 * @since 2022-05-28
 */
public class VolatileDemo1 {
    static volatile int counter = 0;

    static void increase() {
        counter++;
    }

    static final int THREADS_COUNT = 20;

    public static void main(String[] args) throws Exception {
        Thread[] threads = new Thread[THREADS_COUNT];
        for (int i = 0; i < THREADS_COUNT; i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 1_000_000; j++) {
                        increase();
                    }
                }
            });
            threads[i].start();
            // join()不能用，它是等待线程结束
//            threads[i].join();
        }

        // 等待所有计数线程结束
        while (Thread.activeCount()>2) {
            Thread.yield();
        }
        System.out.println(Thread.activeCount());

        System.out.println(counter);
    }
}

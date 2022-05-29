package com.youngzy.ch13;

import java.util.Vector;

/**
 * 线程安全的类，并不是所有情况都线程安全的
 *
 * @author youngzy
 * @since 2022-05-29
 */
public class VectorSafeDemo {
    static Vector<Integer> vector = new Vector<>();

    public static void main(String[] args) {
        while (true) {
            for (int i = 0; i < 10; i++) {
                vector.add(i);
            }

            Thread remove = new Thread(new Runnable() {
                @Override
                public void run() {
                    synchronized (vector) {
                        for (int i = 0; i < vector.size(); i++) {
                            vector.remove(i);
                        }
                    }
                }
            });
            remove.start();

            Thread print = new Thread(new Runnable() {
                @Override
                public void run() {
                    synchronized (vector) {
                        for (int i = 0; i < vector.size(); i++) {
                            vector.get(i);
    //                        System.out.println(vector.get(i));
                        }
                    }
                }
            });
            print.start();

            // 不要产生过多的线程，可能会导致系统假死
            while (Thread.activeCount() > 20);
        }
    }
}

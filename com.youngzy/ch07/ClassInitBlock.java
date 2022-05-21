package ch07;

/**
 * 类构造器函数执行时间过长会导致线程阻塞
 *
 * @author youngzy
 * @since 2022-05-21
 */
public class ClassInitBlock {
    static class InfiniteLoop {
        static {
            if (true) { // 不加这个if，编译不通过
                System.out.println(Thread.currentThread() + " <clinit>");
                while (true) {

                }
            }
        }
    }

    public static void main(String[] args) {
        Runnable task = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread() + " start");
                new InfiniteLoop();
                System.out.println(Thread.currentThread() + " done");
            }
        };

        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);
        thread1.start();
        thread2.start();
    }
}

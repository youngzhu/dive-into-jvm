package ch07;

/**
 * 先执行父类的类构造器方法（无引用的）
 * @author youngzy
 * @since 2022-05-21
 */
public class SuperFirstNoRef {
    static class Super {
        static {
            System.out.println("Super <clinit>");
        }
    }

    static class Sub extends Super {
        static {
            System.out.println("Sub <clinit>");
        }
    }

    public static void main(String[] args) {
        new Sub();
    }
}

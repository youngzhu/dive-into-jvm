package ch07;

/**
 * 先执行父类的类构造器方法（有引用的）
 * 所以结果输出为2
 *
 * @author youngzy
 * @since 2022-05-21
 */
public class SuperFirstRef {
    static class Super {
        static int A = 1;
        static {
            A = 2;
        }

        Super() {
            A = 3;
        }
    }

    static class Sub extends Super {
        static int B = A;
    }

    public static void main(String[] args) {
        System.out.println(Sub.B);
    }
}



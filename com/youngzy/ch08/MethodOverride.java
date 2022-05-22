package com.youngzy.ch08;

/**
 * @author youngzy
 * @since 2022-05-22
 */
public class MethodOverride {
    static abstract class Human {
        abstract void sayHello();
    }
    static class Man extends Human {
        void sayHello() {
            System.out.println("man say hello");
        }
    }
    static class Woman extends Human {
        @Override
        void sayHello() {
            System.out.println("woman say hi");
        }
    }

    public static void main(String[] args) {
        Human man = new Man();
        Human woman = new Woman();
        man.sayHello();
        woman.sayHello();

        man = new Woman();
        man.sayHello();

        // Output:
        // man say hello
        // woman say hi
        // woman say hi
    }
}

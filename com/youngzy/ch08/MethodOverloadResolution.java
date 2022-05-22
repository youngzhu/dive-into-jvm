package com.youngzy.ch08;

/**
 * @author youngzy
 * @since 2022-05-22
 */
public class MethodOverloadResolution {
    static abstract class Human {}
    static class Man extends Human {}
    static class Woman extends Human {}

    public void sayHello(Human human) {
        System.out.println("hello, human");
    }
    public void sayHello(Man man) {
        System.out.println("hey, bro");
    }
    public void sayHello(Woman woman) {
        System.out.println("hello, madam");
    }

    public static void main(String[] args) {
        Human man = new Man();
        Human woman = new Woman();
        MethodOverloadResolution mor = new MethodOverloadResolution();
        mor.sayHello(man);
        mor.sayHello(woman);

        // Output:
        // hello, human
        // hello, human
    }
}

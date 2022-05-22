package com.youngzy.ch08;

import java.io.Serializable;

/**
 * @author youngzy
 * @since 2022-05-22
 */
public class OverloadPriority {
//    static void sayHello(char c) {
//        System.out.println("hello, char");
//    }
//    static void sayHello(int i) {
//        System.out.println("hello, int");
//    }
//    static void sayHello(long i) {
//        System.out.println("hello, long");
//    }
//    static void sayHello(float f) {
//        System.out.println("hello, float");
//    }
//    static void sayHello(double d) {
//        System.out.println("hello, double");
//    }
//    static void sayHello(Character c) {
//        System.out.println("hello, Character");
//    }
//    static void sayHello(Serializable s) {
//        System.out.println("hello, Serializable");
//    }
//    static void sayHello(Object obj) {
//        System.out.println("hello, Object");
//    }
    static void sayHello(char... c) {
        System.out.println("hello, char...");
    }

    public static void main(String[] args) {
        // 有没有定义变量都一样
//        char a = 'a';
//        sayHello(a);

        sayHello('a');
    }
}

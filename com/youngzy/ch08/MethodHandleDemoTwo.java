package com.youngzy.ch08;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

/**
 * 如何绕过父类去执行爷爷类的方法？
 *
 * @author youngzy
 * @since 2022-05-22
 */
public class MethodHandleDemoTwo {
    class GrandFather {
        void thinking() {
            System.out.println("I am grandfather");
        }
    }
    class Father extends GrandFather {
        @Override
        void thinking() {
            System.out.println("I am father");
        }
    }
    class Son extends Father {
        @Override
        void thinking() {
            try {
                MethodType methodType = MethodType.methodType(void.class);
                MethodHandle methodHandle = MethodHandles.lookup().findSpecial(GrandFather.class,
                        "thinking", methodType, Son.class)
                        .bindTo(this);
                methodHandle.invokeExact();
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new MethodHandleDemoTwo().new Son().thinking();
    }
}

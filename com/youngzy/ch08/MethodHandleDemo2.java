package com.youngzy.ch08;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;

import static java.lang.invoke.MethodHandles.lookup;


/**
 * 如何绕过父类去执行爷爷类的方法？
 *
 * @author youngzy
 * @since 2022-05-22
 */
public class MethodHandleDemo2 {
    public static void main(String[] args) {
        (new MethodHandleDemo2().new Son()).thinking();
    }

    class GrandFather {
        public void thinking() {
            System.out.println("I am grandfather");
        }
    }

    class Father extends GrandFather {
        @Override
        public void thinking() {
            System.out.println("I am father");
        }
    }

    class Son extends Father {
        @Override
        public void thinking() {
            try {
                MethodType methodType = MethodType.methodType(void.class);
                MethodHandle methodHandle = lookup().findSpecial(GrandFather.class,
                        "thinking", methodType, Son.class);
                methodHandle.invoke(this);
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        }
    }
}

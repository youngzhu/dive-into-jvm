package com.youngzy.ch08;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

/**
 * Method Handle 的基础用法
 *
 * @author youngzy
 * @since 2022-05-22
 */
public class MethodHandleDemo {
    static class AnotherPrintStream {
        public void println(String s) {
            System.out.println(s);
        }
    }

    public static void main(String[] args) throws Throwable {
        Object obj = System.currentTimeMillis()%2==0? System.out
                : new AnotherPrintStream();
        getPrintlnMH(obj).invokeExact("hello Method Handle");
    }

    private static MethodHandle getPrintlnMH(Object receiver) throws NoSuchMethodException, IllegalAccessException {
        // 方法类型，包含了方法返回值（methodType()的第一个参数）
        // 和调用方法的参数（methodType()的第二个参数及之后的参数）
        MethodType methodType = MethodType.methodType(void.class, String.class);
        MethodHandle methodHandle = MethodHandles.lookup().findVirtual(receiver.getClass(),
                "println", methodType);
        // 哎呀我去，还不能拆开写。。。
//        methodHandle.bindTo(receiver);
        return methodHandle.bindTo(receiver);
    }
}

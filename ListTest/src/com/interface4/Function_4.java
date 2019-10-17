package com.interface4;

import java.util.UUID;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @author zhangyanan
 * @create 2019-09-19 21:18
 */
public class Function_4 {
    public static void main(String[] args) {
        // R apply(T t);函数型接口，一个参数，一个返回值
        Function<String,Integer> function = t ->{return t.length();};
        System.out.println(function.apply("abcd"));

        // boolean test(T t);断定型接口，一个参数，返回boolean
        Predicate<String> predicate = t->{return t.startsWith("a");};
        System.out.println(predicate.test("a"));

        // void accept(T t);消费型接口，一个参数，没有返回值
        Consumer<String> consumer = t->{
            System.out.println(t);
        };
        consumer.accept("javaXXXX");

        // T get(); 供给型接口，无参数，有返回值
        Supplier<String> supplier =()->{return UUID.randomUUID().toString();};
        System.out.println(supplier.get());
    }
}

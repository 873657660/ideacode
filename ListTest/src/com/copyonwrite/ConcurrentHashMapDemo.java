package com.copyonwrite;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author zhangyanan
 * @create 2019-09-19 14:56
 */
public class ConcurrentHashMapDemo {
    public static void main(String[] args) {

        Set hsahset = new HashSet();
        List<Object> list = new CopyOnWriteArrayList<>();
        Set<Object> set = new CopyOnWriteArraySet<>();

        Map<String, String> map = new ConcurrentHashMap();
        for (int i = 0; i < 15 ; i++) {
            new Thread(()->{
                map.put(Thread.currentThread().getName(), UUID.randomUUID().toString().substring(0,8));
                System.out.println(map);
            },String.valueOf(i)).start();
        }

    }
}

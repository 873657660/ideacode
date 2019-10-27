package com.weekhashmap;


import java.util.HashMap;
import java.util.WeakHashMap;

/**
 * @author Jay
 * @create 2019-10-27 16:52
 */
public class WeekHashMapDemo {
    public static void main(String[] args) {
        myHashMap();
        System.out.println();
        System.out.println("=================");
        System.out.println();
        myWeekHashMap();

    }

    /**
     * WeakHashMap的使用
     */
    public static void myWeekHashMap(){
        WeakHashMap<Integer, String> map = new WeakHashMap<>();
        Integer key = new Integer(2);
        String value = "weakHashMap";

        map.put(key, value);
        System.out.println("map："+ map);

        key = null;
        System.out.println("key=null后的weakhashmap："+ map);

        System.gc();
        System.out.println("gc后的weakhashmap："+ map);
    }


    public static void myHashMap(){
        HashMap<Integer, String> map = new HashMap<>();
        Integer key = new Integer(1);
        String value = "HashMap";

        map.put(key, value);
        System.out.println("hashmap:" + map);

        key = null;
        System.out.println("key=null后的hashmap："+ map);

        System.gc();
        System.out.println("gc后的hashmap："+ map);
    }
}

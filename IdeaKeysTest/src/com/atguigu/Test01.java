package com.atguigu;

import com.sun.javafx.font.PrismFontStrike;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**
 * @author zhangyanan
 * @create 2019-09-11 18:53
 */
public class Test01 {
    public static void main(String[] args) {
        ArrayList<Object> list = new ArrayList<>();
        list.add("haha");
        list.add("lala");
        list.add("meme");
        HashMap<Object, Object> map = new HashMap<>();
        map.put("k1", "v1");
        map.put("k2", "v2");

        // 普通for循环：fori
        for (int i = 0; i < 5; i++) {
            System.out.println(i);
        }

        // foreach快捷键：iter
        for (Object k : map.keySet()) {
            System.out.println(k);
        }

        // 循环数组：itea
        for (int i = 0; i < args.length; i++) {
            String arg = args[i];
        }

        // 迭代器遍历：itco
        for (Iterator<Object> iterator = list.iterator(); iterator.hasNext(); ) {
            Object next =  iterator.next();
            System.out.println("list集合：" + next);
        }

        // 主函数：psvm
        try {
            new Thread(() -> {}, "").start();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

package com.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author zhangyanan
 * @create 2019-09-19 15:37
 */
public class CallableDemo {
    public static void main(String[] args) {
        try {

            FutureTask ft = new FutureTask(new MyThread());
            new Thread(ft, "中间人：FutureTask").start();
            System.out.println("Callable的返回值："+ft.get());

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

}

// 实现Callable接口，可以定泛型，有返回值，抛异常
class MyThread implements Callable<String >{
    @Override
    public String call() throws Exception {
        System.out.println("打印haha");
        return "haha";
    }
}
class MyThread2 implements Runnable{
    @Override
    public void run() {

    }
}

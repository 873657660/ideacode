package com.countdownlatch.cyclicbarrier.semaphore;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author zhangyanan
 * @create 2019-09-19 20:30
 * 信号灯
 */
public class SemaphoreDemo {
    public static void main(String[] args) {

        // 三个停车位
        Semaphore semaphore = new Semaphore(3);

        // 六辆汽车
        for (int i = 1; i <= 6; i++) {
            new Thread(() -> {
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName()+"号驶入车位===》");
                    TimeUnit.SECONDS.sleep(3);
                    System.out.println(Thread.currentThread().getName()+"号离开车位《===");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                }
            }, String.valueOf(i)).start();
        }
    }
}

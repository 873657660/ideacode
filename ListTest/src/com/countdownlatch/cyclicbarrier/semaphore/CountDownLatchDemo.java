package com.countdownlatch.cyclicbarrier.semaphore;

import com.countdownlatch.cyclicbarrier.semaphore.enums.CountryEnum;

import java.util.concurrent.CountDownLatch;

/**
 * @author zhangyanan
 * @create 2019-09-19 19:23
 *
 */
public class CountDownLatchDemo {

    public static void main(String[] args) throws InterruptedException {
        // 减少计数CountDownLatch
        CountDownLatch countDownLatch = new CountDownLatch(6);

        for (int i = 1; i <= 6; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "国，灭亡。");
                countDownLatch.countDown();
            }, CountryEnum.forEach_CountryEnum(i).getCountry()).start();

        }
        // 拦截
        countDownLatch.await();
        System.out.println(Thread.currentThread().getName() + "秦国，一统天下！");
    }
}

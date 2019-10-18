package com.production_consumer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Jay
 * @create 2019-10-18 9:40
 */
class MySource {
    private volatile boolean FLAG = true;
    private AtomicInteger atomicInteger = new AtomicInteger();

    BlockingQueue<String> blockingQueue = null;

    public MySource(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
        System.out.println("传入的BlockingQueue的实现类为：" + blockingQueue.getClass().getName());
    }

    public void myProd() throws Exception{
        String data = null;
        boolean retValue;
        while(FLAG) {
            data = atomicInteger.incrementAndGet()+ "";
            retValue = blockingQueue.offer(data, 2L, TimeUnit.SECONDS);
            if(retValue) {
                System.out.println(Thread.currentThread().getName() + "\t 插入"+data+"到队列成功");
            }else {
                System.out.println(Thread.currentThread().getName() + "\t 插入失败");
            }
            TimeUnit.SECONDS.sleep(3);
        }
        // 如果falg为false
        System.out.println(Thread.currentThread().getName() + "\t 老板叫停，FLAG = false，生产结束");
    }

    public void myConsumer() throws Exception{
        String result = null;
        while (FLAG) {
            result = blockingQueue.poll(2, TimeUnit.SECONDS);
            if(null == result || result.equalsIgnoreCase("")) {
                // 长时间没有取出值，则生产者已经停止生产，此时将消费者也停止消费
                FLAG = false;
                System.out.println(Thread.currentThread().getName() + "\t 超过两秒钟没有取到蛋糕，消费退出");
                try { TimeUnit.SECONDS.sleep(2); } catch (InterruptedException e) { e.printStackTrace(); }
                return;
            }
            System.out.println(Thread.currentThread().getName() + "\t 消费队列蛋糕"+result+"取出成功");
        }
    }

    public void stop() throws Exception{
        FLAG = false;
    }
}


public class ProdConsumer_BlockingQueueDemo {
    public static void main(String[] args) throws Exception {

        MySource mySource = new MySource(new ArrayBlockingQueue<String>(3));

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() +"\t 生产线程启动");
            try {
                mySource.myProd();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "Prod：").start();

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() +"\t 消费线程启动");
            System.out.println();
            System.out.println();
            System.out.println();
            try {
                mySource.myConsumer();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "Consumer：").start();

        try { TimeUnit.SECONDS.sleep(8); } catch (InterruptedException e) { e.printStackTrace(); }

        System.out.println("8秒钟后，将main线程叫停，活动结束");

        mySource.stop();


    }
}

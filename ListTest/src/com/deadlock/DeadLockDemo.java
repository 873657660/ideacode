package com.deadlock;

import java.util.concurrent.TimeUnit;

/**
 * @author Jay
 * @create 2019-10-18 20:13
 */
class HoldLockThread implements Runnable{

    private String lockA;
    private String lockB;

    public HoldLockThread(String lockA, String lockB) {
        this.lockA = lockA;
        this.lockB = lockB;
    }

    @Override
    public void run() {
        synchronized (lockA) {
            System.out.println(Thread.currentThread().getName() +"\t自己持有"+lockA + "\t尝试持有" + lockB);

            try { TimeUnit.SECONDS.sleep(2); } catch (InterruptedException e) { e.printStackTrace(); }

            synchronized (lockB) {
                System.out.println(Thread.currentThread().getName() +"\t自己持有"+lockB + "\t尝试持有" + lockA);
            }
        }
    }
}


public class DeadLockDemo {

    public static void main(String[] args) {
        String lockA = "lockA";
        String lockB = "lockB";

        new Thread(new HoldLockThread(lockA, lockB), "ThreadAAA:").start();
        new Thread(new HoldLockThread(lockB, lockA), "ThreadBBB:").start();
    }
}

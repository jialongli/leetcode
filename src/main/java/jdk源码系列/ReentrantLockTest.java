package jdk源码系列;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 *
 * @author jialong2.li
 * @version 1.0.0, 2021/1/20-4:37 PM.
 * @since 2021/1/20-4:37 PM
 */
public class ReentrantLockTest {
    public static void main(String[] args) throws InterruptedException {
        Lock l =new ReentrantLock();
        l.lock();
        new Thread(new Runnable() {
            @Override
            public void run() {
                l.lock();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                l.lock();
            }
        }).start();
        Thread.sleep(1000*70*70);
        System.out.println("dsfasfdas");
//        l.unlock();
    }
}

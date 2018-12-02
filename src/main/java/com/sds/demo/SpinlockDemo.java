package com.sds.demo;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by tandy on 2017/7/15.
 * 自旋锁DEMO
 */
public class SpinlockDemo implements Runnable {

    private ReentrantSpinLock lock;

    public SpinlockDemo(){
        lock = new ReentrantSpinLock();
    }

    public static void main(String[] args) {
        SpinlockDemo demo = new SpinlockDemo();
        demo.doDemo();
    }

    private void doDemo() {
        Thread t01 = new Thread(this);
        Thread t02 = new Thread(this);
        Thread t03 = new Thread(this);
        t01.start();
        t02.start();
        t03.start();
    }

    public void doProcess() throws InterruptedException {
        System.out.println("["+Thread.currentThread().getId()+"]开始执行业务逻辑");
        TimeUnit.SECONDS.sleep(1);
        lock.lock();
            doProcessStep02();
        lock.unlock();
        System.out.println("["+Thread.currentThread().getId()+"]业务处理完毕");
    }
    public void doProcessStep02(){
        System.out.println("["+Thread.currentThread().getId()+"]开始执行step02业务逻辑");
    }

    public void run() {
        System.out.println("["+Thread.currentThread().getId()+"]开始执行");
        lock.lock();
        try {
            this.doProcess();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lock.unlock();

    }
}

class SpinLock{
    private AtomicReference<Thread> sign = new AtomicReference<Thread>();

    public void lock(){
        Thread current = Thread.currentThread();
        while(!sign.compareAndSet(null,current)){
//            System.out.println("自旋中："+ current.getId());
        }
    }

    public void unlock(){
        Thread current = Thread.currentThread();
        sign.compareAndSet(current,null);
    }


}


/**
 * 可重入自旋锁
 */
class ReentrantSpinLock{
    private int count;
    private AtomicReference<Thread> sign = new AtomicReference<Thread>();
    public void lock(){
        Thread currentThread = Thread.currentThread();
        if(sign.get() == currentThread){
            count ++;
            return;
        }
        while(!sign.compareAndSet(null,currentThread)){
            //如果设置失败，自旋
        }
    }
    public void unlock(){
        Thread currentThread = Thread.currentThread();
        if(sign.get() == currentThread){
            if(count > 0){
                count--;
            }else {
                sign.compareAndSet(currentThread, null);
            }
        }
    }
}
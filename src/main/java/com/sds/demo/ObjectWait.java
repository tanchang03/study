package com.sds.demo;

public class ObjectWait {
    private static int x = 0;

    public static void main(String[] args) throws InterruptedException {


        final ObjectWait objectWait = new ObjectWait();
        Thread t = new Thread(new Runnable() {
            public void run() {
                try {
                    synchronized (objectWait) {
                        System.out.println("start to wait 1000ms");
                        objectWait.wait(10000);
                        System.out.println("i am wated");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t.start();
        Thread.currentThread().sleep(1000);

            t.interrupt();

        System.out.println("OK");
    }
}

package com.sds.demo;

/**
 * Created by tandy on 2017/7/15.
 */
public class GCDemo {
    public Object instance = null;
    private static final int _1MB = 1024*1024;

    private byte[] bigSize = new byte[2*_1MB];

    public static void main(String[] args) {
        GCDemo objA = new GCDemo();
        GCDemo objB = new GCDemo();
        objA.instance = objB;
        objB.instance = objA;

        objA = null;
        objB = null;

        System.gc();
    }
}

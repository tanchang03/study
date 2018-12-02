package com.sds.demo;

public class StaticTest {

    private static int x = 0;

    public static void main(String[] args) {
        StaticTest.x++;
        StaticTest t = new StaticTest();
        t.x++;
        System.out.println(StaticTest.x);
    }
}


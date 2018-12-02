package com.sds.demo;

public interface InterfaceX {

    abstract Object add();
}

class A implements InterfaceX{

    public A add() {
        return new A();
    }
}

class B{
    static int i = 100;
    public static void main(String[] args) {
        B b = null;
        System.out.println(b.i);
    }
}

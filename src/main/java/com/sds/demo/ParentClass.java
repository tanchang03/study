package com.sds.demo;

import java.util.List;

public class ParentClass {
    protected String username;
}
class ChildClass extends ParentClass{
    public ChildClass(){
        this.username = "tanchang";
    }

    public void test001(){
        System.out.println(super.username);
    }
    public static void main(String[] args) {
        ChildClass childClass = new ChildClass();
        childClass.test001();

    }
    class A {}
    class B extends A {}
    class C extends A {}
    class D extends B {}


    public void test0001(){
        List<A> a = null;
        List list = null;
        list = a;

        List<? extends A> x;
        List<B> b = null;
        x = b;

//        a = b;
//        b = a;

        List<?> x2 = list;
        x2 = list;
        x2 = a;
        x2 = b;

        List<? super D> sd = null;
        sd = a;

        List<? extends B> b1 = null;
        x = b1;



    }

}





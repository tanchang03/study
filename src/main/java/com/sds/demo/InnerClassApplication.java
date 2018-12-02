package com.sds.demo;

public class InnerClassApplication {
    public void process(){
        InnerClass.StaticInnerClass staticInnerClass = new InnerClass.StaticInnerClass();
        System.out.println(staticInnerClass.x);

        InnerClass ic = new InnerClass();
        InnerClass.InnerClassDemo icd = ic.new InnerClassDemo();
        System.out.println(icd.y);
    }

    public static void main(String[] args) {
        InnerClassApplication app = new InnerClassApplication();
        app.process();
    }
}

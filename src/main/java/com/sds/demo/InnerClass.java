package com.sds.demo;

public class InnerClass {

    private static final int i = 0;
    private String userName="tc";


    /**
     * 静态内部类
     * 静态内部类只能够访问外部类的静态成员
     * 静态内部类能有静态成员（方法、属性）
     * 只能在内部类中定义静态类
     * 静态内部类与外层类绑定，即使没有创建外层类的对象，它一样存在。
     * 静态类的方法可以是静态的方法也可以是非静态的方法，静态的方法可以在外层通过静态类调用，而非静态的方法必须要创建类的对象之后才能调用。
     */
    static class StaticInnerClass{
        public static int cc;
        private int xx = 100;
        public String x = "StaticInnerClass";
        public void test001(){
            System.out.println(i);
            System.out.println(xx);
        }
    }

    /**
     * 成员内部类
     * 非静态内部类不能有静态成员（方法、属性）
     * 非静态内部类不能有静态成员(方法，属性)。
     * 静态内部类和非静态内部类在创建时有区别
     */
    class InnerClassDemo{
        public String y = "InnerClassDemo";
        public void test001(){
            System.out.println(userName);
        }
    }

    /**
     * 局部内部类
     * 规则一：局部内部类类似方法的局部变量，所以在类外或者类的其他方法中不能访问这个内部类，但这并不代表局部内部类的实例和定义了它的方法中的局部变量具有相同的生命周期。
     * 规则二：只能在方法内部，类（局部内部类）定义之后使用，不存在外部可见性问题，因此没有访问修饰符。
     * 规则三：不能在局部内部类中使用可变的局部变量。 非final变量无法使用
     * 规则四：可以访问外围类的成员变量。如果是static方法，则只能访问static修饰的成员变量。
     * 规则五：可以使用final 或 abstract修饰。
     */
    public static void localInnerClassDemo(){
        final int x1 = 100;
        class LocalInnerClass{
            public void m01(){
                System.out.println(x1);
                System.out.println(i);
            }
        }
        LocalInnerClass x = new LocalInnerClass();
        x.m01();
    }

    public static void main(String[] args) {
        InnerClass ic = new InnerClass();
        ic.localInnerClassDemo();
    }
}

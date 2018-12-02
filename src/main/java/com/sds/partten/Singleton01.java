package com.sds.partten;

/**
 * 懒汉模式，线程不安全
 */
public class Singleton01 {
    private Singleton01() {
    }

    private static Singleton01 singleton01 = null;

    public static Singleton01 getInstance() {
        if (singleton01 == null) {
            singleton01 = new Singleton01();
        }
        return singleton01;
    }

    public static void main(String[] args) {
        Singleton01 singleton01 = Singleton01.getInstance();
        System.out.println(singleton01);
    }
}

/**
 *饿汉模式  浪费内存
 * 饿汉式，线程安全：
 * 优点：没有加锁，执行效率会提高。
 * 缺点：类加载时就初始化，浪费内存。
 */
class Singleton02{
    private Singleton02(){}
    public static Singleton02 singleton02 = new Singleton02();

    public static Singleton02 getInstance(){
        return singleton02;
    }
}

/**
 * 解决多线程问题，但是性能低下
 */
class Singleton03{
    private static Singleton03 singleton03 = null;
    private Singleton03(){}

    public static synchronized Singleton03 getInstance(){
        if(singleton03 == null){
            singleton03 = new Singleton03();
        }
        return singleton03;
    }
}

/**
 * 解决多线程问题 性能提升版本
 * 双检锁/双重校验锁（DCL，即 double-checked locking）
 * 这种方式采用双锁机制，安全且在多线程情况下能保持高性能。
 */
class Singleton04{
    private volatile static Singleton04 singleton04 = null;

    private Singleton04(){}

    public static Singleton04 getInstance(){
        if(singleton04 == null){
            synchronized (Singleton04.class){
                if(singleton04 == null){
                    singleton04 = new Singleton04();
                }
            }
        }
        return singleton04;
    }
}

/**
 * Holder延迟初始化占位类
 */
class Singleton05{
    private Singleton05(){}
    private static class Singleton5Instance{
        public static Singleton05 s = new Singleton05();
    }
    public static Singleton05 getInstance(){
        return Singleton5Instance.s;
    }
}




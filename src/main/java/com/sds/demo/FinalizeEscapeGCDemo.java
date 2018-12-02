package com.sds.demo;

import java.util.concurrent.TimeUnit;

/**
 * Created by tandy on 2017/7/15.
 */
public class FinalizeEscapeGCDemo {
    public static FinalizeEscapeGCDemo SAVE_HOOK=null;

    public void isAlive(){
        System.out.println("i'm alive now");
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize method is executed");
        SAVE_HOOK = this;
    }

    public static void main(String[] args) throws InterruptedException {
        SAVE_HOOK = new FinalizeEscapeGCDemo();
        SAVE_HOOK = null;
        System.gc();
        TimeUnit.MILLISECONDS.sleep(500);

        if(SAVE_HOOK != null){
            SAVE_HOOK.isAlive();
        }else{
            System.out.println("iam dead:(");
        }

        SAVE_HOOK = null;
        System.gc();
        TimeUnit.MILLISECONDS.sleep(500);

        if(SAVE_HOOK != null){
            SAVE_HOOK.isAlive();
        }else{
            System.out.println("iam dead:(");
        }



    }
}

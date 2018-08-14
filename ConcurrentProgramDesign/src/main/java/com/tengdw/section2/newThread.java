package com.tengdw.section2;

public class newThread {

    public void newThread() {
        // 通过匿名内部类
        Thread t1 = new Thread(){
            @Override
            public void run() {
                System.out.println("I'm thread t1");
            }
        };
        t1.start();
        // 通过实现 Runnable 接口
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("I'm thread t2");
            }
        });
        t2.start();
        // in java8
        Thread lambdaThread = new Thread(() -> System.out.println("I'm thread lambdaThread"));
        lambdaThread.start();
    }
}

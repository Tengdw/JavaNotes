package com.tengdw.rule;

/**
 * 3. 用私有构造器或者枚举类型强化 Singleton 属性
 */
public class rule3 {
}

class Elvis { //可以通过反射调用私有构造器
    public static final Elvis INSTANCE = new Elvis();
    private Elvis() {
        //do something
    }
    public void leaveTheBuilding() {

    }
}

class Elvis1 {
    private static final Elvis1 INSTANCE = new Elvis1();
    private Elvis1() {
        //do something
    }
    public static Elvis1 getInstance() {
        return INSTANCE;
    }
    public void leaveTheBuilding() {

    }
}

enum Elvis2 {
    INTANCE;

    public void leaveTheBuilding() {

    }
}

/**
 * 单元素的枚举类型已经成为实现 Singleton 的最佳方法
 */

package com.tengdw.rule;

import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.Iterator;

/**
 * 6. 消除过期的对象引用
 */
public class rule6 {

    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push("a");
        stack.push("b");
        stack.push("c");
        stack.push("d");
        stack.push("e");
        stack.push("f");
        stack.push("g");
        stack.push("h");

        stack.pop();
        stack.pop();
    }
}

class Stack {
    private Object[] elements;
    private int size = 0;
    private static final int DEDAULT_INITIAL_CAPACITY = 16;

    public Stack() {
        elements = new Object[DEDAULT_INITIAL_CAPACITY];
    }

    public void push(Object e) {
        ensureCapacity();
        elements[size++] = e;
    }

    // 会发生内存泄漏
    public Object pop() {
        if (size == 0)
            throw  new EmptyStackException();
        return elements[--size]; // 弹栈出去的元素实际上还在 elements 中
    }

    // 改进版
    public Object pop1() {
        if (size == 0)
            throw new EmptyStackException();
        Object result = elements[--size];
        elements[size] = null;
        return result;
    }

    // 扩容
    private void ensureCapacity() {
        if (elements.length == size)
            elements = Arrays.copyOf(elements, 2*size + 1);
    }
}

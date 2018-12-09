package com.tengdw.DataStructure;

/**
 * @author: Tengdw t_dw@qq.com
 * @create: 2018-12-04 00:19
 **/
public class main {
    public static void main(String[] args) {
        Array<Integer> array = new Array();
        for (int i = 0; i < 10; i++) {
            array.addLast(i);
        }
        System.out.println(array);

        array.addFirst(100);
        System.out.println(array);

        array.remove(2);
        System.out.println(array);

        array.removeElement(100);
        System.out.println(array);

        array.removeFirst();
        System.out.println(array);

    }
}

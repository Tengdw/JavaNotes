package com.tengdw.DataStructure;

import com.tengdw.DataStructure.LinkedList.LinkedList;
import com.tengdw.DataStructure.queue.ArrayQueue;
import com.tengdw.DataStructure.queue.LinkedListQueue;
import com.tengdw.DataStructure.queue.LoopQueue;
import com.tengdw.DataStructure.queue.Queue;
import com.tengdw.DataStructure.stack.ArrayStack;
import com.tengdw.DataStructure.stack.LinkedListStack;

/**
 * @author: Tengdw t_dw@qq.com
 * @create: 2018-12-04 00:19
 **/
public class main {
    public static void main(String[] args) {
        LinkedListQueue<Integer> queue = new LinkedListQueue<>();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            System.out.println(queue);
            if (i % 3 == 2) {
                queue.dequeue();
                System.out.println(queue);
            }
        }

    }
}

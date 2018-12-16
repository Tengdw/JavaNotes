package com.tengdw.DataStructure;

import com.tengdw.DataStructure.LinkedList.LinkedList;
import com.tengdw.DataStructure.queue.ArrayQueue;
import com.tengdw.DataStructure.queue.LinkedListQueue;
import com.tengdw.DataStructure.queue.LoopQueue;
import com.tengdw.DataStructure.queue.Queue;
import com.tengdw.DataStructure.stack.ArrayStack;
import com.tengdw.DataStructure.stack.LinkedListStack;
import com.tengdw.DataStructure.tree.BST;

/**
 * @author: Tengdw t_dw@qq.com
 * @create: 2018-12-04 00:19
 **/
public class main {
    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();
        int[] nums = {5, 3, 6, 8, 4, 2};
        //      5
        //   /    \
        //  3      6
        // / \      \
        //2   4      8
        for (int num : nums) {
            bst.add(num);
        }

        bst.preOrder();
        System.out.println();
        bst.inOrder();
        System.out.println();
        bst.postOrder();
        System.out.println();

//        System.out.println(bst);
    }
}

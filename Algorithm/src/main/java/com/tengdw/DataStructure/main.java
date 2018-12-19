package com.tengdw.DataStructure;

import com.tengdw.DataStructure.LinkedList.LinkedList;
import com.tengdw.DataStructure.queue.ArrayQueue;
import com.tengdw.DataStructure.queue.LinkedListQueue;
import com.tengdw.DataStructure.queue.LoopQueue;
import com.tengdw.DataStructure.queue.Queue;
import com.tengdw.DataStructure.stack.ArrayStack;
import com.tengdw.DataStructure.stack.LinkedListStack;
import com.tengdw.DataStructure.tree.BST;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author: Tengdw t_dw@qq.com
 * @create: 2018-12-04 00:19
 **/
public class main {
    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();
        int[] nums = {5, 3, 6, 8, 4, 2};
        Random random = new Random();
        //      5
        //   /    \
        //  3      6
        // / \      \
        //2   4      8
        for (int num : nums) {
            bst.add(num);
        }
//        bst.levelOrder();
//        System.out.println(bst.removeMin());
//        System.out.println(bst.removeMax());

        bst.preOrder();
        System.out.println();
        bst.inOrder();
        System.out.println();
        bst.postOrder();
        System.out.println();

//        System.out.println(bst);

//        for (int i = 0; i < 1000; i++) {
//            bst.add(random.nextInt(10000));
//        }
//        List<Integer> numbers = new ArrayList<>();
//        while (!bst.isEmpty()) {
//            numbers.add(bst.removeMin());
//        }
//        System.out.println(numbers);
//        for (int i = 1; i < numbers.size(); i++) {
//            if (numbers.get(i - 1) > numbers.get(i)) {
//                throw new IllegalArgumentException("Error");
//            }
//        }
    }
}
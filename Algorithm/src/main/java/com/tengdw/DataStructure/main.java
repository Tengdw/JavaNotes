package com.tengdw.DataStructure;

import com.tengdw.DataStructure.LinkedList.LinkedList;
import com.tengdw.DataStructure.heap.MaxHeap;
import com.tengdw.DataStructure.map.BSTMap;
import com.tengdw.DataStructure.queue.ArrayQueue;
import com.tengdw.DataStructure.queue.LinkedListQueue;
import com.tengdw.DataStructure.queue.LoopQueue;
import com.tengdw.DataStructure.queue.Queue;
import com.tengdw.DataStructure.stack.ArrayStack;
import com.tengdw.DataStructure.stack.LinkedListStack;
import com.tengdw.DataStructure.tree.BST;
import com.tengdw.DataStructure.tree.SegmentTree;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
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

        bst.preOrder(); // 5 3 2 4 6 8
        System.out.println();
        bst.inOrder(); //  2 3 4 5 6 8
        System.out.println();
//        bst.postOrder();
//        System.out.println();

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

    @Test
    public void test() {
        ArrayList<String> words = new ArrayList<>();
        if (FileOperation.readFile("D:\\Dev\\玩转数据结构www.dmzshequ.com\\Play-with-Data-Structures-master\\07-Set-and-Map\\06-LinkedListMap\\pride-and-prejudice.txt",
                words)) {
            BSTMap<String, Integer> map = new BSTMap<>();
            for (String word : words) {
                if (map.contains(word)) {
                    map.set(word, map.get(word) + 1);
                } else {
                    map.add(word, 1);
                }
            }
            System.out.println(map.getSize());
            System.out.println(map.get("pride"));
            System.out.println(map.get("prejudice"));
        }
    }

    @Test
    public void heapTest() {
        int n = 1_000_000;
        MaxHeap<Integer> heap = new MaxHeap<>();
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            heap.add(random.nextInt(Integer.MAX_VALUE));
        }
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = heap.extractMax();
        }
        for (int i = 1; i < n; i++) {
            if (arr[i - 1] < arr[i]) {
                throw new IllegalArgumentException("Error");
            }
        }
        System.out.println("complated!!!");
    }

    @Test
    public void segmentTreeTest() {
        Integer[] nums = {-2, 0, 3, -5, 2, -1};
        SegmentTree<Integer> tree = new SegmentTree<>(nums, (a, b) -> a + b);
//        System.out.println(tree);

        System.out.println(tree.query(0, 2)); // 1
        System.out.println(tree.query(2, 5)); // -1
        System.out.println(tree.query(0, 5)); // -3
    }
}

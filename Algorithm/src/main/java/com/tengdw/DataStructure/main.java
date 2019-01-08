package com.tengdw.DataStructure;

import com.tengdw.DataStructure.HashTable.HashTable;
import com.tengdw.DataStructure.UnionFind.UF;
import com.tengdw.DataStructure.UnionFind.UnionFind;
import com.tengdw.DataStructure.heap.MaxHeap;
import com.tengdw.DataStructure.map.BSTMap;
import com.tengdw.DataStructure.queue.LoopQueue;
import com.tengdw.DataStructure.set.BSTSet;
import com.tengdw.DataStructure.tree.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Random;

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
        bst.postOrder(); // 2 3 4 6 8 5
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

    @Test
    public void test() {
        ArrayList<String> words = new ArrayList<>();
        if (FileOperation.readFile("pride-and-prejudice.txt",
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

    @Test
    public void trieTest() {
        System.out.println("Pride and Prejudice");
        String file = "pride-and-prejudice.txt";
        ArrayList<String> words = new ArrayList<>();
        if(FileOperation.readFile(file, words)){

            long startTime = System.nanoTime();

            BSTSet<String> set = new BSTSet<>();
            for(String word: words)
                set.add(word);

            for(String word: words)
                set.contains(word);

            long endTime = System.nanoTime();

            double time = (endTime - startTime) / 1000000000.0;

            System.out.println("Total different words: " + set.getSize());
            System.out.println("BSTSet: " + time + " s");

            // ---

            startTime = System.nanoTime();

            Trie trie = new Trie();
            for(String word: words)
                trie.add(word);

            for(String word: words)
                trie.contains(word);

            endTime = System.nanoTime();

            time = (endTime - startTime) / 1000000000.0;

            System.out.println("Total different words: " + trie.getSize());
            System.out.println("Trie: " + time + " s");
        }
    }

    @Test
    public void unionFindTest() {
        // UnionFind1 慢于 UnionFind2
//        int size = 100000;
//        int m = 10000;

        // UnionFind2 慢于 UnionFind1, 但UnionFind3最快
        int size = 10000000;
        int m = 10000000;

//        UnionFind1 uf1 = new UnionFind1(size);
//        System.out.println("UnionFind1 : " + testUF(uf1, m) + " s");
        UnionFind uf2 = new UnionFind(size);
        System.out.println("UnionFind : " + testUF(uf2, m) + " s");
//        UnionFind3 uf3 = new UnionFind3(size);
//        System.out.println("UnionFind1 : " + testUF(uf3, m) + " s");


    }

    private static double testUF(UF uf, int m){

        int size = uf.getSize();
        Random random = new Random();

        long startTime = System.nanoTime();


        for(int i = 0 ; i < m ; i ++){
            int a = random.nextInt(size);
            int b = random.nextInt(size);
            uf.unionElements(a, b);
        }

        for(int i = 0 ; i < m ; i ++){
            int a = random.nextInt(size);
            int b = random.nextInt(size);
            uf.isConnected(a, b);
        }

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }

    @Test
    public void AVLTest() {
        System.out.println("Pride and Prejudice");
        String file = "pride-and-prejudice.txt";
        ArrayList<String> words = new ArrayList<>();
        if(FileOperation.readFile(file, words)) {
            System.out.println("Total words: " + words.size());
            // Collections.sort(words);
            long startTime = System.nanoTime();

            AVLTree<String, Integer> avl = new AVLTree<>();
            for (String word : words) {
                if (avl.contains(word))
                    avl.set(word, avl.get(word) + 1);
                else
                    avl.add(word, 1);
            }

            for(String word: words)
                avl.contains(word);

            long endTime = System.nanoTime();

            double time = (endTime - startTime) / 1000000000.0;
            System.out.println("AVL: " + time + " s");
        }

    }

    @Test
    public void hashTableTest() {
        System.out.println("Pride and Prejudice");

        ArrayList<String> words = new ArrayList<>();
        if(FileOperation.readFile("D:\\IdeaProjects\\JavaNotes\\Algorithm\\src\\main\\java\\com\\tengdw\\DataStructure\\pride-and-prejudice.txt", words)) {
            System.out.println("Total words: " + words.size());

            // Collections.sort(words);


            // Test AVL
            long startTime = System.nanoTime();

            AVLTree<String, Integer> avl = new AVLTree<>();
            for (String word : words) {
                if (avl.contains(word))
                    avl.set(word, avl.get(word) + 1);
                else
                    avl.add(word, 1);
            }

            for(String word: words)
                avl.contains(word);

            long endTime = System.nanoTime();

            double time = (endTime - startTime) / 1000000000.0;
            System.out.println("AVL: " + time + " s");


            // Test RBTree
            startTime = System.nanoTime();

            RBTree<String, Integer> rbt = new RBTree<>();
            for (String word : words) {
                if (rbt.contains(word))
                    rbt.set(word, rbt.get(word) + 1);
                else
                    rbt.add(word, 1);
            }

            for(String word: words)
                rbt.contains(word);

            endTime = System.nanoTime();

            time = (endTime - startTime) / 1000000000.0;
            System.out.println("RBTree: " + time + " s");


            // Test HashTable
            startTime = System.nanoTime();

            // HashTable<String, Integer> ht = new HashTable<>();
            HashTable<String, Integer> ht = new HashTable<>();
            for (String word : words) {
                if (ht.contains(word))
                    ht.set(word, ht.get(word) + 1);
                else
                    ht.add(word, 1);
            }

            for(String word: words)
                ht.contains(word);

            endTime = System.nanoTime();

            time = (endTime - startTime) / 1000000000.0;
            System.out.println("HashTable: " + time + " s");
        }

        System.out.println();
    }

    @Test
    public void testLoopQueue() {
        LoopQueue<Integer> loopQueue = new LoopQueue<>(3);
        loopQueue.enqueue(1);
        loopQueue.enqueue(2);
        loopQueue.enqueue(3);
    }
}

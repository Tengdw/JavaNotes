package com.tengdw.LeetCode;

import org.junit.Test;

import java.util.*;

/**
 * 按递增顺序显示卡牌
 *
 * @author Tengdw t_dw@qq.com
 * @description
 * @date 2019/1/8 15:27
 */
public class LeetCode950 {
    /*
    输入：[17,13,11, 2, 3, 5, 7]
           0  5  1  4  2  6  3
    输出：[ 2,13, 3,11, 5,17, 7]
           0  1  2  3  4  5  6
    排序：[ 2, 3, 5, 7,11,13,17]

    现在，重复执行以下步骤，直到显示所有卡牌为止：
        1.从牌组顶部抽一张牌，显示它，然后将其从牌组中移出。
        2.如果牌组中仍有牌，则将下一张处于牌组顶部的牌放在牌组的底部。
        3.如果仍有未显示的牌，那么返回步骤 1。否则，停止行动。

    逆向思考，我们把一组有序的牌按照上面的步骤堆起来，最后用同样的步骤取出还是有序的

    [ 2,13, 3,11, 5,17, 7] []
    [ 13, 3,11, 5,17, 7] [2,]
    [  3,11, 5,17, 7,13] [2,]
    [ 11, 5,17, 7,13] [2,3,]
    [  5,17, 7,13,11] [2,3,]
    [ 17, 7,13,11] [2,3,5]
    [  7,13,11,17] [2,3,5]
    [ 13,11,17] [2,3,5,7]
    [ 11,17,13] [2,3,5,7]
    [ 17,13] [2,3,5,7,11]
    [ 13,17] [2,3,5,7,11]
    [ 17] [2,3,5,7,11,13]
    [ ] [2,3,5,7,11,13,17]



     */
    class Solution {
        public int[] deckRevealedIncreasing(int[] deck) {
            int n = deck.length;
            Arrays.sort(deck);
            Queue<Integer> queue = new LinkedList<>();
            for (int i = 0; i < n; i++)
                queue.add(i);
            int[] res = new int[n];
            for (int i = 0; i < n; i++) {
                res[queue.poll()] = deck[i];
                queue.add(queue.poll());
            }
            return res;
        }
    }

    class Solution1 {
        public int[] deckRevealedIncreasing(int[] deck) {
            // 倒推
            Arrays.sort(deck);
            Deque<Integer> deque = new LinkedList<>();
            deque.offerFirst(deck[deck.length - 1]);
            for (int i = deck.length - 2;i >= 0; i--) {
                deque.offerFirst(deque.pollLast());
                deque.offerFirst(deck[i]);
            }

            int[] res = new int[deck.length];
            for (int i = 0;i < deck.length;i++) {
                res[i] = deque.pollFirst();
            }
            return res;
        }
    }

    @Test
    public void test() {
        int[] solute = {17,13,11,2,3,5,7};
        int[] ints = new Solution().deckRevealedIncreasing(solute);
        System.out.println(Arrays.toString(ints));
    }
}

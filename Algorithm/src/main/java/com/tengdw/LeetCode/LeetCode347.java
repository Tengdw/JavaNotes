package com.tengdw.LeetCode;

import org.junit.Test;

import java.util.*;

/**
 * 前K个高频元素
 * https://leetcode.com/problems/top-k-frequent-elements/
 *
 * @author: Tengdw t_dw@qq.com
 * @create: 2018-12-23 16:07
 **/
public class LeetCode347 {
    class Solution {
        public List<Integer> topKFrequent(int[] nums, int k) {
            //元素,频次
            TreeMap<Integer, Integer> map = new TreeMap<>();
            for (int num : nums) {
                if (map.containsKey(num)) {
                    map.put(num, map.get(num) + 1);
                } else {
                    map.put(num, 1);
                }
            }
            //让出现频次高的排在队列后面(最小堆)
            PriorityQueue<Freq> pq = new PriorityQueue<>();
//            PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a, b) -> map.get(a) - map.get(b));
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (pq.size() < k) {
                    pq.add(new Freq(entry.getKey(), entry.getValue()));
                } else if (entry.getValue() > pq.peek().freq) {
                    pq.poll();
                    pq.add(new Freq(entry.getKey(), entry.getValue()));
                }
            }
            LinkedList<Integer> result = new LinkedList<>();
            while (!pq.isEmpty()) {
                result.add(pq.poll().e);
            }
            return result;
        }

        private class Freq implements Comparable<Freq> {
            int e, freq; //元素,频次

            public Freq(int e, int freq) {
                this.e = e;
                this.freq = freq;
            }

            @Override
            public int compareTo(Freq another) {
                if (this.freq > another.freq)
                    return 1;
                else if (this.freq < another.freq)
                    return -1;
                else
                    return 0;
            }
        }
    }

    @Test
    public void test() {
        int[] nums = new int[]{4, 1, -1, 2, -1, 2, 3, -1, -1, 1, 1, 1, 1, 1, 2, 2, 5, 6, 9, 8, 8, 7, 9, -1, 9};
        int k = 2;
        Solution solution = new Solution();
        List<Integer> integers = solution.topKFrequent(nums, k);
        System.out.println(integers);
    }


}

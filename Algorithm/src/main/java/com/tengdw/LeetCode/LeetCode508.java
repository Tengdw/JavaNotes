package com.tengdw.LeetCode;

import com.tengdw.LeetCode.utils.TreeNode;
import org.junit.Test;

import java.util.*;

/**
 * 出现次数最多的子树元素和
 * https://leetcode.com/problems/most-frequent-subtree-sum/
 * @author Tengdw t_dw@qq.com
 * @description
 * @date 2018/12/26 10:03
 */
public class LeetCode508 {
    class Solution {
        int maxCount = 0;
        public int[] findFrequentTreeSum(TreeNode root) {
            //元素， 频次
            Map<Integer, Integer> map = new HashMap<>();
            postOrder(root, map);
            List<Integer> list = new ArrayList<>();
            for (Map.Entry<Integer, Integer> entry : map.entrySet())
                if (maxCount == entry.getValue())
                    list.add(entry.getKey());

            int[] result = new int[list.size()];
            for (int i = 0; i < list.size(); i++) {
                result[i] = list.get(i);
            }
            return result;
        }

        private int postOrder(TreeNode node, Map<Integer, Integer> map) {
            if (node == null) return 0;
            int left = postOrder(node.left, map);
            int right = postOrder(node.right, map);
            //当前节点子树元素和
            int sum = left + right + node.val;
            //子树元素和出现的次数
            int count = map.getOrDefault(sum, 0) + 1;
            map.put(sum, count);

            maxCount = Math.max(maxCount, count);
            return sum;
        }
    }

    @Test
    public void test() {
        TreeNode root = TreeNode.stringToTreeNode("[5,2,-5]");
        int[] ints = new Solution().findFrequentTreeSum(root);
        System.out.println(Arrays.toString(ints));
    }
}

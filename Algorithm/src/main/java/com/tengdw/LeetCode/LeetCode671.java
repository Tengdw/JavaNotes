package com.tengdw.LeetCode;

import com.tengdw.LeetCode.utils.TreeNode;

import java.util.HashSet;
import java.util.Set;


/**
 * 二叉树中第二小的节点
 * @author Tengdw t_dw@qq.com
 * @description
 * @date 2019/1/3 10:41
 */
public class LeetCode671 {
    class Solution {
        public int findSecondMinimumValue(TreeNode root) {
            Set<Integer> nums = new HashSet<>();
            helper(root, nums);
            int min = root.val;
            int ret = Integer.MAX_VALUE;
            for (Integer num : nums)
                if (num > min && num < ret)
                    ret = num;
            return ret == Integer.MAX_VALUE ? -1 : ret;
        }

        private void helper(TreeNode node, Set<Integer> set) {
            if (node == null) return;
            set.add(node.val);
            helper(node.left, set);
            helper(node.right, set);
        }
    }
}

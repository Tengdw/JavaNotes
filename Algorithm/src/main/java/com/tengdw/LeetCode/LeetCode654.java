package com.tengdw.LeetCode;

import com.tengdw.LeetCode.utils.TreeNode;
import org.junit.Test;

import java.util.Arrays;

/**
 * 最大二叉树
 * https://leetcode-cn.com/problems/maximum-binary-tree/
 *
 * @author Tengdw t_dw@qq.com
 * @description
 * @date 2018/12/17 10:27
 */
public class LeetCode654 {

    class Solution {
        public TreeNode constructMaximumBinaryTree(int[] nums) {
            if (nums == null || nums.length == 0) {
                return null;
            }
            int max = nums[0];
            int index = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > max) {
                    max = nums[i];
                    index = i;
                }
            }
            TreeNode root = new TreeNode(max);
//            int[] leftNums = Arrays.copyOfRange(nums, 0, index);
            int[] leftNums = new int[index];
            for (int i = 0; i < index; i++) {
                leftNums[i] = nums[i];
            }

//            int[] rightNums = Arrays.copyOfRange(nums, index + 1, nums.length);
            int[] rightNums = new int[nums.length - index - 1];
            int j = 0;
            for (int i = index + 1; i < nums.length; i++) {
                rightNums[j++] = nums[i];
            }
            root.left = constructMaximumBinaryTree(leftNums);
            root.right = constructMaximumBinaryTree(rightNums);
            return root;
        }
    }

    @Test
    public void test() {
        int[] nums = {3, 2, 1, 6, 0, 5};
        Solution solution = new Solution();
        TreeNode treeNode = solution.constructMaximumBinaryTree(nums);
        System.out.println();
    }
}

package com.tengdw.LeetCode;

import com.tengdw.LeetCode.utils.TreeNode;

/**
 * 将有序数组转换为二叉搜索树
 * https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
 * @author Tengdw t_dw@qq.com
 * @description
 * @date 2018/12/21 10:11
 */
public class LeetCode108 {
    class Solution {
        //[-11,-10,-7,-5,-4,-3,-1,0,3,5,7,9,10,15,16]
        public TreeNode sortedArrayToBST(int[] nums) {
            if (nums.length == 0) return null;
            return sortedArrayToBST(nums, 0, nums.length - 1);
        }

        private TreeNode sortedArrayToBST(int[] nums, int start, int end) {
            if (start > end) return null;
            //每次取数组下标start-end中间的数作为一个节点
            int mid = (end + start) / 2;
            TreeNode node = new TreeNode(nums[mid]);
            node.left = sortedArrayToBST(nums, start, mid - 1);
            node.right = sortedArrayToBST(nums, mid + 1, end);
            return node;
        }
    }

}

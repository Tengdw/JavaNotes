package com.tengdw.LeetCode;

import com.tengdw.LeetCode.utils.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 二叉搜索树中的众数
 *
 * @author Tengdw t_dw@qq.com
 * @description
 * @date 2019/1/3 17:35
 */
public class LeetCode501 {
    class Solution {
        Integer pre = null;
        int count = 1;
        int max = 0;

        public int[] findMode(TreeNode root) {
            if (root == null) return new int[0];
            List<Integer> list = new ArrayList<>();
            inOrder(root, list);
            int[] result = new int[list.size()];
            for (int i = 0; i < list.size(); i++) {
                result[i] = list.get(i);
            }
            return result;
        }

        private void inOrder(TreeNode node, List<Integer> list) {
            if (node == null) return;
            inOrder(node.left, list);
            if (pre != null) {
                if (pre == node.val)
                    count++;
                else
                    count = 1;
            }
            if (count > max) {
                max = count;
                list.clear();
                list.add(node.val);
            } else if (count == max) {
                list.add(node.val);
            }
            pre = node.val;
            inOrder(node.right, list);
        }
    }

    @Test
    public void test() {
        TreeNode root = TreeNode.stringToTreeNode("[1,null,2,2]");
        int[] mode = new Solution().findMode(root);
        System.out.println(Arrays.toString(mode));
    }
}

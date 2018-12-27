package com.tengdw.LeetCode;

import com.tengdw.LeetCode.utils.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * 两数之和 IV - 输入 BST
 * https://leetcode.com/problems/two-sum-iv-input-is-a-bst/
 * @author Tengdw t_dw@qq.com
 * @description
 * @date 2018/12/27 12:13
 */
public class LeetCode653 {
    class Solution {
        public boolean findTarget(TreeNode root, int k) {
            List<Integer> list = new ArrayList<>();
            preOrder(root, list);
            for (int i = 0; i < list.size() - 1; i++) {
                int num = k - list.get(i);
                for (int j = i + 1; j < list.size(); j++)
                    if (num == list.get(j))
                        return true;

            }
            return false;
        }

        private void preOrder(TreeNode node, List<Integer> list) {
            if (node == null) return;
            list.add(node.val);
            preOrder(node.left, list);
            preOrder(node.right, list);
        }
    }

    class Solution2 {
        public boolean findTarget(TreeNode root, int k) {
            HashSet<Integer> set = new HashSet<>();
            return dfs(root, set, k);
        }

        public boolean dfs(TreeNode root, HashSet<Integer> set, int k){
            if(root == null)return false;
            if(set.contains(k - root.val))return true;
            set.add(root.val);
            return dfs(root.left, set, k) || dfs(root.right, set, k);
        }
    }

    @Test
    public void test() {
        TreeNode root = TreeNode.stringToTreeNode("[5,3,6,2,4,null,7]");
        boolean target = new Solution().findTarget(root, 9);
        System.out.println(target);
    }

}

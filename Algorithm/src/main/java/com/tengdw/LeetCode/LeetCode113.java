package com.tengdw.LeetCode;

import com.tengdw.LeetCode.utils.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 路径总和 II
 * https://leetcode.com/problems/path-sum-ii/
 *
 * @author Tengdw t_dw@qq.com
 * @description
 * @date 2018/12/27 10:17
 */
public class LeetCode113 {
    class Solution {
        List<List<Integer>> result = new ArrayList<>();

        public List<List<Integer>> pathSum(TreeNode root, int sum) {
            dfs(root, sum, new ArrayList<>());
            return result;
        }

        private void dfs(TreeNode node, int sum, List<Integer> path) {
            if (node == null) return;
            if (sum - node.val == 0 && node.left == null && node.right == null) {
                path.add(node.val);
                result.add(new ArrayList<>(path));
                path.remove(path.size() - 1);
                return;
            }
            path.add(node.val);
            sum -= node.val;
            dfs(node.left, sum, path);
            dfs(node.right, sum, path);
            // path用作缓存，记录根节点到当前node的val值，
            // 所以每一层递归方法调用完成后要删除那一层添加的val
            path.remove(path.size() - 1);
        }
    }

    @Test
    public void test() {
        TreeNode root = TreeNode.stringToTreeNode("[5,4,8,11,null,13,4,7,2,null,null,5,1]");
        List<List<Integer>> lists = new Solution().pathSum(root, 22);
        System.out.println(lists);
    }
}

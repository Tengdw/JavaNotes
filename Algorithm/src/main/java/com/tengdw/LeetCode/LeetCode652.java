package com.tengdw.LeetCode;

import com.tengdw.LeetCode.utils.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 寻找重复的子树
 * https://leetcode.com/problems/find-duplicate-subtrees/
 *
 * @author Tengdw t_dw@qq.com
 * @description
 * @date 2018/12/28 15:52
 */
public class LeetCode652 {
    class Solution {
        List<TreeNode> result = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();

        public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
            if (root == null) return result;
            postOrder(root);
            return result;
        }

        private String postOrder(TreeNode node) {
            if (node == null) return "#";
            String str = node.val + ",";
            str += postOrder(node.left);
            str += ",";
            str += postOrder(node.right);
            if (map.getOrDefault(str, 0) == 1)
                result.add(node);
            map.put(str, map.getOrDefault(str, 0) + 1);
            return str;
        }

    }

    @Test
    public void test() {
        TreeNode root = TreeNode.stringToTreeNode("[1,2,3,4,null,2,4,null,null,4]");
        String s = new Solution().postOrder(root);
        System.out.println(s);
        Map<String, Integer> map = new Solution().map;
        System.out.println(map);
    }
}

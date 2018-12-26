package com.tengdw.LeetCode;

import com.tengdw.LeetCode.utils.TreeNode;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树的右视图
 * https://leetcode.com/problems/binary-tree-right-side-view/
 *
 * @author Tengdw t_dw@qq.com
 * @description
 * @date 2018/12/26 11:05
 */
public class LeetCode199 {
    class Solution {
        public List<Integer> rightSideView(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            if (root == null) return result;
            Queue<TreeNode> queue = new ArrayDeque<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                result.add(queue.peek().val);
                while (size-- > 0) {
                    TreeNode temp = queue.poll();
                    //让最右侧的元素先入队
                    if (temp.right != null)
                        queue.add(temp.right);
                    if (temp.left != null)
                        queue.add(temp.left);
                }
            }
            return result;
        }

        //深度搜索解法
        private void dfs(List<Integer> res, TreeNode root, int level){
            if(root == null){
                return;
            }
            if(res.size() == level){
                res.add(root.val);
            }
            else{
                res.set(level, root.val);
            }

            dfs(res, root.left, level + 1);
            dfs(res, root.right, level + 1);
        }
    }

    @Test
    public void test() {
        TreeNode root = TreeNode.stringToTreeNode("[1,2,3,null,5,null,4]");
        List<Integer> list = new Solution().rightSideView(root);
        System.out.println(list);
    }
}

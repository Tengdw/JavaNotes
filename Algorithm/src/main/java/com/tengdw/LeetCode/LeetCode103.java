package com.tengdw.LeetCode;

import com.tengdw.LeetCode.utils.TreeNode;
import org.junit.Test;

import java.util.*;

/**
 * 二叉树的锯齿形层次遍历
 *
 * @author Tengdw t_dw@qq.com
 * @description
 * @date 2019/1/2 14:44
 */
public class LeetCode103 {
    class Solution {
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            List<List<Integer>> ret = new ArrayList<>();
            if (root == null) return ret;
            Queue<TreeNode> queue = new ArrayDeque<>();
            queue.add(root);
            boolean flag = true;
            while (!queue.isEmpty()) {
                int size = queue.size();
                LinkedList<Integer> list = new LinkedList<>();
                while (size-- > 0) {
                    TreeNode cur = queue.poll();
                    if (flag) list.add(cur.val);
                    else list.addFirst(cur.val);

                    if (cur.left != null)
                        queue.add(cur.left);
                    if (cur.right != null)
                        queue.add(cur.right);
                }
                flag = flag ? false : true;
                ret.add(list);
            }
            return ret;
        }
    }

    @Test
    public void test() {
        TreeNode root = TreeNode.stringToTreeNode("[3,9,20,null,null,15,7]");
        List<List<Integer>> lists = new Solution().zigzagLevelOrder(root);
        System.out.println(lists);
    }
}
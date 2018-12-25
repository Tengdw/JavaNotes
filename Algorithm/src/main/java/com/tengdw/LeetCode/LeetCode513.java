package com.tengdw.LeetCode;

import com.tengdw.LeetCode.utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 找树左下角的值
 * https://leetcode.com/problems/find-bottom-left-tree-value/
 *
 * @author Tengdw t_dw@qq.com
 * @description
 * @date 2018/12/20 17:12
 */
public class LeetCode513 {
    class Solution {
        public int findBottomLeftValue(TreeNode root) {
            //使用层序遍历改变左右节点入队的顺序（即右先左后），最后一个出队的元素就是树最左边的元素
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                TreeNode node = queue.remove();
                //我想得到的是最左边的元素，所以左边的元素最后入队
                if (node.right != null)
                    queue.add(node.right);
                if (node.left != null)
                    queue.add(node.left);
                if (queue.isEmpty())
                    return node.val;
            }
            return 0;
        }
    }
}

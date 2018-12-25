package com.tengdw.LeetCode;

import com.tengdw.LeetCode.utils.ListNode;
import org.junit.Test;

/**
 * 移除链表元素 https://leetcode.com/problems/remove-linked-list-elements/description/
 *
 * @author: Tengdw t_dw@qq.com
 * @create: 2018-12-15 11:32
 **/
public class LeetCode203 {
    class SolutionV1 {
        public ListNode removeElements(ListNode head, int val) {
            //假设第一个Node的值就是val，以及第二个Node的值也是val，删除头节点
            while (head != null && head.val == val) {
                ListNode delNode = head;
                head = head.next;
                delNode.next = null;
                // 或者这样写
//                head = head.next;
            }
            if (head == null) {
                return null;
            }
            //此时在这里head不可能为val或null
            ListNode prev = head;
            while (prev.next != null) {
                if (prev.next.val == val) {
                    ListNode delNode = prev.next;
                    prev.next = delNode.next;
                    delNode.next = null;
                    // 或者这样写
//                    prev = prev.next.next;
                } else {
                    prev = prev.next;
                }
            }
            return head;
        }
    }

    class SolutionV2 {
        public ListNode removeElements(ListNode head, int val) {
            //使用虚拟头节点
            ListNode dummyHead = new ListNode(-1);
            dummyHead.next = head;
            ListNode prev = dummyHead;
            while (prev.next != null) {
                if (prev.next.val == val) {
                    ListNode delNode = prev.next;
                    prev.next = delNode.next;
                    delNode.next = null;
                    // 或者这样写
//                    prev = prev.next.next;
                } else {
                    prev = prev.next;
                }
            }
            return dummyHead.next;
        }
    }

    class SolutionV3 {
        public ListNode removeElements(ListNode head, int val) {
            if (head == null) {
                return null;
            }
            head.next = removeElements(head.next, val);
            return head.val == val ? head.next : head;
        }
    }

    @Test
    public void test() {
        int[] ints = new int[]{1, 2, 3, 4, 5, 6, 4, 3, 2, 4};
        ListNode listNode = new ListNode(0);
        for (int i : ints) {
            ListNode node = new ListNode(i);
            node.next = listNode;
            listNode = node;
        }
        System.out.println(listNode);
        SolutionV3 s = new SolutionV3();
        ListNode listNode1 = s.removeElements(listNode, 4);
        System.out.println(listNode1);
    }
}

package com.tengdw.LeetCode;


/**
 * 柠檬水找零
 *
 * @author Tengdw t_dw@qq.com
 * @description
 * @date 2019/1/8 11:07
 */
public class LeetCode860 {
    class Solution {
        public boolean lemonadeChange(int[] bills) {
            int five = 0;
            int ten = 0;
            for (int i = 0; i < bills.length; i++) {
                if (bills[i] == 5) {
                    five++;
                } else if (bills[i] == 10) {
                    if (five < 1) return false;
                    five--;
                    ten++;
                } else {
                    if (five > 0 && ten > 0) {
                        five--;
                        ten--;
                    } else if (five > 3) {
                        five -= 3;
                    } else {
                        return false;
                    }
                }
            }
            return true;
        }
    }
}

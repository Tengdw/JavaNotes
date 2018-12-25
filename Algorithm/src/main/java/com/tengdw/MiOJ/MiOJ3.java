package com.tengdw.MiOJ;

import org.junit.Test;

/**
 * 大数相减
 * 参考： https://mp.weixin.qq.com/s/GXclPfm_L2kIGAjgLSPX5g
 *
 * @author Tengdw t_dw@qq.com
 * @description
 * @date 2018/12/25 15:43
 */
public class MiOJ3 {
    /*
    426709752318-95481253129
    8 1 3 2 5 7 9 0 7 6 2 4
    9 2 1 3 5 2 1 8 4 5 9

    0 2 1
    0 3


    */
    private static String solution(String line) {
        String[] lineArr = line.split("-");
        int lengthA = lineArr[0].length();
        int[] a = new int[lengthA];//被减数
        int lengthB = lineArr[1].length();
        int[] b = new int[lengthB];//减数
        for (int i = 0; i < lengthA; i++) {
            a[i] = lineArr[0].charAt(lengthA - 1 - i) - '0';
        }
        for (int i = 0; i < lengthB; i++) {
            b[i] = lineArr[1].charAt(lengthB - 1 - i) - '0';
        }
        //构建result数组，数组长度等于被减数的长度
        int[] res = new int[lengthA];
        for (int i = 0; i < res.length; i++) {
            if (i > b.length - 1) {
                res[i] = a[i];
                continue;
            }
            if (a[i] >= b[i]) {
                res[i] = a[i] - b[i];
            //向高位借一位，高位存在为零的情况
            //题意 a>=b，最高位>=0
            } else {
                int j = i + 1;
                while (a[j] == 0) {
                    a[j] = 9;
                    j++;
                }
                a[j] = a[j] - 1;
                res[i] = a[i] + 10 - b[i];
            }
        }
        //逆序输出并找到最高有效位
        StringBuilder sb = new StringBuilder();
        boolean findFirst = false;
        for (int i = res.length - 1; i >= 0; i--) {
            if (!findFirst) {
                if (res[i] == 0)
                    continue;
                findFirst = true;
            }
            sb.append(res[i]);
        }
        return sb.toString();
    }

    /*
    1231231237812739878951331231231237812739878951331231231237812739878951331230000000000000000000000001
                                                                       331231231237812739878951331231231
    1231231237812739878951331231231237812739878951331231231237812739878620099998762187260121048668768770
                                                                                                       0
     */
    @Test
    public void test() {
        String input = "1231231237812739878951331231231237812739878951331231231237812739878951331231231237812739878951331231231237812739878951331231231237812739870-89513312312312378127398789513312312312378127398789513312312312378127398789513";
        String output = "1231231237812739878951331231231237812739878951331231231237812650365639018918853110413950365639018918853110413950365639018918853110413950357";
        String solution = solution(input);
        System.out.println(solution);
        System.out.println(output);
        System.out.println(solution.equals(output));
    }

    /**
     * 大整数求和
     *
     * @param bigNumberA 大整数A
     * @param bigNumberB 大整数B
     */

    public static String bigNumberSum(String bigNumberA, String bigNumberB) {
        //1.把两个大整数用数组逆序存储，数组长度等于较大整数位数+1
        int maxLength = bigNumberA.length() > bigNumberB.length() ? bigNumberA.length() : bigNumberB.length();
        int[] arrayA = new int[maxLength + 1];
        for (int i = 0; i < bigNumberA.length(); i++) {
            arrayA[i] = bigNumberA.charAt(bigNumberA.length() - 1 - i) - '0';
        }
        int[] arrayB = new int[maxLength + 1];
        for (int i = 0; i < bigNumberB.length(); i++) {
            arrayB[i] = bigNumberB.charAt(bigNumberB.length() - 1 -i) - '0';
        }
        //2.构建result数组，数组长度等于较大整数位数+1
        int[] result = new int[maxLength + 1];
        //3.遍历数组，按位相加
        for (int i = 0; i < result.length; i++) {
            int temp = result[i];
            temp += arrayA[i];
            temp += arrayB[i];
            //判断是否进位
            if (temp >= 10) {
                temp = temp - 10;
                result[i + 1] = 1;
            }
            result[i] = temp;
        }

        //4.把result数组再次逆序并转成String

        StringBuilder sb = new StringBuilder();
        //是否找到大整数的最高有效位
        boolean findFirst = false;
        for (int i = result.length - 1; i >= 0; i--) {
            if (!findFirst) {
                if (result[i] == 0) {
                    continue;
                }
                findFirst = true;
            }
            sb.append(result[i]);
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        System.out.println(bigNumberSum("426709752318", "95481253129"));
    }
}

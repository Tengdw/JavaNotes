package com.tengdw.sort;

import java.util.Arrays;

/**
 * @author Tengdw
 * https://mp.weixin.qq.com/s/PQLC7qFjb74kt6PdExP8mw
 * @date 2018/8/28 11:19
 */
public class QuickSort {


    public static void main(String[] args) {
        int[] arr = {4, 7, 6, 5, 3, 2, 8, 1};
        quickSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }


    public static void quickSort(int[] arr, int startIndex, int endIndex) {
        // 递归结束条件：startIndex大等于endIndex的时候
        if (startIndex >= endIndex) {
            return;
        }
//        int pivotIndex = partition(arr, startIndex, endIndex);
        int pivotIndex = partition2(arr, startIndex, endIndex);
        quickSort(arr, startIndex, pivotIndex-1);
        quickSort(arr, pivotIndex+1, endIndex);
    }

    // 挖坑法
    private static int partition(int[] arr, int startIndex, int endIndex) {
        // 取第一个位置的元素作为基准元素
        int pivot = arr[startIndex];
        int left = startIndex;
        int right = endIndex;
        // 坑的位置，初始等于pivot的位置
        int index = startIndex;

        //大循环在左右指针重合或者交错时结束
        while (right >= left) {
            //right指针从右向左进行比较
            while (right >= left) {
                if (arr[right] < pivot) {
                    arr[left] = arr[right];
                    index = right;
                    left++;
                    break;
                }
                right--;
            }
            //left指针从左向右进行比较
            while (right >= left) {
                if (arr[left] > pivot) {
                    arr[right] = arr[left];
                    index = left;
                    right--;
                    break;
                }
                left++;
            }
        }
        arr[index] = pivot;
        return index;
    }
    // 指针交换法
    private static int partition2(int[] arr, int startIndex, int endIndex) {
        // 取第一个位置的元素作为基准元素
        int pivot = arr[startIndex];
        int left = startIndex;
        int right = endIndex;

        while (left != right) {
            //控制right指针比较并左移
            while (left < right && arr[right] > pivot) {
                right--;
            }
            //控制left指针比较并右移
            while (left < right && arr[left] <= pivot) {
                left++;
            }
            //交换left和right指向的元素
            if (left < right) {
                int p = arr[left];
                arr[left] = arr[right];
                arr[right] = p;
            }
        }
        //pivot和指针重合点交换
        int p = arr[left];
        arr[left] = arr[startIndex];
        arr[startIndex] = p;
        return left;
    }
}

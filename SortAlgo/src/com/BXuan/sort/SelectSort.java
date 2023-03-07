package com.BXuan.sort;

import java.util.Arrays;
import java.util.Random;

public class SelectSort {
    public static void main(String[] args) {
        // 生成测试数组
        int[] arr1 = generateArray();
        // 生成新数组，并对数组进行copy
        int[] arr2 = new int[10000];
        System.arraycopy(arr1, 0, arr2, 0, arr2.length);
        // 使用系统算法进行排序
        Arrays.sort(arr1);
        // 使用自己实现的算法进行排序
        selectSort(arr2);

        System.out.println(check(arr1, arr2));
    }

    public static void selectSort(int[] arr){
        int len = arr.length;
        // len - 1：最后一个的时候没必要再排序，可以减少一层
        for (int i = 0; i < len - 1; i++){
            int flag = i;
            for (int j = i; j < len; j++) {
                flag = arr[flag] < arr[j] ? flag : j;
            }
            swap(arr, flag, i);
        }
    }

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    // 计数器，实现测试
    public static int[] generateArray(){
        Random random = new Random();
        int[] arr = new int[10000];

        for (int i = 0; i < 10000; i++) {
            arr[i] = random.nextInt(10000);
        }

        return arr;
    }
    // 实现数组检查功能
    public static boolean check(int[] arr1, int[] arr2){
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]){
                return false;
            }
        }
        return true;
    }
}

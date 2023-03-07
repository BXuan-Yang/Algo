package com.BXuan.sort;

import java.util.Arrays;
import java.util.Random;

public class BubbleSort {
    public static void main(String[] args) {
        // 生成测试数组
        int[] arr1 = generateArray();
        // 生成新数组并进行数组copy
        int[] arr2 = new int[10000];
        System.arraycopy(arr1, 0, arr2, 0, arr2.length);
        // 使用系统方法实现排序
        Arrays.sort(arr1);
        // 使用实现的冒泡排序进行排序
        bubbleSort(arr2);
        System.out.println(check(arr1, arr2));
    }

    public static void bubbleSort(int[] arr){
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]){
                    swap(arr, j, j + 1);
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    public static int[] generateArray(){
        Random random = new Random();
        int[] arr = new int[10000];

        for (int i = 0; i < 10000; i++) {
            arr[i] = random.nextInt(10000);
        }
        return arr;
    }

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static boolean check(int[] arr1, int[] arr2){
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]){
                return false;
            }
        }
        return true;
    }
}

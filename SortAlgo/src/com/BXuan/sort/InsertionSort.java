package com.BXuan.sort;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

public class InsertionSort {
    public static void main(String[] args) {
        System.out.println(check());;
    }
    public static void insertionSort(int[] arr){
        // 简化，不用swap
        for (int i = 1; i < arr.length; i++){
            int flag = i;
            int temp = arr[i];

            for (int j = i; j > 0; j--) {
                if (temp < arr[j - 1]){
                    flag = j - 1;
                }
            }
            // 进行数组的移动
            for (int x = i; x > flag; x--) {
                arr[x] = arr[x - 1];
            }
            arr[flag] = temp;
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
    public static boolean check(){
        // 生成测试数组
        int[] arr1 = generateArray();
        // 生成新数组并进行数组copy
        int[] arr2 = new int[10000];
        System.arraycopy(arr1, 0, arr2, 0, arr2.length);
        // 使用系统方法实现排序
        Arrays.sort(arr1);
        // 使用自定义插入排序实现排序
        insertionSort(arr2);

        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]){
                return false;
            }
        }
        return true;
    }
}

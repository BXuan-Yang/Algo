package com.BXuan.sort;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

public class ShellSort {
    public static void main(String[] args) {
        System.out.println(check());
    }

    public static void shellSort(int[] arr){
        // 引入Knuth序列
        int h = 1;
        while (h < arr.length){
            h = 3 * h + 1;
        }

        for (int gap = h; gap > 0; gap = (gap - 1)/3){
            for (int i = gap; i < arr.length; i++){
                for (int j = i; j > gap - 1 && arr[j] < arr[j - gap]; j -= gap) {
                    swap(arr, j, j - gap);
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

    public static boolean check(){
        int[] arr1 = generateArray();
        int[] arr2 = new int[10000];
        System.arraycopy(arr1, 0, arr2, 0, arr2.length);

        Arrays.sort(arr1);

        shellSort(arr2);

        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]){
                return false;
            }
        }
        return true;
    }
}

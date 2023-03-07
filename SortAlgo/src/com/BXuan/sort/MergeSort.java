package com.BXuan.sort;

import java.util.Arrays;
import java.util.Random;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = generateArray();
        int[] copyArr = new int[10000];
        System.arraycopy(arr, 0, copyArr, 0, copyArr.length);
        Arrays.sort(copyArr);
        process02(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println("*********************");
        for (int i = 0; i < copyArr.length; i++) {
            if (arr[i] != copyArr[i]){
                System.out.println("false");
                return;
            }
        }
        System.out.println("true");
    }
    // 递归
    public static void process(int[] arr, int begin, int end){
        if (begin == end){
            return;
        }
        int mid = begin + (end - begin) / 2;
        process(arr, begin, mid);
        process(arr, mid + 1, end);
        merge(arr, begin, mid, end);
    }
    // 归并整合
    public static void merge(int[] arr, int begin, int middle, int end){
        int[] temp = new int[end - begin + 1];

        int i = begin;
        int j = middle + 1;
        int k = 0;

        while (i <= middle && j <= end){
            temp[k++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
        }
        while (i <= middle){
            temp[k++] = arr[i++];
        }
        while (j <= end){
            temp[k++] = arr[j++];
        }
        System.arraycopy(temp, 0, arr, begin, temp.length);
    }
    // 非递归归并排序算法
    public static void process02(int[] arr){
        if (arr == null || arr.length < 2){
            return;
        }
        // 步长从一开始
        int step = 1;
        int N = arr.length;

        while (step < N){
            int L = 0;
            while (L < N){
                int M = 0;
                // 需要考虑越界问题
                if (N - L >= step){
                    M = L + step - 1;
                }else {
                    M = N - 1;
                }
                // L......M
                if (M == N - 1){
                    break;
                }
                int R = 0;
                if (N - 1 - M >= step){
                    R = M + step;
                }else {
                    R = N - 1;
                }
                // M+1......R
                merge(arr, L, M, R);
                if (R == N - 1){
                    break;
                }else {
                    L = R + 1;
                }
            }
            // 步长的变化，需要考虑溢出
            if (step > (N / 2)){
                break;
            }else {
                step *= 2;
            }
        }
    }
    // 计数器
    public static int[] generateArray(){
        Random random = new Random();
        int[] arr = new int[10000];

        for (int i = 0; i < 10000; i++) {
            arr[i] = random.nextInt(10000);
        }
        return arr;
    }
}

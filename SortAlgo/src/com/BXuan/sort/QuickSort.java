package com.BXuan.sort;

import java.util.Arrays;
import java.util.Stack;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {1,2,5,3,6,4,2,3,5,1,7,8,99,88,77,55,22,33,10};
        quickSort02(arr);
        System.out.println(Arrays.toString(arr));
    }
    // 非递归实现
    // 工作类
    public static class Job{
        public int L;
        public int R;
        public Job(int l, int r) {
            L = l;
            R = r;
        }
    }
    public static void quickSort02(int[] arr){
        if (arr == null || arr.length < 2){
            return;
        }
        Stack<Job> stack = new Stack<>();
        stack.add(new Job(0, arr.length - 1));

        while (!stack.isEmpty()){
            Job job = stack.pop();
            int[] partition = partition(arr, job.L, job.R);
            if (partition[0] > job.L){
                stack.add(new Job(job.L, partition[0] - 1));
            }
            if (partition[1] < job.R){
                stack.add(new Job(partition[1] + 1, job.R));
            }
        }
    }

    // 递归实现
    public static void quickSort(int[] arr){
        if (arr == null || arr.length < 2){
            return;
        }
        process(arr, 0, arr.length -1);
    }
    public static void process(int[] arr, int L, int R){
        if (L >= R){
            return;
        }
        int[] equalE = partition(arr, L, R);
        process(arr, L, equalE[0] - 1);
        process(arr, equalE[1] + 1, R);
    }
    // 获得小于区和大于区的边界值
    public static int[] partition(int[] arr, int L, int R){
        int lessR = L - 1;
        int moreL = R;
        int index = L;

        while (index < moreL){
            if (arr[index] < arr[R]){
                swap(arr, ++lessR, index++);
            }else if (arr[index] > arr[R]){
                swap(arr, --moreL, index);
            }else {
                index++;
            }
        }
        swap(arr, moreL, R);
        return new int[]{lessR + 1, moreL};
    }
    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

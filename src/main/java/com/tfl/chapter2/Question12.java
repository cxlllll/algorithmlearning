package com.tfl.chapter2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 整数数组：求出数组中一个他左右两边的子数组和相等的数，要是没有这个数，那么返回-1，要是有多个数，则返回最左面的数
 * 要点就是 下标为i的左子数组的和为0加到i，右子数组的和为数列和减去左子树组加她本身
 */
public class Question12 {
    public static void main(String[] args) {
        int[] arr={1,1,1,1,14,2,1,1};
        System.out.println(findTarget(arr));
    }
    public static  int findTarget(int[] arr){
        int result = -1;
        int sum = arr[0];
        int totalSum = Arrays.stream(arr).sum();
        for(int a=1;a<arr.length;a++){
            sum +=arr[a];
            if((sum-arr[a])==(totalSum-sum)){
                return arr[a];
            }
        }
        return result;
    }
}

package com.teacherMAN.chapterOne;

import java.util.Arrays;

/**
 * 冒泡排序
 * 紧邻元素交换位置 交换完一轮排好序一个元素
 */
public class MaoPaoSort {
    public  static void sort(int[] arr,int a,int b ){
        if(b==0){
            return; // 当右边界为0时，说明已经没有元素可以交换了
        }
        // 对传入的数组的边界进行元素大小位置交换 【a,b】
        for(;a<b;a++){
            if(arr[a]>arr[a+1]){
               int k = arr[a];
               arr[a] = arr[a+1];
               arr[a+1] = k;
            }
        }
        sort(arr,a,b-1);
    }

    public  static void sort2(int[] arr,int a,int b ){
        if(b==0){
            return; // 当右边界为0时，说明已经没有元素可以交换了
        }
        int m = b-1;// 记录最后一次交换的位置的左边元素，因为最后一次的交换的位置的右边的所有元素代表已经是排好序的
        // 对传入的数组的边界进行元素大小位置交换 【a,b】
        for(;a<b;a++){
            if(arr[a]>arr[a+1]){
                int k = arr[a];
                arr[a] = arr[a+1];
                arr[a+1] = k;
                m = a;
            }
        }
        sort(arr,a,m);
    }

    public static void main(String[] args) {
        int[] arr={10,23,12,29,40};
        sort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}

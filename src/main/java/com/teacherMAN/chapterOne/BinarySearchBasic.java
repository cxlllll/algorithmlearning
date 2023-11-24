package com.teacherMAN.chapterOne;

public class BinarySearchBasic {
    /**
     * 需要注意的问题
     * 1. 整数越界问题 采用无符号右移解决·
     * @param arr
     * @param target
     * @return
     */
    public static int  binarySearchBasic(int arr[],int target){
        int a=0,b=arr.length-1;
        while(a<=b){
            int mid = (a+b)>>>1;// 无符号右移 怎么都是整数
            if(target < arr[mid]){
                b  = mid-1;
            }else if(arr[mid] < target){
                a = mid+1;
            }else {
             return  mid;
            }
        }
        return -1;
    }

    public static int  binarySearchBasic2(int arr[],int target){
        int a=0,b=arr.length;
        while(a<b){
            int mid = (a+b)>>>1;// 无符号右移 怎么都是整数
            if(target < arr[mid]){
                b  = mid;
            }else if(arr[mid] < target){
                a = mid+1;
            }else {
                return  mid;
            }
        }
        return -1;
    }
}

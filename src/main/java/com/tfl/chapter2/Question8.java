package com.tfl.chapter2;

/**
 * 请问正整数数组中和大于等于K的最短连续子数组的长度
 * 解题思路：双指针 因为是结果是连续子数组，所以需要所有组合都进行扫描
 * ：步骤 ：
 * 1、两个指针（p1 p2）指向第一个元素 要是两个指针之间的元素的和小于k，那么p2向右移动，要是大于k，则p1向右移动
 *
 */
public class Question8 {
    public int minSubArrayLength(int[] arr,int target){
        int result = Integer.MAX_VALUE;
        int leftPointer = 0;// 第一个指针
        int sum = 0;
        for(int rightPointer = 0;rightPointer<arr.length;rightPointer++){
            sum +=arr[rightPointer];// 加右边的值
            while(leftPointer<= rightPointer && sum>= target){
                result = Math.min(result,rightPointer-leftPointer+1);
                sum -=arr[leftPointer++];// 左指针向右移动并且和需要减去移动值
                System.out.println(sum+"   "+leftPointer);
            }
        }
        return  result == Integer.MAX_VALUE ?0 :result;
    }

    public static void main(String[] args) {
        int[] arr = {2,3,6,9,0,5};
        Question8 question8 = new Question8();
        System.out.println( question8.minSubArrayLength(arr,13));
    }
}

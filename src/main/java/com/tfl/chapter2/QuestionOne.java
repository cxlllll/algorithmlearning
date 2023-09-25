package com.tfl.chapter2;

/**
 * 问题：给出排好序的整数数组和一个指定的数k，求出数组中和为k的两数的下标，整数不重复且只有一对整数的和为k。
 * 解题思路：使用双指针实现
 */
public class QuestionOne {
    public  int[] twoSum(int[] numbers,int target){
        int firstPointer=0;//第一个指针
        int secondPointer=numbers.length-1;// 第二个指针
        while(firstPointer<secondPointer && (numbers[firstPointer]+numbers[secondPointer])!=target){
            if(numbers[firstPointer]+numbers[secondPointer]>target){
                secondPointer--;
            }else{
                firstPointer++;
            }
        }
        return  new int[]{firstPointer,secondPointer};
    }

    public static void main(String[] args) {
        int[] nums = {1,2,10,22,3,15,9};
        QuestionOne one = new QuestionOne();
        int[] results = one.twoSum(nums, 4);
        System.out.println(results);
    }
}

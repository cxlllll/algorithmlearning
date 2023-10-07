package com.tfl.chapter2;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

/**
 * 题目描述：正整数数组和一个正整数k，请问 数组中有多少个数字乘积小于k的连续子数组
 * 步骤：使用双指针  当找到的数组乘积小于k时，那么指针之间的所有数组都乘积都小于k，要去掉重复数组
 * 新增的子数组里 是不是都包含r这个位置 而包含这个位置的子数组数量就是r-l+1
 */
public class QuestionNine {
    public int subArrayProductLessTraget(int[] arr,int k){
        long product = 1;// 存储乘积
        int left = 0;
        int result = 0;
        for(int right = 0;right<arr.length;right++){
            product *= arr[right];
            while(left <= right && product >=k){
                product /=arr[left++];
            }
            result +=right>left?right-left+1:0;
        }
        return result;
    }

    public static void main(String[] args) {
        QuestionNine questionNine = new QuestionNine();
        int[] arr = {10,5,2,6};
        int i = questionNine.subArrayProductLessTraget(arr, 100);
        System.out.println(i);
    }
}

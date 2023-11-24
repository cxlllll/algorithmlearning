package com.tfl.chapter2;

import java.util.HashMap;
import java.util.Map;

/**
 * 输入一个整数的数组，找出和为K的子数组的个数
 * 要点：1.如果使用暴力解法：总共有N方级别的子数组个数，每个子数组的求和需要便利数组来求出所以是N，所以总的结果就是N3次方数量级。
 * 因此，可以转变思路，索引为0到i的子数组和为A，0到k的子数组和为B，i到k的和就是B-A；这样算每个子数组和的复杂度就是O（1）；
 */
public class QuestionTen {
    public static int findSubArrCounts(int[] arr,int k){
        int sum = 0;
        int result = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int target:arr){
            sum  +=target;
            result +=map.getOrDefault(sum-k,0);
            map.put(sum,(map.getOrDefault(sum-k,0))+1);
        }
        return  result;
    }

    public static void main(String[] args) {
        int[] arr = {11,9,20,18,2,5,10,3,17};
        System.out.println(findSubArrCounts(arr,20));
    }
}

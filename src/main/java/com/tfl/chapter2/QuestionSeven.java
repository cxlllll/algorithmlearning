package com.tfl.chapter2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 找到数组中和为0的3个数，不允许出现重复的组合
 * 题目重点：1.数组不是排好序的 2.不能重复所以扫描过的数字需要跳过
 *  可以把三数之后转成两数之和
 */
public class QuestionSeven {
    public static void main(String[] args) {
        int[] nums ={12,3,37,-3,0,-4,-37};
        QuestionSeven two = new QuestionSeven();
        List<List<Integer>> lists = two.threeSum(nums);
        System.out.println(lists);
    }

    public List<List<Integer>>  threeSum(int nums[]){
        List<List<Integer>> result = new LinkedList<List<Integer>>();

        if(nums.length>3){
            Arrays.sort(nums);
        }
        int i=0;
        while (i<nums.length-2){
            int currNum = nums[i];
            twoSum(i,result,nums);
            // 为了跳过重复数字的
            while(nums[i]==currNum && i<nums.length-2){
                i++;
            }
        }
        return  result;
    }

    // 得到两个数的和并存结果
    private void twoSum(int i, List<List<Integer>> result, int[] nums) {
        int m = i+1;
        int n = nums.length-1;
        // 计算两数之和是否为某个数
        while(m<n){
            if (nums[i]+nums[m]+nums[n] == 0){
                result.add(Arrays.asList(nums[i],nums[m],nums[n]));
                int currNum = nums[m];
                while(nums[m]==currNum && m<n){
                    m++;
                }
            }else if(nums[i]+nums[m]+nums[n] > 0){
                n--;
            }else{
                m++;
            }
        }
    }
}

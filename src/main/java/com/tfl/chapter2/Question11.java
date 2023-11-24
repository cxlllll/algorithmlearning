package com.tfl.chapter2;

import java.util.HashMap;
import java.util.Map;

/**
 * 第十一题：只有1，0的整数数组，求出数组中1，0出现个数一致的子数组的最大长度
 * 解题思路：可以将0换成-1，那么如果出现了1，0个数一致的子数组，那么他们的和为零。所以转成了求和为0的最长子数组，求和0转成0-i的和为k，0到z的和为零，那么z到i+1的子数组和为0
 */
public class Question11 {
    public static void main(String[] args) {
        int[] arr = {1,0,1,1,0,1,0,1,1,1};
        System.out.println(findSubArrMaxLength(arr));
        for(int a =0;a<1;a++){
            int s = a;
            new Thread(){
                @Override
                public void run() {
                    System.out.println(s);
                }
            }.start();
        }
    }

    public static int findSubArrMaxLength(int[] arr){
        int result = 0;
        Map<Integer,Integer> map = new HashMap<>();
        int sum=0;
        for(int a=0;a<arr.length;a++){
            sum +=arr[a]==0?-1:1;
            if(map.containsKey(sum)){
                result = Math.max(result,a-map.get(sum));
            }else{
                // 只有在sum出现第一次的时候存入哈希表，这样就可以保证得到的数组长度是最大的。
                map.put(sum,a);
            }
        }
        return result;
    }


}

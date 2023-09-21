package com.tfl.chapter1;

import java.util.Arrays;

/**
 * 给出一个非负整数n  求出0-n每一个数的二进制数的1的个数，并输出一个数组来记录每一个二进制数的1的个数
 */
public class QuestionThree {

    public static void main(String[] args) {
        QuestionThree three = new QuestionThree();
        three.countsBitsTwo(4);
        System.out.println(Arrays.toString(three.getCountsArr(4)));

    }

    public String[] getCountsArr(int target){
        String[] result= new String[target+1];

        for(int n=0;n<=target;n++){
            result[n]=String.valueOf(countBits(n));
        }

        return result;
    }

    //暴力解法 将数转成二进制并输出1的个数
    private  int countBits(int target){
        int result=0;
        // 这里应该是target应该是>0 不然计算不到1的情况
        while(target >0){
            int a = target/2; //得到商
            int b = target%2; // 得到余数
            if (b==1){
                result++;
            }
            target = a;
        }
        return result;

    }


    //使用i&(i-1)的方法 每次进行这个操作 ，i的最右边的1变为0，相当于每一次i&（i-1）的结果k的1的个数比i的少1
    private int[] countsBitsTwo(int target){
        int[] arr = new int[target+1];
        int copyTar = target;
        for(int a = 1;a<=target;a++){
            arr[a] = arr[a&(a-1)]+1;
        }
        return  arr;
    }

    // 还有第三种解法

}

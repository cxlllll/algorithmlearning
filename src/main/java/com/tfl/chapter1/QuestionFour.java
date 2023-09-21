package com.tfl.chapter1;

/**
 * 问题： 一个数组 数组里所有的整数 只有一个数字出现一次 其他数字出现3次 请找出出现一次的那个数字
 * 拓展：要是其他数字出现2次，则可以对所有数字进行亦或运算，因为一个数字亦或他本身结果为0，任何数与0亦或则为他本身。
 * 一个整数包含32位 每一位不是1就是0 所以，要是将所有数字的每一位都相加，每一位都对3求余，余数为1则说明出现一次的数字的这一位就是1，为0则为0
 *   一个整数 n，n&1的结果为n的最低位，
 *   关注点   运算符优先级   ！非 ~取反 算术运算符（++ -- 在前面） 位移 关系（ &>^>|>&&>||>） 三元 赋值
 */
public class QuestionFour {
    public static void main(String[] args) {
        QuestionFour questionFour = new QuestionFour();
        int[] nums = {12,12,12,9,9,9,8};
        int i = questionFour.singleNumber(nums);
        System.out.println(i);
    }

        public int singleNumber(int[] nums){
            int[] bitSums = new int[32];
            for(int num:nums){
                for(int n =0;n<32;n++){
                    bitSums[n] +=num>>(31-n)&1;
                }
            }
            // 计算出这个二进制得值
            int result =0;
            for(int a =0;a<32;a++){
                result = (result<<1)+bitSums[a]%3;
            }
            return  result;
        }



}

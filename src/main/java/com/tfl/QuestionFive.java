package com.tfl;

/**
 * 问题5：一个英文单词数组  {'abc','foo','cdc','kppkll'} 求出没有共同字母的两个单词的长度的乘积
 * 思路： 可以将每个单词的是否出现某个字母的结果记成1和0，所以每个单词都可以当成长度为26的二进制数，
 */
public class QuestionFive {
    public int getMaxProduct(String[] words){
        int result = 0;
        int[] flags =new int[26];// 用来记录每个单词的二进制
        for(int a= 0;a<words.length;a++){
         for(char word:words[a].toCharArray()){
            flags[a] |=1<<(word-'a');
         }
        }
        for(int a=0;a<words.length;a++){
            for(int b=a+1;b<words.length;b++){
                if((flags[a] & flags[b]) ==0){
                    int currResult=words[a].length() * words[b].length();
                    result = Math.max(result,currResult);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        QuestionFive five = new QuestionFive();
        String[] words = {"abccc","cdf","poip","reds","bbbbbb"};
        System.out.println(five.getMaxProduct(words));
    }
}

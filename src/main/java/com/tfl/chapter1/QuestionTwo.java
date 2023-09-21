package com.tfl.chapter1;

/**
 * 第二个问题
 *  两个二进制数加法  解法1 先将两个数转转成整数 （存在溢出问题） 解法2.二进制意味一位一位相加
 *
 *
 *  遇到的问题
 *  1. 当前位的结果  sum = sum >1?sum -2:sum;
 *  2. 循环判断时的条件判断是否需要等号
 */
public class QuestionTwo {

    /**
     * 相加两个字串类型的二进制数
     * @param a
     * @param b
     * @return
     */
    public String addBinary(String a,String b){
        StringBuffer result = new StringBuffer();// 用来存储结果
            int lengthA = a.length()-1;
            int lengthB = b.length()-1;
        int carrySize = 0;
            while(lengthA >=0 || lengthB >=0){
                //1 获取每一位 要是其中一位比较短 那么他的当前位记为0就好
                int i = lengthA>=0? a.charAt(lengthA--) - '0':0;
                int k = lengthB>=0?b.charAt(lengthB--)-'0':0;
                // 2.获取当前位计算结果
                int sum = i+k+carrySize;
                //3 记录当前位计算结果是否需要进位
                carrySize=sum>1?1:0;
                sum = sum >1?sum -2:sum;
                result.append(sum);
            }
            if(carrySize>0){
                result.append(carrySize);
            }
            // 将结果反转
            return  result.reverse().toString();
    }

    public static void main(String[] args) {
        String a = "10110";
        String b = "111";
        QuestionTwo questionTwo = new QuestionTwo();
        System.out.println(questionTwo.addBinary(a,b));
    }
}

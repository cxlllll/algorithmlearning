package com.tfl;

/**
 *
 * 不能使用除法 乘法 求余 操作来算出两个整数的除法结果
 * 核心就是 被除数是除数的多少倍
 * 需要注意的点：1.溢出问题  2.优化  2.1将两个数转成同正或者同负  2.2使用除数累加 后相减的方法
 */
public class QuestionOne {
    public static void main(String[] args) {
            int a= 2003;
            int b=23;
        System.out.println(divide(a,b));
    }

    /**
     * 除法
     */
    public static int divide(int dividend,int divisor){
        // 1.首先排除 溢出的情况
        if(dividend==0x80000000 && divisor ==-1){
            return Integer.MAX_VALUE;
        }
        // 2.转成负数进行运算 因为正数可能存在溢出情况
        int nevigate = 2;
        if (dividend > 0) {
            nevigate--;
            dividend =-dividend;
        }
        if (divisor > 0) {
            nevigate--;
            divisor =-divisor;
        }
        int result = divideCore(dividend, divisor);
        return nevigate==1? -result:result;
    }

    /**
     * 都是负数
     * @param dividend  被除数
     * @param divisor   除数
     * @return
     */
    private static int divideCore(int dividend,int divisor){
        int result = 0;
        while(dividend < divisor){
            int addSum = divisor; // 用来做一个累加和
            int accumulator = 1;//用来累加的次数
            // 第一个条件是防止溢出
            while(divisor > 0xc0000000 && dividend < addSum+addSum){
                accumulator +=accumulator;
                addSum +=addSum;
//                result = result+accumulator; 放到这里效率没这么高
//                dividend -=addSum;
            }
            result = result+accumulator;
            dividend -=addSum;
        }
        return  result;
    }
}

package com.teacherMAN.chapterOne;

/**
 * 斐波那锲数列
 */
public class FeiBoNaqie {
    public static int f(int n){
        if(n==0){
            return 0;
        }
        if(n==1){
            return  1;
        }
        return f(n-1)+f(n-2);
    }

    // 兔子问题
    public static int f1(int n){
        if(n==1){
            return 1;
        }
        if(n==2){
            return 1;
        }
        return f1(n-1)+f1(n-2);
    }


}

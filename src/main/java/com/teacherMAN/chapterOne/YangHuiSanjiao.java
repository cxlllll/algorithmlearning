package com.teacherMAN.chapterOne;

/**
 * 杨辉三角形
 */
public class YangHuiSanjiao {
    /**
     * 根据位置 求出此索引的值
     * @return
     */
    public static int element(int i,int j){
        // 递归停止条件 每行的首个元素与最后一个元素 的值为1
        if(j==0 || i==j){
            return 1;
        }
        return element(i-1,j)+element(i-1,j-1);
    }

    public static void printSanjiao(int n){
        for (int i = 0; i < n; i++) {
            if (i < n - 1) {
                System.out.printf("%" + 2 * (n - 1 - i) + "s", " ");
            }

            for (int j = 0; j < i + 1; j++) {
                System.out.printf("%-4d", element(i, j));
            }
            System.out.println();
        }
    }

    /**
     * 优化 使用一维数组+循环来代替递归
     * @param args
     */
    public static  void sanjiao(int[] arr,int n){
        if(n==0){
            arr[n] = 1;
            return;
        }
        for(int j= n;j>0;j--){
            arr[j] = arr[j]+arr[j-1];
        }
    }

    public static void print2(int n){
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            sanjiao(arr,i);
            if (i < n - 1) {
                System.out.printf("%" + 2 * (n - 1 - i) + "s", " ");
            }

            for (int j = 0; j <= i; j++) {
                System.out.printf("%-4d", arr[j]);
            }
            System.out.println();
        }

    }
    public static void main(String[] args) {
        printSanjiao(7);
        System.out.println("----------");
        print2(7);
    }
}

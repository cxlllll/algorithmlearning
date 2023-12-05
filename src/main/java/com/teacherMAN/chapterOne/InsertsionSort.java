package com.teacherMAN.chapterOne;

/**
 * 插入排序
 */
public class InsertsionSort {
    /**
     *
     * @param arr
     * @param low  待插入的元素的索引 每一次只进行一个元素的插入
     */
    public void sort(int[] arr,int low){
        if(low == arr.length){
            return;
        }
        int i = arr[low];
        int j = low-1;// 已排序位置指针
        // 1.寻找插入位置
        while( j>=0 && i < arr[j]){
            arr[j+1] = arr[j];
            j--;
        }
        // 2. 移动元素 留出插入空间
        arr[j+1] = i;
        sort(arr,low+1);
    }

    /**
     *
     * @param arr
     * @param low
     * @param high
     */
    public void sort(int[] arr,int low,int high){

    }
}

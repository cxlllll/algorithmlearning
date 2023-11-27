package com.teacherMAN.chapterOne;

public class BinarySearchBasic {
    /**
     * 需要注意的问题
     * 1. 整数越界问题 采用无符号右移解决·
     * 要是没有找到目标元素，左索引为插入点。
     * @param arr
     * @param target
     * @return
     */
    public static int  binarySearchBasic(int arr[],int target){
        int a=0,b=arr.length-1;
        while(a<=b){
            int mid = (a+b)>>>1;// 无符号右移 怎么都是整数
            if(target < arr[mid]){
                b  = mid-1;
            }else if(arr[mid] < target){
                a = mid+1;
            }else {
             return  mid;
            }
        }
        return -1;
    }

    public static int  binarySearchBasic2(int arr[],int target){
        int a=0,b=arr.length;
        while(a<b){
            int mid = (a+b)>>>1;// 无符号右移 怎么都是整数
            if(target < arr[mid]){
                b  = mid;
            }else if(arr[mid] < target){
                a = mid+1;
            }else {
                return  mid;
            }
        }
        return -1;
    }

    /**
     * 找到最左侧代码
     * @param arr
     * @param target
     * @return
     */
    public static  int binarySearchMostLeftBasic(int arr[],int target){
        int left = 0;
        int right = arr.length-1;
        int index = -1;
        while(left<=right){
            int mid = (right+left)>>>1;
            if(arr[target]<arr[mid]){
                right  = mid-1;
            }else if(arr[mid] < target){
                left = mid+1;
            }else {
                index = mid;
                right = mid-1; // 求最左边的数 所以需要继续向左边的元素开始排查
            }
        }
        if(index >0){
            return  index;
        }
        return -(left+1);
    }

    /**
     * 可以直接返回左指针 ；代表了 ：如果找到就是索引，没有找到就返回带查找元素的位置的索引+1的地方；
     * @param arr
     * @param target
     * @return  返回的是 >= target的最靠左的索引
     */
    public static  int binarySearchMostLeft(int arr[],int target){
        int left = 0;
        int right = arr.length-1;
        while(left<=right){
            int mid = (right+left)>>>1;
            if(arr[target]<=arr[mid]){
                right  = mid-1;
            }else if(arr[mid] < target){
                left = mid+1;
            }
        }
        return  left;
    }

    /**
     *
     * @param arr
     * @param target
     * @return 返回的是<= target的最靠右边的索引
     */
    public static  int binarySearchMostRight(int arr[],int target){
        int left = 0;
        int right = arr.length-1;
        int index = -1;
        while(left<=right){
            int mid = (right+left)>>>1;
            if(arr[target]<arr[mid]){
                right  = mid-1;
            }else if(arr[mid] < target){
                left = mid+1;
            }else {
                index = mid;
                left = mid+1; // 求最左边的数 所以需要继续向左边的元素开始排查
            }
        }
        if(index >0){
            return  index;
        }
        return -(left+1);
    }
}

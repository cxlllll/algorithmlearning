package com.teacherMAN.chapterOne;

import java.util.Iterator;

public class DynamicArray implements Iterable<Integer>{
    private int size=0;
    private int capicity=8;
    private int[] array = {};

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            int i = 0;
            @Override
            public boolean hasNext() {
                return i<size;
            }

            @Override
            public Integer next() {
                return array[i++];
            }
        };
    }

    public void addLast(int value){
        add(size,value);
    }

    public void add(int index,int target){
        // 先判断在不在size中，不过不在会发生断层  index = size情况不需要移动元素
        if(0 >= size && index<size){
            System.arraycopy(array,index,array,index+1,size-index);
        }
        array[index] = target;
        size++;
    }

    // 检查容量
    private void checkAndGrow(){
        if(size == 0){
            array = new int[capicity];
        }else if(size == capicity){
            capicity += capicity>>1;
            int[] copyArr = new int[capicity];
            System.arraycopy(array,0,copyArr,0,size);
            array = copyArr;
        }
    }

}

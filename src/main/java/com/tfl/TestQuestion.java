package com.tfl;

public class TestQuestion {
    public static void main(String[] args) {
        int a=10;
        System.out.println(Integer.toBinaryString(a));
        int i = a & (a - 1);
        System.out.println(i);
        System.out.println(Integer.toBinaryString(i));
    }
}

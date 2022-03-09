package com.lhz.house.utils;

public class TestUtility {
    public static void main(String[] args) {
        String s1 = Utility.readString(3);
        System.out.println("s=" + s1);

        String s2 = Utility.readString(10, "liHua");
        System.out.println(s2);
    }
}

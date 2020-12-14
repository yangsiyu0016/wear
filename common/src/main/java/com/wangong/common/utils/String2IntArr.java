package com.wangong.common.utils;

public class String2IntArr {

    public static Integer[] String2IntArr(String arrStr) {
        Integer[] arr = new Integer[arrStr.length()];
        for (int i = 0; i < arrStr.length(); i++) {
            arr[i] = Integer.parseInt(arrStr.substring(i, i + 1));//substring是找出包含起始位置，不包含结束位置，到结束位置的前一位的子串
        }
        return arr;
    }

}

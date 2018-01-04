package com.wsh.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ELUtil {
    /**
     *  1. 必须是静态方法
     *  2.  方法必须有返回值
     * @param input
     * @return
     */
    public static String reverse(String input,int length){
        char[] chars1 = input.toCharArray();
        String output = "";
        for (int i = chars1.length-1 ; i >= 0 ; i--){
            output += chars1[i];
        }
        return output;
    }
}

package com.wsh;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        int [] array = {5,6,8,9,1,4,35,8,3,1,65,34,3,46,64,32,6,1,33};

        int low,middle,high,temp;
        for (int i = 1; i < array.length; i++) {
            temp = array[i];
            low = 0;
            high = i - 1;
            while(low <= high){
                middle = (low + high) /2;
                if (array[i]<array[middle]){
                    high = middle -1;
                }else {
                    low = middle + 1;
                }
            }
            for (int j = i - 1;j >= low; j--) {
                array[j+1] = array[j];
            }
            array[low] = temp;

        }
        System.out.println(Arrays.toString(array));

    }
}

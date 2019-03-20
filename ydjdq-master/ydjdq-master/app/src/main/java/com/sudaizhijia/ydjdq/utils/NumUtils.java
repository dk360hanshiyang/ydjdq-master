package com.sudaizhijia.ydjdq.utils;

import java.util.Random;

public class NumUtils {

    public static int getNum(int startNum, int endNum) {
        if (endNum > startNum) {
            Random random = new Random();
            return random.nextInt(endNum - startNum) + startNum;
        }
        return 0;
    }
}

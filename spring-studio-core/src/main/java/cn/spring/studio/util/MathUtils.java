package cn.spring.studio.util;

import org.apache.commons.lang3.ArrayUtils;

/**
 * Created by minjay on 2017/5/8.
 */
public abstract class MathUtils {

    public static double max(Double... values) {
        Double[] arr = ArrayUtils.toArray(values);
        double max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }
}

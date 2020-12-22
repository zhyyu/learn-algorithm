package com.zhyyu.learn.algorithm.chapter2;

import java.util.Arrays;

/**
 * @author zhongyu.yzy
 * @date 2020/12/21
 */
public abstract class AbstractSort {

    public abstract void sort(Comparable[] valArr);

    protected boolean less(Comparable value1, Comparable value2) {
        return value1.compareTo(value2) < 0;
    }

    protected boolean equal(Comparable value1, Comparable value2) {
        return value1.compareTo(value2) == 0;
    }

    protected boolean great(Comparable value1, Comparable value2) {
        return value1.compareTo(value2) > 0;
    }

    protected void exchange(Comparable[] valArr, int i, int j) {
        Comparable tmp = valArr[i];
        valArr[i] = valArr[j];
        valArr[j] = tmp;
    }

    protected void testSort() {
        Integer[] intArr = {1, 4, 6, 5, 8, 2, 7, 3};
        sort(intArr);
        System.out.println(Arrays.asList(intArr));
    }

}

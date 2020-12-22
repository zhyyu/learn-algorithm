package com.zhyyu.learn.algorithm.chapter2;

/**
 * @author zhongyu.yzy
 * @date 2020/12/21
 */
public class Sort_2_1_3_Insertion extends AbstractSort {

    public void sort(Comparable[] valArr) {
        for (int i = 1; i < valArr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (less(valArr[j], valArr[j - 1])) {
                    exchange(valArr, j, j - 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        Sort_2_1_3_Insertion insertionSort = new Sort_2_1_3_Insertion();
        insertionSort.testSort();
    }

}

package com.zhyyu.learn.algorithm.chapter2;

/**
 * @author zhongyu.yzy
 * @date 2020/12/21
 */
public class Sort_2_1_2_Selection extends AbstractSort {

    @Override
    public void sort(Comparable[] valArr) {
        for (int i = 0; i < valArr.length; i++) {
            Comparable val = valArr[i];
            Comparable min = val;
            int minIndex = i;
            for (int j = i; j < valArr.length; j++) {
                if (less(valArr[j], min)) {
                    minIndex = j;
                    min = valArr[j];
                }
                exchange(valArr, i, minIndex);
            }
        }
    }

    public static void main(String[] args) {
        Sort_2_1_2_Selection selectionSort = new Sort_2_1_2_Selection();
        selectionSort.testSort();
    }

}

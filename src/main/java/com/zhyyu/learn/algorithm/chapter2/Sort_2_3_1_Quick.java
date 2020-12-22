package com.zhyyu.learn.algorithm.chapter2;

/**
 *
 * @author zhongyu.yzy
 * @date 2020/12/22
 */
public class Sort_2_3_1_Quick extends AbstractSort {

    @Override
    public void sort(Comparable[] valArr) {
        sort(valArr, 0, valArr.length - 1);
    }

    private void sort(Comparable[] valArr, int low, int high) {
        if (low >= high) {
            return;
        }
        int mid = partition(valArr, low, high);
        sort(valArr, low, mid - 1);
        sort(valArr, mid + 1, high);
    }

    private int partition(Comparable[] valArr, int low, int high) {
        int ascIndex = low;
        int descIndex = high + 1;

        Comparable splitVal = valArr[low];
        while (true) {
            while (less(valArr[++ascIndex], splitVal)) {
                if (ascIndex == high) {
                    break;
                }
            }

            while (less(splitVal, valArr[--descIndex])) {
                if (descIndex == low) {
                    break;
                }
            }

            if (ascIndex >= descIndex) {
                break;
            }

            exchange(valArr, ascIndex, descIndex);
        }

        exchange(valArr, low, descIndex);
        return descIndex;
    }

    public static void main(String[] args) {
        Sort_2_3_1_Quick sort_2_3_1_quick = new Sort_2_3_1_Quick();
        sort_2_3_1_quick.testSort();
    }
}

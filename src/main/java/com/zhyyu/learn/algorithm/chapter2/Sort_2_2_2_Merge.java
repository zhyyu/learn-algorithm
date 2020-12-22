package com.zhyyu.learn.algorithm.chapter2;

import java.util.Arrays;

/**
 * @author zhongyu.yzy
 * @date 2020/12/22
 */
public class Sort_2_2_2_Merge extends AbstractSort {

    // varArr[low-mid] varArr[mid-high] 为有序数组
    public void merge(Comparable[] valArr, int low, int mid, int high) {
        Comparable[] temValArr = Arrays.copyOf(valArr, valArr.length);
        int low4Second = mid;

        // low -> mid low4Second -> high
        for (int i = low; i <= high; i++) {
            // 第一段空
            if (low > mid - 1) {
                valArr[i] = temValArr[low4Second];
                low4Second++;
                continue;
            }

            // 第二段空
            if (low4Second > high) {
                valArr[i] = temValArr[low];
                low++;
                continue;
            }

            // 第一段值更小
            if (less(temValArr[low], temValArr[low4Second]) || equal(temValArr[low], temValArr[low4Second])) {
                valArr[i] = temValArr[low];
                low++;
                continue;
            }

            // 第二段值更小
            if (less(temValArr[low4Second], temValArr[low])) {
                valArr[i] = temValArr[low4Second];
                low4Second++;
                continue;
            }
        }
    }

    public static void main(String[] args) {
        Comparable[] valArr = {1, 3, 5, 2, 4, 6};
        Sort_2_2_2_Merge mergeSort_2_2_2 = new Sort_2_2_2_Merge();
        mergeSort_2_2_2.merge(valArr, 0, 3, 5);
        System.out.println(Arrays.asList(valArr));

        System.out.println("=======");
        mergeSort_2_2_2.testSort();
    }

    @Override
    public void sort(Comparable[] valArr) {
        int high = valArr.length - 1;
        int low = 0;
        sort(valArr, low, high);
    }

    private void sort(Comparable[] valArr, int low, int high) {
        if (low >= high) {
            return;
        }
        int mid = (low + high) / 2;
        sort(valArr, low, mid);
        sort(valArr, mid + 1, high);
        merge(valArr, low, mid + 1, high);
    }
}

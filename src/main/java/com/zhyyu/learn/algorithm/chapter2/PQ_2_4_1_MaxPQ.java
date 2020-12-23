package com.zhyyu.learn.algorithm.chapter2;

/**
 * @author zhongyu.yzy
 * @date 2020/12/23
 */
public class PQ_2_4_1_MaxPQ<T extends Comparable<T>> {

    private T[] treeData;
    private int N = 0;

    public PQ_2_4_1_MaxPQ(int maxN) {
        treeData = (T[]) new Comparable[maxN + 1];
    }

    public void Insert(T v) {
        treeData[++N] = v;
        swim(N);
    }

    public T max() {
        return treeData[1];
    }

    public T delMax() {
        T max = treeData[1];
        exchange(1, N--);
        treeData[N + 1] = null;
        sink(1);
        return max;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    private boolean less(int i, int j) {
        return treeData[i].compareTo(treeData[j]) < 0;
    }

    private void exchange(int i, int j) {
        T tmp = treeData[i];
        treeData[i] = treeData[j];
        treeData[j] = tmp;
    }

    private void swim(int k) {
        while (k > 1 && less(k/2, k)) {
            exchange(k/2, k);
            k = k / 2;
        }
    }

    private void sink(int k) {
        while (2 * k <= N) {
            int j = 2 * k;
            if (j < N && less(j, j + 1)) {
                j++;
            }
            if (!less(k, j)) {
                break;
            }

            exchange(k, j);
            k = j;
        }
    }

}

package com.zhyyu.learn.algorithm.jianzhi;


/**
 * @author zhongyu.yzy
 * @date 2021/1/20
 */
public class Jianzhi_04_二维数组中的查找_TODO利用列有序 {

    // TODO: juror 2021/1/20 列有序， 待利用
    public static void main(String[] args) {
        int[] line1 = new int[]{1, 4, 7, 11, 15};
        int[] line2 = new int[]{2, 5, 8, 12, 19};
        
        int[][] matrix = new int[][]{line1, line2};
        System.out.println(findNumberIn2DArray(matrix, 9));
    }

    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        for (int[] line : matrix) {
            if (line.length == 0) {
                continue;
            }

            if (twoDividedFind(line, 0, line.length - 1, target)) {
                return true;
            }
        }

        return false;
    }

    public static boolean twoDividedFind (int[] line, int low, int high, int target) {
        if (low == high) {
            if (line[low] == target) {
                return true;
            } else {
                return false;
            }
        }

        if (target < line[low]) {
            return false;
        }

        if (target > line[high]) {
            return false;
        }

        int mid = (low + high) / 2;
        if (line[mid] == target) {
            return true;
        }

        if (line[mid] > target) {
            return twoDividedFind(line, low, mid - 1, target);
        }

        if (line[mid] < target) {
            return twoDividedFind(line, mid + 1, high, target);
        }

        throw new RuntimeException("cannot reach");
    }

}

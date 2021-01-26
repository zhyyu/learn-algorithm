package com.zhyyu.learn.algorithm.jianzhi;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author zhongyu.yzy
 * @date 2021/1/26
 */
public class Jianzhi_29_顺时针打印矩阵 {

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[] result = new Solution().spiralOrder(matrix);
        for (int val : result) {
            System.out.println(val);
        }
    }

    static class Solution {

        private List<Position> spiralPositionList = new ArrayList<>();

        public int[] spiralOrder(int[][] matrix) {
            if (matrix.length == 0) {
                return new int[]{};
            }

            if (matrix[0].length == 0) {
                return new int[]{};
            }

            if (matrix.length == 1 && matrix[0].length == 1) {
                return new int[]{matrix[0][0]};
            }


            Position firstPosition = new Position(0, 0);
            firstPosition.tryRight = true;
            spiralPositionList.add(firstPosition);

            Position nextPosition = firstPosition;
            do {
                nextPosition = findNextPosition(nextPosition, matrix);
                if (nextPosition != null) {
                    spiralPositionList.add(nextPosition);
                }
            } while (nextPosition != null);

            int[] spiralVal = new int[spiralPositionList.size()];
            for (int i = 0; i < spiralPositionList.size(); i++) {
                spiralVal[i] = matrix[spiralPositionList.get(i).i][spiralPositionList.get(i).j];
            }

            return spiralVal;
        }

        private Position findNextPosition(Position position, int[][] matrix) {
            int lines = matrix.length;
            int columns = matrix[0].length;

            Position nextPosition = null;

            if (position.tryRight) {
                nextPosition = new Position(position.i, position.j + 1);
                if (position.j + 1 < columns && !spiralPositionList.contains(nextPosition)) {
                    nextPosition.tryRight = true;
                    return nextPosition;
                }

                nextPosition = new Position(position.i + 1, position.j);
                if (position.i + 1 < lines && !spiralPositionList.contains(nextPosition)) {
                    nextPosition.tryDown = true;
                    return nextPosition;
                }

                return null;
            }

            if (position.tryDown) {
                nextPosition = new Position(position.i + 1, position.j);
                if (position.i + 1 < lines && !spiralPositionList.contains(nextPosition)) {
                    nextPosition.tryDown = true;
                    return nextPosition;
                }

                nextPosition = new Position(position.i, position.j - 1);
                if (position.j - 1 >= 0 && !spiralPositionList.contains(nextPosition)) {
                    nextPosition.tryLeft = true;
                    return nextPosition;
                }

                return null;
            }

            if (position.tryLeft) {
                nextPosition = new Position(position.i, position.j - 1);
                if (position.j - 1 >= 0 && !spiralPositionList.contains(nextPosition)) {
                    nextPosition.tryLeft = true;
                    return nextPosition;
                }

                nextPosition = new Position(position.i - 1, position.j);
                if (position.i - 1 >= 0 && !spiralPositionList.contains(nextPosition)) {
                    nextPosition.tryUp = true;
                    return nextPosition;
                }

                return null;
            }

            if (position.tryUp) {
                nextPosition = new Position(position.i - 1, position.j);
                if (position.i - 1 >= 0 && !spiralPositionList.contains(nextPosition)) {
                    nextPosition.tryUp = true;
                    return nextPosition;
                }

                nextPosition = new Position(position.i, position.j + 1);
                if (position.j + 1 < columns && !spiralPositionList.contains(nextPosition)) {
                    nextPosition.tryRight = true;
                    return nextPosition;
                }

                return null;
            }

            return null;
        }

        static class Position {
            int i;
            int j;

            boolean tryUp;
            boolean tryDown;
            boolean tryLeft;
            boolean tryRight;

            public Position(int i, int j) {
                this.i = i;
                this.j = j;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Position position = (Position) o;
                return i == position.i && j == position.j;
            }

            @Override
            public int hashCode() {
                return Objects.hash(i, j);
            }
        }
    }

}

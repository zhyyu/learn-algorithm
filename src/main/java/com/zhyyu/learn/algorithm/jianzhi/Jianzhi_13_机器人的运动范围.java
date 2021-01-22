package com.zhyyu.learn.algorithm.jianzhi;

import java.util.*;

/**
 * @author zhongyu.yzy
 * @date 2021/1/22
 */
public class Jianzhi_13_机器人的运动范围 {

    public static void main(String[] args) {
        System.out.println(new Solution().movingCount(2, 3, 1));
    }

    static class Solution {

        private Set<Position> determinedPositionSet = new HashSet<>();

        public int movingCount(int m, int n, int k) {
            Position startPosition = new Position(0, 0);
            determinedPositionSet.add(startPosition);

            Set<Position> nearlyDeterminedPositionSet = new HashSet<>();
            nearlyDeterminedPositionSet.add(startPosition);
            while (!nearlyDeterminedPositionSet.isEmpty()) {
                nearlyDeterminedPositionSet = listNearlyDeterminedPosition(determinedPositionSet, m, n, k);
                determinedPositionSet.addAll(nearlyDeterminedPositionSet);
            }

            return determinedPositionSet.size();
        }

        private Set<Position> listNearlyDeterminedPosition(Set<Position> determinedPositionSet, int m, int n, int k) {
            Set<Position> nearlyPositionSet = new HashSet<>();

            for (Position determinedPosition : determinedPositionSet) {
                // up
                if (determinedPosition.i - 1 >= 0) {
                    if (calDigitalSum(determinedPosition.i - 1, determinedPosition.j) <= k) {
                        Position upPosition = new Position(determinedPosition.i -1, determinedPosition.j);
                        nearlyPositionSet.add(upPosition);
                    }
                }

                // down
                if (determinedPosition.i + 1 < m) {
                    if (calDigitalSum(determinedPosition.i + 1, determinedPosition.j) <= k) {
                        Position downPosition = new Position(determinedPosition.i + 1, determinedPosition.j);
                        nearlyPositionSet.add(downPosition);
                    }
                }

                // left
                if(determinedPosition.j - 1 >= 0) {
                    if (calDigitalSum(determinedPosition.i, determinedPosition.j - 1) <= k) {
                        Position leftPosition = new Position(determinedPosition.i, determinedPosition.j - 1);
                        nearlyPositionSet.add(leftPosition);
                    }
                }

                // right
                if (determinedPosition.j + 1 < n) {
                    if (calDigitalSum(determinedPosition.i, determinedPosition.j + 1) <= k) {
                        Position rightPosition = new Position(determinedPosition.i, determinedPosition.j + 1);
                        nearlyPositionSet.add(rightPosition);
                    }
                }
            }

            nearlyPositionSet.removeAll(determinedPositionSet);

            return nearlyPositionSet;
        }

        private int calDigitalSum(int i, int j) {
            String iStr = i + "";
            String jStr = j + "";

            char[] iChars = iStr.toCharArray();
            char[] jChars = jStr.toCharArray();

            int digitalSum = 0;
            for (char iChar : iChars) {
                digitalSum += Integer.valueOf(iChar + "");
            }

            for (char jChar : jChars) {
                digitalSum += Integer.valueOf(jChar + "");
            }

            return digitalSum;
        }


        static class Position {
            int i;
            int j;

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

package com.zhyyu.learn.algorithm.jianzhi;

import java.util.*;

/**
 * @author zhongyu.yzy
 * @date 2021/1/21
 */
public class Jianzhi_12_矩阵中的路径 {

    public static void main(String[] args) {

        char[][] board = new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        System.out.println(new Solution().exist(board, "ABCCED"));

//        char[][] board = new char[][]{{'A','B','C','E'},{'S','F','E','S'},{'A','D','E','E'}};
//        System.out.println(new Solution().exist(board, "ABCESEEEFS"));
    }
    
    static class Solution {

        private List<Position> visitedPositionList = new ArrayList<>();

        public boolean exist(char[][] board, String word) {
            // find firstChar position
            List<Position> firstCharPositionList = listFirstCharPosition(board, word);
            if (firstCharPositionList.size() == 0) {
                return false;
            }

            // 深度优先搜索
            for (Position firstCharPosition : firstCharPositionList) {
                String firstPart = buildPartWord(firstCharPosition, board);
                if (word.equals(firstPart)) {
                    return true;
                }

                Stack<Position> dfsStack = new Stack<>();
                dfsStack.add(firstCharPosition);
                while (!dfsStack.isEmpty()) {
                    Position position = dfsStack.pop();
                    visitedPositionList.add(position);
                    List<Position> nextPositionList = nextPosition(position, board);

                    if (nextPositionList.size() == 0) {
                        clearVisited(position);
                        continue;
                    }

                    boolean deadWay = true;
                    int partNum = 0;
                    for (Position nextPosition : nextPositionList) {
                        // 是否full match word
                        if (isFullMatchedWord(nextPosition, word, board)) {
                            return true;
                        }

                        // 是否part match word
                        if (isPartMatchedWord(nextPosition, word, board)) {
                            partNum++;
                            deadWay = false;
                            dfsStack.add(nextPosition);
                        }
                    }

                    if (partNum > 1) {
                        position.splitNum = partNum;
                    }

                    if (deadWay) {
                        clearVisited(position);
                    }
                }

                visitedPositionList = new ArrayList<>();
            }

            return false;
        }

        private void clearVisited(Position position) {
            // 清除visited 标记
            boolean hasSplit = false;
            Position currentPosition = position;
            while (currentPosition.previousPosition != null) {
                currentPosition = currentPosition.previousPosition;
                if (currentPosition.splitNum > 1) {
                    hasSplit = true;
                    break;
                }
            }

            if (currentPosition.splitNum > 1) {
                hasSplit = true;
            }

            // 有过split 当前结点至split 结点，visited 标识清除
            if (hasSplit) {
                while (position.previousPosition != null && (position.splitNum == 0)) {
                    visitedPositionList.remove(position);
                    position = position.previousPosition;
                }

                if (position.splitNum > 1) {
                    if (position.splitNum == 2) {
                        position.splitNum = 0;
                    } else {
                        position.splitNum = position.splitNum - 1;
                    }
                }
            }
        }

        private List<Position> listFirstCharPosition(char[][] board, String word) {
            List<Position> firstCharPositionList = new ArrayList<>();

            char firstChar = word.charAt(0);
            for (int i = 0; i < board.length; i++) {
                char[] line = board[i];
                for (int j = 0; j < line.length; j++) {
                    char aChar = board[i][j];
                    if (aChar == firstChar) {
                        Position firstCharPosition = new Position(i, j);
                        firstCharPositionList.add(firstCharPosition);
                    }
                }
            }

            return firstCharPositionList;
        }

        private boolean isFullMatchedWord(Position position, String word, char[][] board) {
            String partWord = buildPartWord(position, board);
            return word.equals(partWord);
        }

        private boolean isPartMatchedWord(Position position, String word, char[][] board) {
            String partWord = buildPartWord(position, board);
            return word.contains(partWord);
        }

        private String buildPartWord(Position position, char[][] board) {
            String partWord = "";
            while (position.previousPosition != null) {
                char aChar = getChar(position, board);
                partWord = aChar + partWord;
                position = position.previousPosition;
            }

            partWord = getChar(position, board) + partWord;
            return partWord;
        }

        private char getChar(Position position, char[][] board) {
            return board[position.i][position.j];
        }

        private List<Position> nextPosition(Position position, char[][] board) {
            int lineNum = board.length;
            int columnNum = board[0].length;

            List<Position> nextPositionList = new ArrayList<>();

            // up
            Position nextUpPosition = null;
            if (position.i - 1 >= 0) {
                nextUpPosition = new Position(position.i - 1, position.j);
                if (!visitedPositionList.contains(nextUpPosition)) {
                    nextUpPosition.previousPosition = position;
                    nextPositionList.add(nextUpPosition);
                }
            }

            // down
            Position nextDownPosition = null;
            if (position.i + 1 < lineNum) {
                nextDownPosition = new Position(position.i + 1, position.j);
                if (!visitedPositionList.contains(nextDownPosition)) {
                    nextDownPosition.previousPosition = position;
                    nextPositionList.add(nextDownPosition);
                }
            }

            // left
            Position nextLeftPosition = null;
            if (position.j - 1 >= 0) {
                nextLeftPosition = new Position(position.i, position.j - 1);
                if (!visitedPositionList.contains(nextLeftPosition)) {
                    nextLeftPosition.previousPosition = position;
                    nextPositionList.add(nextLeftPosition);
                }
            }

            // right
            Position nextRightPosition = null;
            if (position.j + 1 < columnNum) {
                nextRightPosition = new Position(position.i, position.j + 1);
                if (!visitedPositionList.contains(nextRightPosition)) {
                    nextRightPosition.previousPosition = position;
                    nextPositionList.add(nextRightPosition);
                }
            }

            return nextPositionList;
        }

        static class Position {
            int i;
            int j;
            Position previousPosition;
            int splitNum = 0;

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

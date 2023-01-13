package day4;

public class P4_java {
    class NumMatrix {

        int[][] matrixSum;

        public NumMatrix(int[][] matrix) {
            matrixSum = new int[matrix.length + 1][matrix[0].length + 1];
            for (int i = 1; i < matrixSum.length; i++) {
                for (int j = 1; j < matrixSum[i].length; j++) {
                    matrixSum[i][j] = matrixSum[i - 1][j] + matrixSum[i][j - 1] - matrixSum[i - 1][j - 1] + matrix[i - 1][j - 1];
                }
            }

        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            return matrixSum[row2 + 1][col2 + 1] - matrixSum[row1][col2 + 1] - matrixSum[row2 + 1][col1] + matrixSum[row1][col1];
        }
    }

}

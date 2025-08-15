// Given an N * N 2D integer matrix, rotate the matrix by 90 degrees clockwise.

// The rotation must be done in place, meaning the input 2D matrix must be modified directly.

// Examples:
// Input: matrix = [[1, 2, 3], [4, 5, 6], [7, 8, 9]]

// Output: matrix = [[7, 4, 1], [8, 5, 2], [9, 6, 3]]

// Input: matrix = [[0, 1, 1, 2], [2, 0, 3, 1], [4, 5, 0, 5], [5, 6, 7, 0]]

// Output: matrix = [[5, 4, 2, 0], [6, 5, 0, 1], [7, 0, 3, 1], [0, 5, 1, 2]]

public class RotateMatrix90 {
    public static void rotate(int[][] matrix) {
        int n = matrix.length;

        // Step 1: Transpose the matrix
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Step 2: Reverse each row
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix1 = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        rotate(matrix1);
        printMatrix(matrix1);

        int[][] matrix2 = {
            {0, 1, 1, 2},
            {2, 0, 3, 1},
            {4, 5, 0, 5},
            {5, 6, 7, 0}
        };

        rotate(matrix2);
        printMatrix(matrix2);
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}

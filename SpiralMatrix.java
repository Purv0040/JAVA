// Given an M * N matrix, print the elements in a clockwise spiral manner. Return an array with the elements in the order of their appearance when printed in a spiral manner.

// Examples:
// Input: matrix = [[1, 2, 3], [4 ,5 ,6], [7, 8, 9]]

// Output: [1, 2, 3, 6, 9, 8, 7, 4, 5]

// Explanation: The elements in the spiral order are 1, 2, 3 -> 6, 9 -> 8, 7 -> 4, 5

// Input: matrix = [[1, 2, 3, 4], [5, 6, 7, 8]]

// Output: [1, 2, 3, 4, 8, 7, 6, 5]

// Explanation: The elements in the spiral order are 1, 2, 3, 4 -> 8, 7, 6, 5

import java.util.*;

public class SpiralMatrix {
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return result;
        }

        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        while (top <= bottom && left <= right) {
            // Step 1: Traverse from Left to Right
            for (int j = left; j <= right; j++) {
                result.add(matrix[top][j]);
            }
            top++;

            // Step 2: Traverse from Top to Bottom
            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--;

            // Step 3: Traverse from Right to Left
            if (top <= bottom) {
                for (int j = right; j >= left; j--) {
                    result.add(matrix[bottom][j]);
                }
                bottom--;
            }

            // Step 4: Traverse from Bottom to Top
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
                left++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] matrix1 = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        System.out.println(spiralOrder(matrix1)); // [1, 2, 3, 6, 9, 8, 7, 4, 5]

        int[][] matrix2 = {
            {1, 2, 3, 4},
            {5, 6, 7, 8}
        };
        System.out.println(spiralOrder(matrix2)); // [1, 2, 3, 4, 8, 7, 6, 5]
    }
}

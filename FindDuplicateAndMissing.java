// Given an integer array nums of size n containing values from [1, n] and each value appears exactly once in the array, except for A, which appears twice and B which is missing.

// Return the values A and B, as an array of size 2, where A appears in the 0-th index and B in the 1st index.

// Note: You are not allowed to modify the original array.

// Examples:
// Input: nums = [3, 5, 4, 1, 1]
// Output: [1, 2]

// Explanation: 1 appears two times in the array and 2 is missing from nums

// Input: nums = [1, 2, 3, 6, 7, 5, 7]
// Output: [7, 4]

// Explanation: 7 appears two times in the array and 4 is missing from nums.

import java.util.*;

public class FindDuplicateAndMissing {
    public static int[] findErrorNums(int[] nums) {
        int n = nums.length;

        long expectedSum = (long)n * (n + 1) / 2;
        long expectedSquareSum = (long)n * (n + 1) * (2L * n + 1) / 6;

        long actualSum = 0, actualSquareSum = 0;
        for (int num : nums) {
            actualSum += num;
            actualSquareSum += (long) num * num;
        }

        long diff = actualSum - expectedSum; // A - B
        long squareDiff = actualSquareSum - expectedSquareSum; // A^2 - B^2

        long sumAB = squareDiff / diff; // A + B

        int A = (int) ((diff + sumAB) / 2);  // duplicate
        int B = (int) (A - diff);            // missing

        return new int[]{A, B};
    }

    public static void main(String[] args) {
        int[] nums1 = {3, 5, 4, 1, 1};
        System.out.println("Output 1: " + Arrays.toString(findErrorNums(nums1)));
        // [1, 2]

        int[] nums2 = {1, 2, 3, 6, 7, 5, 7};
        System.out.println("Output 2: " + Arrays.toString(findErrorNums(nums2)));
        // [7, 4]
    }
}

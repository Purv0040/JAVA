// Given two integer arrays nums1 and nums2. Both arrays are sorted in non-decreasing order.

// Merge both the arrays into a single array sorted in non-decreasing order.

// The final sorted array should be stored inside the array nums1 and it should be done in-place.
// nums1 has a length of m + n, where the first m elements denote the elements of nums1 and rest are 0s.
// nums2 has a length of n.

// Examples:
// Input: nums1 = [-5, -2, 4, 5], nums2 = [-3, 1, 8]
// Output: [-5, -3, -2, 1, 4, 5, 8]

// Explanation: The merged array is: [-5, -3, -2, 1, 4, 5, 8], where [-5, -2, 4, 5] are from nums1 and [-3, 1, 8] are from nums2

// Input: nums1 = [0, 2, 7, 8], nums2 = [-7, -3, -1]
// Output: [-7, -3, -1, 0, 2, 7, 8]

// Explanation: The merged array is: [-7, -3, -1, 0, 2, 7, 8], where [0, 2, 7, 8] are from nums1 and [-7, -3, -1] are from nums2

import java.util.*;

public class MergeSortedArrays {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;  // last index of nums1's actual elements
        int j = n - 1;  // last index of nums2
        int k = m + n - 1; // last index of nums1 (full length)

        // Fill nums1 from the back
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }

        // Copy remaining elements of nums2 if any
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }

    public static void main(String[] args) {
        // Example 1
        int[] nums1a = {-5, -2, 4, 5, 0, 0, 0}; // size = 4 + 3
        int[] nums2a = {-3, 1, 8};
        merge(nums1a, 4, nums2a, 3);
        System.out.println("Output 1: " + Arrays.toString(nums1a));
        // [-5, -3, -2, 1, 4, 5, 8]

        // Example 2
        int[] nums1b = {0, 2, 7, 8, 0, 0, 0};
        int[] nums2b = {-7, -3, -1};
        merge(nums1b, 4, nums2b, 3);
        System.out.println("Output 2: " + Arrays.toString(nums1b));
        // [-7, -3, -1, 0, 2, 7, 8]
    }
}

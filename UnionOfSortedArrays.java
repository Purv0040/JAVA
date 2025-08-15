// Given two sorted arrays nums1 and nums2, return an array that contains the union of these two arrays. The elements in the union must be in ascending order.
// The union of two arrays is an array where all values are distinct and are present in either the first array, the second array, or both.

// Examples:
// Input: nums1 = [1, 2, 3, 4, 5], nums2 = [1, 2, 7]
// Output: [1, 2, 3, 4, 5, 7]

// Explanation: The elements 1, 2 are common to both, 3, 4, 5 are from nums1 and 7 is from nums2

// Input: nums1 = [3, 4, 6, 7, 9, 9], nums2 = [1, 5, 7, 8, 8]
// Output: [1, 3, 4, 5, 6, 7, 8, 9]

// Explanation: The element 7 is common to both, 3, 4, 6, 9 are from nums1 and 1, 5, 8 is from nums2

import java.util.*;

public class UnionOfSortedArrays {

    public static int[] unionSorted(int[] nums1, int[] nums2) {
        List<Integer> result = new ArrayList<>();
        int i = 0, j = 0;

        // Merge both arrays while removing duplicates
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                if (result.isEmpty() || result.get(result.size() - 1) != nums1[i]) {
                    result.add(nums1[i]);
                }
                i++;
            } else if (nums1[i] > nums2[j]) {
                if (result.isEmpty() || result.get(result.size() - 1) != nums2[j]) {
                    result.add(nums2[j]);
                }
                j++;
            } else { // nums1[i] == nums2[j]
                if (result.isEmpty() || result.get(result.size() - 1) != nums1[i]) {
                    result.add(nums1[i]);
                }
                i++;
                j++;
            }
        }

        // Add remaining elements from nums1
        while (i < nums1.length) {
            if (result.isEmpty() || result.get(result.size() - 1) != nums1[i]) {
                result.add(nums1[i]);
            }
            i++;
        }

        // Add remaining elements from nums2
        while (j < nums2.length) {
            if (result.isEmpty() || result.get(result.size() - 1) != nums2[j]) {
                result.add(nums2[j]);
            }
            j++;
        }

        // Convert List to int[]
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4, 5};
        int[] nums2 = {1, 2, 7};
        System.out.println(Arrays.toString(unionSorted(nums1, nums2))); // [1, 2, 3, 4, 5, 7]

        int[] nums3 = {3, 4, 6, 7, 9, 9};
        int[] nums4 = {1, 5, 7, 8, 8};
        System.out.println(Arrays.toString(unionSorted(nums3, nums4))); // [1, 3, 4, 5, 6, 7, 8, 9]
    }
}

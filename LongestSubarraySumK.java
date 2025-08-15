// Given an array nums of size n and an integer k, find the length of the longest sub-array that sums to k. If no such sub-array exists, return 0.

// Examples:
// Input: nums = [10, 5, 2, 7, 1, 9],  k=15
// Output: 4

// Explanation:
// The longest sub-array with a sum equal to 15 is [5, 2, 7, 1], which has a length of 4. This sub-array starts at index 1 and ends at index 4, and the sum of its elements (5 + 2 + 7 + 1) equals 15. Therefore, the length of this sub-array is 4.

// Input: nums = [-3, 2, 1], k=6
// Output: 0

// Explanation:
// There is no sub-array in the array that sums to 6. Therefore, the output is 0.

import java.util.HashMap;

public class LongestSubarraySumK {

    public static int longestSubarrayWithSumK(int[] nums, int k) {
        HashMap<Integer, Integer> prefixSumIndex = new HashMap<>();
        int sum = 0, maxLength = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            // Case 1: Subarray starts from index 0
            if (sum == k) {
                maxLength = i + 1;
            }

            // Case 2: Subarray found in the middle
            if (prefixSumIndex.containsKey(sum - k)) {
                maxLength = Math.max(maxLength, i - prefixSumIndex.get(sum - k));
            }

            // Store first occurrence of this sum
            if (!prefixSumIndex.containsKey(sum)) {
                prefixSumIndex.put(sum, i);
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        int[] nums1 = {10, 5, 2, 7, 1, 9};
        int[] nums2 = {-3, 2, 1};

        System.out.println(longestSubarrayWithSumK(nums1, 15)); // Output: 4
        System.out.println(longestSubarrayWithSumK(nums2, 6));  // Output: 0
    }
}

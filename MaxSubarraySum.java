// Given an integer array nums, find the subarray with the largest sum and return the sum of the elements present in that subarray.

// A subarray is a contiguous non-empty sequence of elements within an array.


// Examples:
// Input: nums = [2, 3, 5, -2, 7, -4]
// Output: 15

// Explanation: The subarray from index 0 to index 4 has the largest sum = 15

// Input: nums = [-2, -3, -7, -2, -10, -4]
// Output: -2

// Explanation: The element on index 0 or index 3 make up the largest sum when taken as a subarray

public class MaxSubarraySum {
    public static int maxSubArray(int[] nums) {
        int maxSoFar = nums[0]; // Best sum found so far
        int currentSum = nums[0]; // Current subarray sum

        for (int i = 1; i < nums.length; i++) {
            // Decide: start new subarray or extend current one
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSoFar = Math.max(maxSoFar, currentSum);
        }

        return maxSoFar;
    }

    public static void main(String[] args) {
        int[] nums1 = {2, 3, 5, -2, 7, -4};
        System.out.println(maxSubArray(nums1)); // Output: 15

        int[] nums2 = {-2, -3, -7, -2, -10, -4};
        System.out.println(maxSubArray(nums2)); // Output: -2
    }
}

// Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.

// Examples:
// Input: nums = [1, 1, 1], k = 2
// Output: 2

// Explanation: In the given array [1, 1, 1], there are two subarrays that sum up to 2: [1, 1] and [1, 1]. Hence, the output is 2.

// Input: nums = [1, 2, 3], k = 3
// Output: 2

// Explanation: In the given array [1, 2, 3], there are two subarrays that sum up to 3: [1, 2] and [3]. Hence, the output is 2.

import java.util.*;

public class SubarraySumEqualsK {
    public static int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefixSumCount = new HashMap<>();
        prefixSumCount.put(0, 1); // Prefix sum 0 occurs once

        int count = 0;
        int prefixSum = 0;

        for (int num : nums) {
            prefixSum += num;

            // If there exists a prefixSum - k in the map, we found a subarray
            if (prefixSumCount.containsKey(prefixSum - k)) {
                count += prefixSumCount.get(prefixSum - k);
            }

            // Update prefix sum frequency
            prefixSumCount.put(prefixSum, prefixSumCount.getOrDefault(prefixSum, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 1, 1};
        int k1 = 2;
        System.out.println(subarraySum(nums1, k1)); // Output: 2

        int[] nums2 = {1, 2, 3};
        int k2 = 3;
        System.out.println(subarraySum(nums2, k2)); // Output: 2
    }
}

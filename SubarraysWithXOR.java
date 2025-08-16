// Given an array of integers nums and an integer k, return the total number of subarrays whose XOR equals to k.

// Examples:
// Input : nums = [4, 2, 2, 6, 4], k = 6
// Output : 4

// Explanation : The subarrays having XOR of their elements as 6 are [4, 2],  [4, 2, 2, 6, 4], [2, 2, 6], and [6]

// Input :nums = [5, 6, 7, 8, 9], k = 5
// Output : 2

// Explanation : The subarrays having XOR of their elements as 5 are [5] and [5, 6, 7, 8, 9]

import java.util.*;

public class SubarraysWithXOR {
    public static int countSubarraysWithXOR(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        int count = 0;
        int prefixXor = 0;

        for (int num : nums) {
            prefixXor ^= num; // Update prefix XOR

            // Case 1: If prefixXor itself equals k
            if (prefixXor == k) {
                count++;
            }

            // Case 2: Check if there exists a previous prefixXor such that
            // (prefixXor ^ prevXor) == k  => prevXor = prefixXor ^ k
            int required = prefixXor ^ k;
            if (freq.containsKey(required)) {
                count += freq.get(required);
            }

            // Store current prefixXor in map
            freq.put(prefixXor, freq.getOrDefault(prefixXor, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums1 = {4, 2, 2, 6, 4};
        int k1 = 6;
        System.out.println("Output 1: " + countSubarraysWithXOR(nums1, k1)); // Expected 4

        int[] nums2 = {5, 6, 7, 8, 9};
        int k2 = 5;
        System.out.println("Output 2: " + countSubarraysWithXOR(nums2, k2)); // Expected 2
    }
}

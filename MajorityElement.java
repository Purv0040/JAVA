// Given an integer array nums of size n, return the majority element of the array.

// The majority element of an array is an element that appears more than n/2 times in the array. The array is guaranteed to have a majority element.

// Examples:
// Input: nums = [7, 0, 0, 1, 7, 7, 2, 7, 7]
// Output: 7

// Explanation: The number 7 appears 5 times in the 9 sized array

// Input: nums = [1, 1, 1, 2, 1, 2]
// Output: 1

// Explanation: The number 1 appears 4 times in the 6 sized array

import java.util.*;

public class MajorityElement {
    public static int majorityElement(int[] nums) {
        int candidate = nums[0];
        int count = 1;

        // Step 1: Find the candidate
        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                candidate = nums[i];
                count = 1;
            } else if (nums[i] == candidate) {
                count++;
            } else {
                count--;
            }
        }

        // Step 2: (Optional here, as majority element is guaranteed)
        return candidate;
    }

    public static void main(String[] args) {
        int[] nums1 = {7, 0, 0, 1, 7, 7, 2, 7, 7};
        System.out.println(majorityElement(nums1)); // 7

        int[] nums2 = {1, 1, 1, 2, 1, 2};
        System.out.println(majorityElement(nums2)); // 1
    }
}

// Given an array nums of n integers.

// Return the length of the longest sequence of consecutive integers. The integers in this sequence can appear in any order.

// Examples:
// Input: nums = [100, 4, 200, 1, 3, 2]
// Output: 4

// Explanation:

// The longest sequence of consecutive elements in the array is [1, 2, 3, 4], which has a length of 4. This sequence can be formed regardless of the initial order of the elements in the array.

// Input: nums = [0, 3, 7, 2, 5, 8, 4, 6, 0, 1]
// Output: 9

// Explanation:

// The longest sequence of consecutive elements in the array is [0, 1, 2, 3, 4, 5, 6, 7, 8], which has a length of 9. 

import java.util.HashSet;

public class LongestConsecutiveSequence {
    public static int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0; // No elements → length 0
        }

        HashSet<Integer> set = new HashSet<>();
        // Add all numbers to set for O(1) lookups
        for (int num : nums) {
            set.add(num);
        }

        int longest = 0;

        // Iterate through each number
        for (int num : set) {
            // Only start counting if it's the beginning of a sequence
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                // Count consecutive numbers
                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    currentStreak++;
                }

                longest = Math.max(longest, currentStreak);
            }
        }
        return longest;
    }

    public static void main(String[] args) {
        int[] nums1 = {100, 4, 200, 1, 3, 2};
        System.out.println(longestConsecutive(nums1)); // Output: 4

        int[] nums2 = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        System.out.println(longestConsecutive(nums2)); // Output: 9
    }
}

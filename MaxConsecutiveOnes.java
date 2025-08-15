// Given a binary array nums, return the maximum number of consecutive 1s in the array.

// A binary array is an array that contains only 0s and 1s.


// Examples:
// Input: nums = [1, 1, 0, 0, 1, 1, 1, 0]
// Output: 3

// Explanation: The maximum consecutive 1s are present from index 4 to index 6, amounting to 3 1s

// Input: nums = [0, 0, 0, 0, 0, 0, 0, 0]
// Output: 0

// Explanation: No 1s are present in nums, thus we return 0

public class MaxConsecutiveOnes {

    public static int findMaxConsecutiveOnes(int[] nums) {
        int maxCount = 0; // Stores the maximum streak
        int currentCount = 0; // Stores the current streak of 1s

        for (int num : nums) {
            if (num == 1) {
                currentCount++;
                maxCount = Math.max(maxCount, currentCount);
            } else {
                currentCount = 0; // Reset streak when we find a 0
            }
        }
        return maxCount;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 1, 0, 0, 1, 1, 1, 0};
        int[] nums2 = {0, 0, 0, 0, 0, 0, 0, 0};

        System.out.println(findMaxConsecutiveOnes(nums1)); // Output: 3
        System.out.println(findMaxConsecutiveOnes(nums2)); // Output: 0
    }
}

// Given an array nums consisting of only 0, 1, or 2. Sort the array in non-decreasing order. The sorting must be done in-place, without making a copy of the original array.


// Examples:
// Input: nums = [1, 0, 2, 1, 0]
// Output: [0, 0, 1, 1, 2]

// Explanation: The nums array in sorted order has 2 zeroes, 2 ones and 1 two

// Input: nums = [0, 0, 1, 1, 1]
// Output: [0, 0, 1, 1, 1]

// Explanation: The nums array in sorted order has 2 zeroes, 3 ones and zero twos

import java.util.*;

public class SortColors {
    public static void sortColors(int[] nums) {
        int low = 0, mid = 0, high = nums.length - 1;

        while (mid <= high) {
            if (nums[mid] == 0) {
                // Swap nums[low] and nums[mid]
                int temp = nums[low];
                nums[low] = nums[mid];
                nums[mid] = temp;
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else { // nums[mid] == 2
                // Swap nums[mid] and nums[high]
                int temp = nums[mid];
                nums[mid] = nums[high];
                nums[high] = temp;
                high--;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 0, 2, 1, 0};
        sortColors(nums1);
        System.out.println(Arrays.toString(nums1)); // [0, 0, 1, 1, 2]

        int[] nums2 = {0, 0, 1, 1, 1};
        sortColors(nums2);
        System.out.println(Arrays.toString(nums2)); // [0, 0, 1, 1, 1]
    }
}

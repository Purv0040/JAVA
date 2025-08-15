// A permutation of an array of integers is an arrangement of its members into a sequence or linear order.

// For example, for arr = [1,2,3], the following are all the permutations of arr:
// [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], [3,2,1].


// The next permutation of an array of integers is the next lexicographically greater permutation of its integers.
// More formally, if all the permutations of the array are sorted in lexicographical order, then the next permutation of that array is the permutation that follows it in the sorted order.
// If such arrangement is not possible (i.e., the array is the last permutation), then rearrange it to the lowest possible order (i.e., sorted in ascending order).
// You must rearrange the numbers in-place and use only constant extra memory.


// Examples:
// Input: nums = [1,2,3]
// Output: [1,3,2]

// Explanation: The next permutation of [1,2,3] is [1,3,2].

// Input: nums = [3,2,1]
// Output: [1,2,3]

// Explanation: [3,2,1] is the last permutation. So we return the first: [1,2,3].

import java.util.*;

public class NextPermutation {
    public static void nextPermutation(int[] nums) {
        int n = nums.length;
        int i = n - 2;

        // Step 1: Find first decreasing element from the end
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        if (i >= 0) {
            // Step 2: Find the next larger element to swap with nums[i]
            int j = n - 1;
            while (nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }

        // Step 3: Reverse the suffix starting from i+1
        reverse(nums, i + 1, n - 1);
    }

    // Helper method to swap two elements
    private static void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    // Helper method to reverse array segment
    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start++, end--);
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3};
        nextPermutation(nums1);
        System.out.println(Arrays.toString(nums1)); // [1, 3, 2]

        int[] nums2 = {3, 2, 1};
        nextPermutation(nums2);
        System.out.println(Arrays.toString(nums2)); // [1, 2, 3]

        int[] nums3 = {1, 1, 5};
        nextPermutation(nums3);
        System.out.println(Arrays.toString(nums3)); // [1, 5, 1]
    }
}

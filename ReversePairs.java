// Given an integer array nums. Return the number of reverse pairs in the array.

// An index pair (i, j) is called a reverse pair if:

// 0 <= i < j < nums.length

// nums[i] > 2 * nums[j]

// Examples:
// Input: nums = [6, 4, 1, 2, 7]
// Output: 3

// Explanation: The reverse pairs are:

// (0, 2) : nums[0] = 6, nums[2] = 1, 6 > 2 * 1
// (0, 3) : nums[0] = 6, nums[3] = 2, 6 > 2 * 2
// (1, 2) : nums[1] = 4, nums[2] = 1, 4 > 2 * 1

// Input: nums = [5, 4, 4, 3, 3]
// Output: 0

// Explanation: No pairs satisfy both the conditons.

import java.util.*;

public class ReversePairs {
    public static int countReversePairs(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        return mergeSort(nums, 0, nums.length - 1);
    }

    private static int mergeSort(int[] nums, int left, int right) {
        if (left >= right) return 0;

        int mid = left + (right - left) / 2;
        int count = 0;

        count += mergeSort(nums, left, mid);
        count += mergeSort(nums, mid + 1, right);
        count += countCrossPairs(nums, left, mid, right);

        merge(nums, left, mid, right);
        return count;
    }

    // Count reverse pairs across left & right halves
    private static int countCrossPairs(int[] nums, int left, int mid, int right) {
        int count = 0;
        int j = mid + 1;

        for (int i = left; i <= mid; i++) {
            while (j <= right && (long) nums[i] > 2L * nums[j]) {
                j++;
            }
            count += (j - (mid + 1));
        }
        return count;
    }

    // Normal merge step
    private static void merge(int[] nums, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;

        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }
        while (i <= mid) temp[k++] = nums[i++];
        while (j <= right) temp[k++] = nums[j++];

        System.arraycopy(temp, 0, nums, left, temp.length);
    }

    public static void main(String[] args) {
        int[] nums1 = {6, 4, 1, 2, 7};
        System.out.println("Output 1: " + countReversePairs(nums1));
        // Expected 3

        int[] nums2 = {5, 4, 4, 3, 3};
        System.out.println("Output 2: " + countReversePairs(nums2));
        // Expected 0
    }
}

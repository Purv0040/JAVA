// Given an integer array nums of even length consisting of an equal number of positive and negative integers.Return the answer array in such a way that the given conditions are met:

// Every consecutive pair of integers have opposite signs.
// For all integers with the same sign, the order in which they were present in nums is preserved.
// The rearranged array begins with a positive integer.

// Examples:
// Input : nums = [2, 4, 5, -1, -3, -4]
// Output : [2, -1, 4, -3, 5, -4]

// Explanation: The positive number 2, 4, 5 maintain their relative positions and -1, -3, -4 maintain their relative positions

// Input : nums = [1, -1, -3, -4, 2, 3]
// Output : [1, -1, 2, -3, 3, -4]

// Explanation: The positive number 1, 2, 3 maintain their relative positions and -1, -3, -4 maintain their relative positions

import java.util.*;

public class RearrangeArray {
    public static int[] rearrangeArray(int[] nums) {
        List<Integer> pos = new ArrayList<>();
        List<Integer> neg = new ArrayList<>();

        // Separate positive and negative numbers
        for (int num : nums) {
            if (num > 0) {
                pos.add(num);
            } else {
                neg.add(num);
            }
        }

        int[] result = new int[nums.length];
        int i = 0, p = 0, n = 0;

        // Merge positives and negatives alternately, starting with positive
        while (p < pos.size() && n < neg.size()) {
            result[i++] = pos.get(p++);
            result[i++] = neg.get(n++);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = {2, 4, 5, -1, -3, -4};
        System.out.println(Arrays.toString(rearrangeArray(nums1))); // [2, -1, 4, -3, 5, -4]

        int[] nums2 = {1, -1, -3, -4, 2, 3};
        System.out.println(Arrays.toString(rearrangeArray(nums2))); // [1, -1, 2, -3, 3, -4]
    }
}

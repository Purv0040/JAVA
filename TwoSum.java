// Given an array of integers nums and an integer target. Return the indices(0 - indexed) of two elements in nums such that they add up to target.
// Each input will have exactly one solution, and the same element cannot be used twice. Return the answer in increasing order.


// Examples:
// Input: nums = [1, 6, 2, 10, 3], target = 7
// Output: [0, 1]

// Explanation: nums[0] + nums[1] = 1 + 6 = 7

// Input: nums = [1, 3, 5, -7, 6, -3], target = 0
// Output: [1, 5]

// Explanation: nums[1] + nums[5] = 3 + (-3) = 0

import java.util.*;

public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(); // number → index mapping

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                int idx1 = map.get(complement);
                int idx2 = i;
                // Return indices in increasing order
                return (idx1 < idx2) ? new int[]{idx1, idx2} : new int[]{idx2, idx1};
            }
            map.put(nums[i], i);
        }
        return new int[]{}; // This won't happen as per problem statement
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 6, 2, 10, 3};
        int target1 = 7;
        System.out.println(Arrays.toString(twoSum(nums1, target1))); // [0, 1]

        int[] nums2 = {1, 3, 5, -7, 6, -3};
        int target2 = 0;
        System.out.println(Arrays.toString(twoSum(nums2, target2))); // [1, 5]
    }
}

// Given an integer array nums of size n. Return all elements which appear more than n/3 times in the array. The output can be returned in any order.

// Examples:
// Input: nums = [1, 2, 1, 1, 3, 2]
// Output: [1]

// Explanation: Here, n / 3 = 6 / 3 = 2.

// Therefore the elements appearing 3 or more times is : [1]

// Input: nums = [1, 2, 1, 1, 3, 2, 2]
// Output: [1, 2]

// Explanation: Here, n / 3 = 7 / 3 = 2.

// Therefore the elements appearing 3 or more times is : [1, 2]

import java.util.*;

public class MajorityElementNby3 {
    public static List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int n = nums.length;
        int threshold = n / 3;

        // Count frequency of each element
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // Add elements that appear more than n/3 times
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            if (entry.getValue() > threshold) {
                result.add(entry.getKey());
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 1, 1, 3, 2};
        System.out.println(majorityElement(nums1)); // Output: [1]

        int[] nums2 = {1, 2, 1, 1, 3, 2, 2};
        System.out.println(majorityElement(nums2)); // Output: [1, 2]
    }
}

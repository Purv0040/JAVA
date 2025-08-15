// Given an integer array nums, return a list of all the leaders in the array.

// A leader in an array is an element whose value is strictly greater than all elements to its right in the given array. The rightmost element is always a leader. The elements in the leader array must appear in the order they appear in the nums array.

// Examples:
// Input: nums = [1, 2, 5, 3, 1, 2]
// Output: [5, 3, 2]

// Explanation: 2 is the rightmost element, 3 is the largest element in the index range [3, 5], 5 is the largest element in the index range [2, 5]

// Input: nums = [-3, 4, 5, 1, -4, -5]
// Output: [5, 1, -4, -5]

// Explanation: -5 is the rightmost element, -4 is the largest element in the index range [4, 5], 1 is the largest element in the index range [3, 5] and 5 is the largest element in the range [2, 5]


import java.util.*;

public class LeadersInArray {
    public static List<Integer> findLeaders(int[] nums) {
        List<Integer> leaders = new ArrayList<>();
        int n = nums.length;

        int maxFromRight = nums[n - 1]; // Rightmost element is always a leader
        leaders.add(maxFromRight);

        // Traverse from second last to first
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] > maxFromRight) {
                leaders.add(nums[i]);
                maxFromRight = nums[i];
            }
        }

        // Reverse to maintain original order
        Collections.reverse(leaders);

        return leaders;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 5, 3, 1, 2};
        System.out.println(findLeaders(nums1)); // [5, 3, 2]

        int[] nums2 = {-3, 4, 5, 1, -4, -5};
        System.out.println(findLeaders(nums2)); // [5, 1, -4, -5]
    }
}

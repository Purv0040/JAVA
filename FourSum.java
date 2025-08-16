// Given an integer array nums and an integer target. Return all quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:

// ·      a, b, c, d are all distinct valid indices of nums.
// ·      nums[a] + nums[b] + nums[c] + nums[d] == target.

// Notice that the solution set must not contain duplicate quadruplets. One element can be a part of multiple quadruplets. The output and the quadruplets can be returned in any order.

// Examples:
// Input: nums = [1, -2, 3, 5, 7, 9], target = 7
// Output: [[-2, 1, 3, 5]]

// Explanation: nums[1] + nums[0] + nums[2] + nums[3] = 7

// Input: nums = [7, -7, 1, 2, 14, 3], target = 9
// Output: []

// Explanation: No quadruplets are present which add upto 9

import java.util.*;

public class FourSum {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); // Sort to handle duplicates
        
        int n = nums.length;
        
        for (int i = 0; i < n - 3; i++) {
            // Skip duplicates for i
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            
            for (int j = i + 1; j < n - 2; j++) {
                // Skip duplicates for j
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                
                int left = j + 1;
                int right = n - 1;
                
                while (left < right) {
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right]; // long to prevent overflow
                    
                    if (sum == target) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        
                        // Skip duplicates for left
                        while (left < right && nums[left] == nums[left + 1]) left++;
                        // Skip duplicates for right
                        while (left < right && nums[right] == nums[right - 1]) right--;
                        
                        left++;
                        right--;
                    } 
                    else if (sum < target) {
                        left++;
                    } 
                    else {
                        right--;
                    }
                }
            }
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        int[] nums1 = {1, -2, 3, 5, 7, 9};
        int target1 = 7;
        System.out.println(fourSum(nums1, target1)); 
        // Output: [[-2, 1, 3, 5]]

        int[] nums2 = {7, -7, 1, 2, 14, 3};
        int target2 = 9;
        System.out.println(fourSum(nums2, target2)); 
        // Output: []
    }
}

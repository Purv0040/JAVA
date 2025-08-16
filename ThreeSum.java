// Given an integer array nums. Return all triplets such that:

// i != j, i != k, and j != k
// nums[i] + nums[j] + nums[k] == 0.

// Notice that the solution set must not contain duplicate triplets. One element can be a part of multiple triplets. The output and the triplets can be returned in any order.

// Examples:
// Input: nums = [2, -2, 0, 3, -3, 5]
// Output: [[-2, 0, 2], [-3, -2, 5], [-3, 0, 3]]

// Explanation: nums[1] + nums[2] + nums[0] = 0

// nums[4] + nums[1] + nums[5] = 0

// nums[4] + nums[2] + nums[3] = 0

// Input: nums = [2, -1, -1, 3, -1]
// Output: [[-1, -1, 2]]

// Explanation: nums[1] + nums[2] + nums[0] = 0

// Note that we have used two -1s as they are separate elements with different indexes
// But we have not used the -1 at index 4 as that would create a duplicate triplet

import java.util.*;

public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); // Step 1: Sort to make duplicate handling easier
        
        int n = nums.length;
        for (int i = 0; i < n - 2; i++) {
            // Avoid duplicates for i
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            
            int left = i + 1;
            int right = n - 1;
            
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    
                    // Skip duplicates for left pointer
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    // Skip duplicates for right pointer
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    
                    left++;
                    right--;
                } 
                else if (sum < 0) {
                    left++;
                } 
                else {
                    right--;
                }
            }
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        int[] nums1 = {2, -2, 0, 3, -3, 5};
        System.out.println(threeSum(nums1)); 
        // Output: [[-3, -2, 5], [-3, 0, 3], [-2, 0, 2]]

        int[] nums2 = {2, -1, -1, 3, -1};
        System.out.println(threeSum(nums2)); 
        // Output: [[-1, -1, 2]]
    }
}

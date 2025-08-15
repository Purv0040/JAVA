// Given an array of integers nums and an integer target, find the smallest index (0 based indexing) where the target appears in the array. If the target is not found in the array, return -1

// Examples:
// Input: nums = [2, 3, 4, 5, 3], target = 3
// Output: 1

// Explanation: The first occurence of 3 in nums is at index 1

// Input: nums = [2, -4, 4, 0, 10], target = 6
// Output: -1

// Explanation: The value 6 does not occur in the array, hence output is -1

public class FirstOccurrence {

    public static int firstIndex(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i; // Found the target, return index
            }
        }
        return -1; // Target not found
    }

    public static void main(String[] args) {
        int[] nums1 = {2, 3, 4, 5, 3};
        int[] nums2 = {2, -4, 4, 0, 10};

        System.out.println(firstIndex(nums1, 3));  // Output: 1
        System.out.println(firstIndex(nums2, 6));  // Output: -1
    }
}

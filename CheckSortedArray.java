// Given an array nums of n integers, return true if the array nums is sorted in non-decreasing order or else false.

// Examples:
// Input : nums = [1, 2, 3, 4, 5]

// Output : true

// Explanation : For all i (1 <= i <= 4) it holds nums[i] <= nums[i+1], hence it is sorted and we return true.

// Input : nums = [1, 2, 1, 4, 5]

// Output : false

// Explanation : For i == 2 it does not hold nums[i] <= nums[i+1], hence it is not sorted and we return false.

public class CheckSortedArray {

    public static boolean isSorted(int[] nums) {
        // Loop through the array and check if the current element > next element
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                return false; // Found a decreasing pair
            }
        }
        return true; // No decreasing pair found, so it's sorted
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4, 5};
        int[] nums2 = {1, 2, 1, 4, 5};

        System.out.println(isSorted(nums1)); // true
        System.out.println(isSorted(nums2)); // false
    }
}

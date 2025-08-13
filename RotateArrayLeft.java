// Given an integer array nums, rotate the array to the left by one.

// Note: There is no need to return anything, just modify the given array.

// Examples:
// Input: nums = [1, 2, 3, 4, 5]

// Output: [2, 3, 4, 5, 1]

// Explanation: Initially, nums = [1, 2, 3, 4, 5]

// Rotating once to left -> nums = [2, 3, 4, 5, 1]

// Input: nums = [-1, 0, 3, 6]

// Output: [0, 3, 6, -1]

// Explanation: Initially, nums = [-1, 0, 3, 6]

// Rotating once to left -> nums = [0, 3, 6, -1]

public class RotateArrayLeft {

    public static void rotateLeftByOne(int[] nums) {
        if (nums.length <= 1) {
            return; // No rotation needed
        }

        int first = nums[0]; // Store the first element

        // Shift all elements one position to the left
        for (int i = 0; i < nums.length - 1; i++) {
            nums[i] = nums[i + 1];
        }

        // Place the first element at the end
        nums[nums.length - 1] = first;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4, 5};
        int[] nums2 = {-1, 0, 3, 6};

        rotateLeftByOne(nums1);
        rotateLeftByOne(nums2);

        System.out.print("Rotated nums1: ");
        for (int num : nums1) {
            System.out.print(num + " ");
        }
        System.out.println();

        System.out.print("Rotated nums2: ");
        for (int num : nums2) {
            System.out.print(num + " ");
        }
    }
}

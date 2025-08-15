// Given an integer array nums and a non-negative integer k, rotate the array to the left by k steps.

// Examples:
// Input: nums = [1, 2, 3, 4, 5, 6], k = 2
// Output: nums = [3, 4, 5, 6, 1, 2]

// Explanation: rotate 1 step to the left: [2, 3, 4, 5, 6, 1]
// rotate 2 steps to the left: [3, 4, 5, 6, 1, 2]

// Input: nums = [3, 4, 1, 5, 3, -5], k = 8
// Output: nums = [1, 5, 3, -5, 3, 4]

// Explanation: rotate 1 step to the left: [4, 1, 5, 3, -5, 3]
// rotate 2 steps to the left: [1, 5, 3, -5, 3, 4]
// rotate 3 steps to the left: [5, 3, -5, 3, 4, 1]
// rotate 4 steps to the left: [3, -5, 3, 4, 1, 5]
// rotate 5 steps to the left: [-5, 3, 4, 1, 5, 3]
// rotate 6 steps to the left: [3, 4, 1, 5, 3, -5]
// rotate 7 steps to the left: [4, 1, 5, 3, -5, 3]
// rotate 8 steps to the left: [1, 5, 3, -5, 3, 4]

public class RotateArrayKStepsLeft {

    public static void rotateLeft(int[] nums, int k) {
        int n = nums.length;
        if (n == 0) return; // No rotation for empty array
        k = k % n; // To handle k greater than n

        if (k == 0) return; // No rotation needed

        // Reverse first k elements
        reverse(nums, 0, k - 1);
        // Reverse remaining n-k elements
        reverse(nums, k, n - 1);
        // Reverse entire array
        reverse(nums, 0, n - 1);
    }

    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4, 5, 6};
        int[] nums2 = {3, 4, 1, 5, 3, -5};

        rotateLeft(nums1, 2);
        rotateLeft(nums2, 8);

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

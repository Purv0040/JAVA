// Given an array of nums of n integers. Every integer in the array appears twice except one integer. Find the number that appeared once in the array.

// Examples:
// Input : nums = [1, 2, 2, 4, 3, 1, 4]
// Output : 3

// Explanation : The integer 3 has appeared only once.

// Input : nums = [5]
// Output : 5

// Explanation : The integer 5 has appeared only once.

public class SingleNumber {

    public static int findSingleNumber(int[] nums) {
        int result = 0;
        // XOR of a number with itself is 0, and XOR with 0 is the number itself
        for (int num : nums) {
            result ^= num; // Cancels out duplicates, leaves the single number
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 4, 3, 1, 4};
        int[] nums2 = {5};

        System.out.println(findSingleNumber(nums1)); // Output: 3
        System.out.println(findSingleNumber(nums2)); // Output: 5
    }
}

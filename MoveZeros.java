// Given an integer array nums, move all the 0's to the end of the array. The relative order of the other elements must remain the same. This must be done in place, without making a copy of the array.

// Examples:
// Input: nums = [0, 1, 4, 0, 5, 2]
// Output: [1, 4, 5, 2, 0, 0]

// Explanation: Both the zeroes are moved to the end and the order of the other elements stay the same

// Input: nums = [0, 0, 0, 1, 3, -2]
// Output: [1, 3, -2, 0, 0, 0]

// Explanation: All 3 zeroes are moved to the end and the order of the other elements stay the same

public class MoveZeros {

    public static void moveZeroes(int[] nums) {
        int insertPos = 0; // Position to insert the next non-zero element

        // Move non-zero elements forward
        for (int num : nums) {
            if (num != 0) {
                nums[insertPos] = num;
                insertPos++;
            }
        }

        // Fill the rest of the array with zeroes
        while (insertPos < nums.length) {
            nums[insertPos] = 0;
            insertPos++;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {0, 1, 4, 0, 5, 2};
        int[] nums2 = {0, 0, 0, 1, 3, -2};

        moveZeroes(nums1);
        moveZeroes(nums2);

        System.out.print("nums1 after moving zeros: ");
        for (int num : nums1) {
            System.out.print(num + " ");
        }
        System.out.println();

        System.out.print("nums2 after moving zeros: ");
        for (int num : nums2) {
            System.out.print(num + " ");
        }
    }
}

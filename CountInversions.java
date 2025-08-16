// Given an integer array nums. Return the number of inversions in the array.

// Two elements a[i] and a[j] form an inversion if a[i] > a[j] and i < j.

// It indicates how close an array is to being sorted.
// A sorted array has an inversion count of 0.
// An array sorted in descending order has maximum inversion.

// Examples:
// Input: nums = [2, 3, 7, 1, 3, 5]

// Output: 5

// Explanation: The responsible indexes are:

// nums[0], nums[3], values: 2 > 1 & indexes: 0 < 3
// nums[1], nums[3], values: 3 > 1 & indexes: 1 < 3
// nums[2], nums[3], values: 7 > 1 & indexes: 2 < 3
// nums[2], nums[4], values: 7 > 3 & indexes: 2 < 4
// nums[2], nums[5], values: 7 > 5 & indexes: 2 < 5

// Input: nums = [-10, -5, 6, 11, 15, 17]
// Output: 0

// Explanation: nums is sorted, hence no inversions present.

public class CountInversions {
    public static int countInversions(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    private static int mergeSort(int[] nums, int left, int right) {
        if (left >= right) return 0;

        int mid = left + (right - left) / 2;
        int count = 0;

        count += mergeSort(nums, left, mid);
        count += mergeSort(nums, mid + 1, right);
        count += merge(nums, left, mid, right);

        return count;
    }

    private static int merge(int[] nums, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;
        int count = 0;

        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
                // All remaining elements in left half are greater → inversions
                count += (mid - i + 1);
            }
        }

        while (i <= mid) temp[k++] = nums[i++];
        while (j <= right) temp[k++] = nums[j++];

        System.arraycopy(temp, 0, nums, left, temp.length);

        return count;
    }

    public static void main(String[] args) {
        int[] nums1 = {2, 3, 7, 1, 3, 5};
        System.out.println("Output 1: " + countInversions(nums1)); 
        // Expected 5

        int[] nums2 = {-10, -5, 6, 11, 15, 17};
        System.out.println("Output 2: " + countInversions(nums2));
        // Expected 0
    }
}

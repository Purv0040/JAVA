// Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals and return an array of the non-overlapping intervals that cover all the intervals in the input.

// You can return the intervals in any order.

// Examples:
// Input: intervals = [[1,5],[3,6],[8,10],[15,18]]
// Output: [[1,6],[8,10],[15,18]]

// Explanation: Intervals [1,5] and [3,6] overlap, so they are merged into [1,6].

// Input: intervals = [[5,7],[1,3],[4,6],[8,10]]
// Output: [[1,3],[4,7],[8,10]]

// Explanation: Intervals [4,6] and [5,7] overlap and are merged into [4,7].

import java.util.*;

public class MergeIntervals {
    public static int[][] merge(int[][] intervals) {
        if (intervals.length == 0) return new int[0][];
        
        // Step 1: Sort by start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        
        List<int[]> result = new ArrayList<>();
        
        // Step 2: Traverse and merge
        int[] current = intervals[0];
        result.add(current);
        
        for (int[] interval : intervals) {
            // If overlap, merge
            if (interval[0] <= current[1]) {
                current[1] = Math.max(current[1], interval[1]);
            } else {
                // No overlap → add new interval
                current = interval;
                result.add(current);
            }
        }
        
        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        int[][] intervals1 = {{1,5},{3,6},{8,10},{15,18}};
        int[][] result1 = merge(intervals1);
        System.out.println("Output 1: " + Arrays.deepToString(result1));
        // [[1,6],[8,10],[15,18]]

        int[][] intervals2 = {{5,7},{1,3},{4,6},{8,10}};
        int[][] result2 = merge(intervals2);
        System.out.println("Output 2: " + Arrays.deepToString(result2));
        // [[1,3],[4,7],[8,10]]
    }
}

package _01arraysAndHashing;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an unsorted array of integers nums,
 * return the length of the longest consecutive elements sequence.
 * You must write an algorithm that runs in O(n) time.
 */
public class LongestConsecutiveSequence {

    /**
     * Use Set, keep track of numbers to the left and right
     * and remove them from set if existing.
     * Be careful of concurrent modification errors, so avoid iterator
     * Also check use of increment/decrement operators
     * O(n) time
     * O(n) space
     */
    public static int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int max = 0;
        for (int i = 0; i < nums.length; i++) { // do not use iterator
            int num = nums[i];
            if (set.contains(num)) {
                int count = 1;
                set.remove(num);

                int left = num - 1; // do not use post decrement operator
                while (set.contains(left)) {
                    set.remove(left);
                    count++;
                    left--;
                }

                int right = num + 1; // do not use post icrement operator
                while (set.contains(right)) {
                    set.remove(right);
                    count++;
                    right++;
                }

                max = Math.max(max, count);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(longestConsecutive(new int[]{100,4,200,1,3,2}));//4
        System.out.println(longestConsecutive(new int[]{0,3,7,2,5,8,4,6,0,1}));//9
    }
}

package _01arraysAndHashing;

import java.util.HashSet;
import java.util.Set;

/**
 * NOTES: Use a Set, add the numbers one by one from the array,
 * check if the set already contains the current number, short circuit.
 * 
 * https://leetcode.com/problems/contains-duplicate/
 * https://algo.monster/liteproblems/217
 */
public class ContainsDuplicate {

    /**
     * Given an integer array nums, return true if any value appears at least twice in the array,
     * and return false if every element is distinct.
     * O(n) time
     * O(n) space
     */
    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            }
            set.add(num);
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(containsDuplicate(new int[]{1,2,3,1}));//true
        System.out.println(containsDuplicate(new int[]{1,2,3,4}));//false
        System.out.println(containsDuplicate(new int[]{1,1,1,3,3,4,3,2,4,2}));//true
    }
}
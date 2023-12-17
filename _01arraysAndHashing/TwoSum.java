package _01arraysAndHashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers nums and an integer target,
 * return indices of the two numbers such that they add up to target.
 * You may assume that each input would have exactly one solution, 
 * and you may not use the same element twice.
 * You can return the answer in any order.
 * https://leetcode.com/problems/two-sum/description/
 * https://algo.monster/liteproblems/1
 */
public class TwoSum {
    
    /**
     * Use HashMap.
     * Short-circuit.
     * Be careful with returning the indexes,
     * just return the current index, do not get from map again.
     * O(n) time
     * O(n) space
     */
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{2,7,11,15}, 9)));//[0, 1]
        System.out.println(Arrays.toString(twoSum(new int[]{3,2,4}, 6)));//[1, 2]
        System.out.println(Arrays.toString(twoSum(new int[]{3,3}, 6)));//[0, 1]
    }
}

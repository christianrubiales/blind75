package _03twoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an integer array nums, return all the triplets 
 * [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 * Notice that the solution set must not contain duplicate triplets.
 * Notice that the order of the output and the order of the triplets does not matter.
 * https://leetcode.com/problems/3sum
 * https://algo.monster/liteproblems/15
 */
public class _3Sum {

    /**
     * JUST SORT! Easier to skip Duplicates.
     * Best runtime would still be O(n^2) so sorting first should not hurt.
     * Without sorting, worst case would still be O(n^2) but more confusing and more error-prone
     * O(n^2) time
     * O(log n) space complexity of quicksort 
     * O(n) for mergesort
     * ignoring the space for the return value (O(n))
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> triplets = new ArrayList<>();
        Arrays.sort(nums);

        int length = nums.length;
        for (int i = 0; i < length - 2; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i-1])) { // skip duplicates
                int left = i + 1;
                int right = length - 1;
                
                while (left < right) {
                    int sum = nums[i] + nums[left] + nums[right];
                    if (sum < 0) {
                        left++;
                    } else if (sum > 0) {
                        right--;
                    } else {
                        List<Integer> triplet = new ArrayList<>();
                        triplet.add(nums[i]);
                        triplet.add(nums[left]);
                        triplet.add(nums[right]);
                        triplets.add(triplet);

                        // skip duplicates
                        while (left < right && nums[left] == nums[left+1]) {
                            left++;
                        }
                        while (left < right && nums[right-1] == nums[right]) {
                            right--;
                        }
                        left++;
                        right--;
                    }
                }
            }
        }
        return triplets;
    }
    
    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{-1,0,1,2,-1,-4}));//[[-1,-1,2],[-1,0,1]]
        System.out.println(threeSum(new int[]{-1,1,0}));//[[-1,0,1]]
        System.out.println(threeSum(new int[]{-1,0,1,0}));//[[-1,0,1]]
        System.out.println(threeSum(new int[]{0,0,0}));//[[0,0,0]]
        System.out.println(threeSum(new int[]{0,1,1}));//[]
    }
}

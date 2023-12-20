package _10greedy;

/**
 * Given an integer array nums, find the subarray with the largest sum, and return its sum.
 */
public class MaximumSubarray {

    /**
     * Make a single pass on the numbers,
     * making a running sum
     * if the current sum becomes negative, reset the running sum to 0
     * Check if the current sum is the maximum sum at each iteration
     * Initialise the variables used with the first number in the array
     * Start the iteration on the second numbers
     * O(n) time with a single pass
     * O(1) space
     */
    public static int maxSubArray(int[] nums) {
        // use the first number
        int currentSum = nums[0];
        int max = nums[0];

        // continue from the second number
        for (int i = 1; i < nums.length; i++) {
            // if the current sum becomes negative, reset it to 0
            if (currentSum < 0) {
                currentSum = 0;
            }
            // add the current number to the current sum
            currentSum += nums[i];
            // update the max value
            max = Math.max(max, currentSum);
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));//6
        System.out.println(maxSubArray(new int[]{1}));//1
        System.out.println(maxSubArray(new int[]{-3,-2,-1}));//-1
    }
}
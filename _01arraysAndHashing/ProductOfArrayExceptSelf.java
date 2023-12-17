package _01arraysAndHashing;

import java.util.Arrays;

/**
 * Given an integer array nums, return an array answer such that answer[i] is equal to the product 
 * of all the elements of nums except nums[i].
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 * You must write an algorithm that runs in O(n) time and without using the division operation.
 * (The output array does not count as extra space for space complexity analysis.)
 * https://leetcode.com/problems/product-of-array-except-self/
 * https://algo.monster/liteproblems/238
 */
public class ProductOfArrayExceptSelf {
    
    /**
     * You must know the less efficient way of solving with extra arrays
     * because this is the optimization of that solution
     * Might be helpful to use pen and paper
     * Doesn't seem like a good interview question, because you need to already know the solution
     * O(n) time
     * O(1) space if not considering the size of the result array
     */
    public static int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] result = new int[length];

        int leftProduct = 1;
        for (int i = 0; i < length; i++) {
            result[i] = leftProduct;

            // update the left product for the next iteration
            leftProduct *= nums[i];
        }

        int rightProduct = 1;
        for (int i = length - 1; i > -1; i--) {
            result[i] *= rightProduct;

            // update the right product for the next iteration
            rightProduct *= nums[i];
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(productExceptSelf(new int[]{1,2,3,4})));//[24,12,8,6]
        System.out.println(Arrays.toString(productExceptSelf(new int[]{-1,1,0,-3,3})));//[0,0,9,0,0]
    }
}

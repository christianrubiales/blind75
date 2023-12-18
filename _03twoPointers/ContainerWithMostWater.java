package _03twoPointers;

/**
 * Return the maximum amount of water a container can store.
 * https://leetcode.com/problems/container-with-most-water
 * https://algo.monster/liteproblems/container-with-most-water
 */
public class ContainerWithMostWater {
    
    /**
     * Two-pointers
     * Keep the taller side
     * O(n) time
     * O(1) space
     */
    public static int maxArea(int[] height) {
        int max = 0;
        int left = 0;
        int right = height.length -1;

        while (left < right) {
            int area = (right - left) * Math.min(height[left], height[right]);
            max = Math.max(max, area);

            // keep the taller side
            if (height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1,8,6,2,5,4,8,3,7}));//49
        System.out.println(maxArea(new int[]{1,1}));//1
    }
}

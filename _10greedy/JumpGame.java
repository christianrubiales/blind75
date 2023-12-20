package _10greedy;

/**
 * You are given an integer array nums. You are initially positioned at the array's first index, 
 * and each element in the array represents your maximum jump length at that position.
 * Return true if you can reach the last index, or false otherwise.
 * https://algo.monster/liteproblems/55
 * https://www.youtube.com/watch?v=Zb4eRjuPHbM
 * https://www.youtube.com/watch?v=PVNLmjJaHW0
 */
public class JumpGame {
    
    /**
     * Iterate backwards, at each index, see if the jump from that index can reach the last good index
     * If it can then that is the new good index
     * If the last good index is the first index,
     * it means we can jump from the first index to the last index
     * First ideas that can come to mind would be backtracking
     * but that will be exponential O(2^n) because at each step, all the other steps are checked
     * O(n) time
     * O(1) space
     */
    public static boolean canJump(int[] nums) {
        int goodIndex = nums.length - 1; // the last index is a good index

        for (int i = nums.length - 2; i > -1; i--) {
            // can you jump from the current index to the good index?
            if (i + nums[i] >= goodIndex) {
                goodIndex = i; // make this the current good index
            }
        }

        return goodIndex == 0; // is the first index a good index?
    }

    public static void main(String[] args) {
        System.out.println(canJump(new int[]{2,3,1,1,4}));//true
        System.out.println(canJump(new int[]{3,2,1,0,4}));//false
    }
}

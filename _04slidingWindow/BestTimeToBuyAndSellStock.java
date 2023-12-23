package _04slidingWindow;

/*
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * You want to maximize your profit by choosing a single day to buy one stock
 * and choosing a different day in the future to sell that stock.
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock
 * https://algo.monster/liteproblems/121
 */
public class BestTimeToBuyAndSellStock {

    /*
     * Iterate over the prices once
     * taking note of the minimum price so far
     * At each iteration check if we are getting the maximum profit
     * O(n) time
     * O(1) space
     */
    public static int maxProfit(int[] prices) {
        int minSoFar = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {
            if (price < minSoFar) {
                minSoFar = price;
            }
            if (price - minSoFar > maxProfit) {
                maxProfit = price - minSoFar;
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7,1,5,3,6,4}));//5
        System.out.println(maxProfit(new int[]{7,6,4,3,1}));//0
    }
}

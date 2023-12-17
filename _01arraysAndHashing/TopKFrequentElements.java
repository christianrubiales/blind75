package _01arraysAndHashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Given an integer array nums and an integer k, return the k most frequent elements.
 * You may return the answer in any order.
 * It is guaranteed that the answer is unique.
 */
public class TopKFrequentElements {
    
    /**
     * Use HashMaps
     * Use getOrDefault() to simplify, remember to use put()
     * Tricky with indexes.
     * O(nlogn) time, for O(nlogk) use heap
     * O(n) size
     */
    public static int[] topKFrequent(int[] nums, int k) {
        // map of numbers to their counts
        Map<Integer, Integer> counts1 = new HashMap<>();
        for (int num : nums) {
            Integer count = counts1.getOrDefault(num, 0);
            counts1.put(num, ++count);
        }

        // map of counts to the numbers
        Map<Integer, List<Integer>> counts2 = new TreeMap<>(Collections.reverseOrder());
        for (Integer num : counts1.keySet()) {
            Integer count = counts1.get(num);
            List<Integer> numbers = counts2.getOrDefault(count, new ArrayList<>());
            counts2.put(count, numbers);
            numbers.add(num);
        }

        // counts in descending order
        List<Integer> counts3 = new ArrayList<>(counts2.keySet());
        int[] top = new int[k];
        int j = 0;
        for (Integer count : counts3) {
            List<Integer> numbers = counts2.get(count);
            for (int i = 0; i < numbers.size(); i++) {
                if (j + i == k) {
                    return top;
                }
                top[j + i] = numbers.get(i);
            }
            j += numbers.size();
        }

        return top;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(topKFrequent(new int[]{1,1,1,2,2,3}, 2)));//[1,2]
        System.out.println(Arrays.toString(topKFrequent(new int[]{1}, 1)));//[1]
        System.out.println(Arrays.toString(topKFrequent(new int[]{1,2}, 2)));//[1,2]
        System.out.println(Arrays.toString(topKFrequent(new int[]{1,2,3}, 3)));//[1,2,3]
    }
}

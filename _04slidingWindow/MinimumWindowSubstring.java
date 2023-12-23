package _04slidingWindow;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/*
 * Given two strings s and t of lengths m and n respectively,
 * return the minimum window substring of s 
 * such that every character in t (including duplicates) is included in the window.
 * If there is no such substring, return the empty string "".
 * The testcases will be generated such that the answer is unique.
 */
public class MinimumWindowSubstring {
    
    /*
     * This is hard for a lot of reasons.
     * It is difficult to make sure indexing is correct.
     */
    public static String minWindow(String s, String t) {
        if (t.length() > s.length()) {
            return "";
        }

        int min = Integer.MAX_VALUE;
        String minString = "";
        // Deque<Character> minString = new ArrayDeque<>();
        int tail = 0;
        int head = 0;
        Map<Character, Integer> counter1 = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            Integer count = counter1.getOrDefault(t.charAt(i), 0);
            counter1.put(t.charAt(i), ++count);
        }

        int count = 0;
        Map<Character, Integer> counter2 = new HashMap<>();
        while (head < s.length()) {
            // advance the head while we do not yet have all matches
            while (count < t.length() && head < s.length()) {
                char c = s.charAt(head);
                int count2 = counter2.getOrDefault(c, 0);
                if (counter1.containsKey(c)) {
                    counter2.put(c, ++count2);
                    if (count2 <= counter1.get(c)) {
                        count++;
                    }
                }
                head++;
            }
            // advance the tail 
            while (tail <= head && tail < s.length() && count >= t.length() - 1) {
                char c = s.charAt(tail);
                // String temp = s.substring(tail, head);
                int length = head - tail + 1;
                if (length < min && count == t.length()) {
                    min = Math.min(min, length);
                    minString = s.substring(tail, head);
                }
                if (!counter1.containsKey(c)) {
                    tail++;
                } else {
                    if (count == t.length()) {
                        int count2 = counter2.getOrDefault(c, 0);
                        counter2.put(c, --count2);
                        // if (count2 == 0) {
                        //     counter2.remove(c);
                        // }
                        if (counter2.getOrDefault(c, 0) < counter1.get(c)) {
                            count--;
                        }
                        tail++;
                    } else {
                        break;
                    }
                }
            }
        }
        
        return minString;
    }

    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));//BANC
        System.out.println(minWindow("a", "a"));//a
    }
}

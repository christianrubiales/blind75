package _04slidingWindow;

import java.util.HashMap;
import java.util.Map;

/*
 * Given a string s, find the length of the longest substring without repeating characters.
 * s consists of English letters, digits, symbols and spaces.
 * https://leetcode.com/problems/longest-substring-without-repeating-characters
 * https://algo.monster/liteproblems/3
 */
public class LongestSubstringWithoutRepeatingCharacters {
    
    /*
     * Use a tail pointer, a head pointer is not required.
     * Iterate through the characters
     * If a duplicate is found, take note of that index,
     * The new tail will be that index + 1
     * Remove all characters from the set starting from the old tail to the new tail
     * Use of a character array instead of map is faster but more confusing
     * O(n) time, due to iterating through the characters only once
     * O(n) space, because we are keeping track of the character found so far
     */
    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> charIndex = new HashMap<>();
        int tail = 0;
        int max = 0;

        for (int i = 0; i < s.length(); i++) {
            if (charIndex.containsKey(s.charAt(i))) {
                // remove all characters from the tail to the new tail
                int newTail = charIndex.get(s.charAt(i)) + 1;
                while (tail < newTail) {
                    charIndex.remove(s.charAt(tail));
                    tail++;
                }
            }
            // add the current character
            charIndex.put(s.charAt(i), i);
            // check if we have the longest substring
            max = Math.max(max, charIndex.size());
        }
        
        return max;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));//3
        System.out.println(lengthOfLongestSubstring("abcabb"));//3
        System.out.println(lengthOfLongestSubstring("abbabbaacc"));//2
    }
}

package _01arraysAndHashing;

/*
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, 
 * typically using all the original letters exactly once.
 * s and t consist of lowercase English letters.
 * https://leetcode.com/problems/valid-anagram/
 * https://algo.monster/liteproblems/242
 */
public class ValidAnagram {

    /*
     * Use an int array for counts of the 26 lowercase letters
     * Be careful with the space complexity
     * O(n) time
     * O(1) space because the additional space is constant
     */
    public static boolean isAnagram(String s, String t) {
        // if the strings are not the same length, they are cannot be anagrams
        if (s.length() != t.length()) {
            return false;
        }

        // count the letters in s
        int[] counts = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counts[s.charAt(i) - 'a']++;
        }

        // decrease the letter count if found in t
        for (int i = 0; i < t.length(); i++) {
            counts[t.charAt(i) - 'a']--;
            if (counts[t.charAt(i) - 'a'] < 0) {
                return false;
            }
        }

        // counts must match
        for (int i = 0; i < 26; i++) {
            if (counts[i] != 0) {
                return false;
            }
        }

        // all letter counts match
        return true;
    }
    
    public static void main(String[] args) {
        System.out.println(isAnagram("anagram", "nagaram"));//true
        System.out.println(isAnagram("rat", "car"));//false
    }
}

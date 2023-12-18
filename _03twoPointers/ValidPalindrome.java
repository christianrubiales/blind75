package _03twoPointers;

/**
 * A phrase is a palindrome if, after converting all uppercase letters into lowercase letters
 * and removing all non-alphanumeric characters, it reads the same forward and backward.
 * Alphanumeric characters include letters and numbers.
 * Given a string s, return true if it is a palindrome, or false otherwise.
 * s consists only of printable ASCII characters.
 * https://leetcode.com/problems/valid-palindrome
 * https://algo.monster/liteproblems/125
 */
public class ValidPalindrome {
    
    /**
     * Be careful with indexes.
     * Make sure there are no overflows or underflows
     * O(n) time
     * O(1) space, O(n) if you use s.toCharArray()
     */
    public static boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            // make sure left++ will not overflow
            while(left < s.length() - 1 && !isAlphaNumeric(s.charAt(left))) {
                left++;
            }
            // make sure right-- will not underflow
            while(right > 0 && !isAlphaNumeric(s.charAt(right))) {
                right--;
            }
            if (left < right && Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    public static boolean isAlphaNumeric(char c) {
        return ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9'));
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));//true
        System.out.println(isPalindrome("race a car"));//false
        System.out.println(isPalindrome(" "));//true
        System.out.println(isPalindrome(".,"));//true
    }
}

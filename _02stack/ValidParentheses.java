package _02stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']',
 * determine if the input string is valid.
 * An input string is valid if:
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Every close bracket has a corresponding open bracket of the same type.
 * s consists of parentheses only '()[]{}'.
 * https://leetcode.com/problems/valid-parentheses
 * https://algo.monster/liteproblems/20
 */
public class ValidParentheses {

    /**
     * Use the Deque interface and LinkedList implementation as stack
     * O(n) time as we iterate over the characters of the input
     * O(n) space 
     */
    public static boolean isValid(String s) {
        Deque<Character> stack = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') { // opening
                stack.push(c);
            } else if (c == ')' || c == ']' || c == '}') { // closing
                if (stack.isEmpty()) {
                    return false;
                }
                char x = stack.pop();
                // not matching
                if ((c == ')' && x != '(') || (c == ']' && x != '[') || (c == '}' && x != '{')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("()"));//true
        System.out.println(isValid("()[]{}"));//true
        System.out.println(isValid(""));//true
        System.out.println(isValid("([]{()})"));//true
        System.out.println(isValid("(]"));//false
        System.out.println(isValid("("));//false
        System.out.println(isValid("]"));//false
    }
}

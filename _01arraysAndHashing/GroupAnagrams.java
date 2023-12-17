package _01arraysAndHashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given an array of strings strs, group the anagrams together.
 * You can return the answer in any order.
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
 * typically using all the original letters exactly once.
 * strs[i] consists of lowercase English letters.
 */
public class GroupAnagrams {

    /**
     * Use HashMap and sorting of the letters of the words
     * Be careful and use map.put() if you use map.get()
     * O(n * (m log m)) (n number of words, m max length of words)
     * O(n*m) space (n number of words, m max length of words)
     */
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String key = new String(arr);
            List<String> list = map.get(key);
            if (list == null) {
                list = new ArrayList<>();
                map.put(key, list);
            }
            list.add(str);
        }

        List<List<String>> lists = new ArrayList<>();
        for (String key : map.keySet()) {
            lists.add(map.get(key));
        }

        return lists;
    }

    public static void main(String[] args) {
        System.out.println(groupAnagrams(new String[] {"eat","tea","tan","ate","nat","bat"}));
        //[["bat"],["nat","tan"],["ate","eat","tea"]]
        System.out.println(groupAnagrams(new String[] {""}));//[[""]]
        System.out.println(groupAnagrams(new String[] {"a"}));//[["a"]]
    }
}

/**
 * Given a string, find the length of the longest substring without repeating characters.
 *
 * Example 1:
 *
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 *
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 *
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 *              Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class LongestSubstringWithoutRepeatingChars {
    public int lengthOfLongestSubstring(String s) {
        // Map chars to indices they occur
        Map<Character, List<Integer>> map = new HashMap<>();
        int maxLen = 0;
        int startIndex = -1;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            List<Integer> list = map.get(c);
            if (list == null) {
                // char not in map
                list = new ArrayList<>();
            } else {
                int lastIndex = list.get(list.size() - 1);
                // char is only a repeat if it occurs in the substring currently being considered
                if (lastIndex > startIndex) {
                    int len = i - 1 - startIndex;
                    //System.out.println(len);
                    maxLen = Math.max(len, maxLen);
                    startIndex = lastIndex;
                }
            }
            list.add(i);
            map.put(c, list);
            //System.out.println(startIndex);
            //System.out.println(map);
        }
        maxLen = Math.max(chars.length - 1 - startIndex, maxLen);

        return maxLen;
    }
}

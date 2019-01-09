/**
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 *
 * Example 1:
 *
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * Example 2:
 *
 * Input: "cbbd"
 * Output: "bb"
 */


public class LongestPalindromicSubstring {
    // Dynamic programming solution:
    // Keep a table of whether substrings are palindromes
    
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        int n = s.length();
        int start = 0;
        int len = 1;
        // substrings from i to j inclusive
        boolean[][] table = new boolean[n][n];
        // All substrings of length 1 are palindromes
        for (int i = 0; i < n; i++) {
            table[i][i] = true;
        }
        // Substrings of length 2 are palindromes if both chars are the same
        for (int j = 1; j < n; j++) {
            int i = j - 1;
            if (s.charAt(i) == s.charAt(j)) {
                table[i][j] = true;
                start = i;
                len = 2;
            }
        }
        // Check for palindromes of length 3 to n
        for (int k = 3; k <= n; k++) {
            for (int j = k - 1; j < n; j++) {
                int i = j - k + 1;
                // Any palindrome without the start and end char must still be one
                if (s.charAt(i) == s.charAt(j) && table[i + 1][j - 1]) {
                    table[i][j] = true;
                    start = i;
                    len = k;
                }
            }
        }
        return s.substring(start, start + len);
    }
}

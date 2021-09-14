package Challenges;
/*
Date: 14 September 2021
Challenge: Longest Substring Without Repeating Characters
	Given a string s, find the length of the longest substring without repeating characters.
	Example 1:
		Input: s = "abcabcbb"
		Output: 3
		Explanation: The answer is "abc", with the length of 3.
	Example 2:
		Input: s = "bbbbb"
		Output: 1
		Explanation: The answer is "b", with the length of 1.
	Example 3:
		Input: s = "pwwkew"
		Output: 3
		Explanation: The answer is "wke", with the length of 3.
		Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
	Example 4:
		Input: s = ""
		Output: 0
	Constraints:
		0 <= s.length <= 5 * 10^4
		s consists of English letters, digits, symbols and spaces.
Developed by: Shu Yan
 */
import java.util.*;
public class Challenge_03 {
	public int lengthOfLongestSubstring(String s) {
		if (s.length() < 2) {
			return s.length();
		}
		int result = 0;
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			if (!map.containsKey(s.charAt(i))) {
				map.put(s.charAt(i), 0);
				result += 1;
			} else {
				break;
			}
		}
		return Math.max(result, lengthOfLongestSubstring(s.substring(1, s.length())));
	}
}

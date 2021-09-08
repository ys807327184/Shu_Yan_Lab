package Challenges;

import java.util.Arrays;

/*
Date: 7 September 2021
Challenge: Longest Common Prefix
	Write a function to find the longest common prefix string amongst an array of strings.
	If there is no common prefix, return an empty string "".
	Example 1:
		Input: strs = ["flower","flow","flight"]
		Output: "fl"
	Example 2:
		Input: strs = ["dog","racecar","car"]
		Output: ""
		Explanation: There is no common prefix among the input strings.
 	Constraints:
		1 <= strs.length <= 200
		0 <= strs[i].length <= 200
		strs[i] consists of only lower-case English letters.
Developed by: Shu Yan
 */
public class Challenge_14 {
	public String longestCommonPrefix(String[] strs) {
		if (strs == null || strs.length == 0) {
			return "";
		} else if (strs.length == 1) {
			return strs[0];
		} else if (strs.length == 2) {
			return longestCommonPrefix(strs[0], strs[1]);
		} else if (strs.length == 3) {
			return longestCommonPrefix(strs[0], longestCommonPrefix(strs[1], strs[2]));
		} else {
			int split = strs.length / 2;
			return longestCommonPrefix(longestCommonPrefix(Arrays.copyOfRange(strs, 0, split)), longestCommonPrefix(Arrays.copyOfRange(strs, split, strs.length)));
		}
	}
	public String longestCommonPrefix(String a, String b) {
		if (a.equals("") || b.equals("")) return "";
		String prefix;
		String compare;
		if (a.length() > b.length()) {
			compare = a;
			prefix = b;
		} else {
			compare = b;
			prefix = a;
		}
		if (compare.indexOf(prefix) == 0) return prefix;
		else if (compare.indexOf(prefix) != 0 && prefix.length() > 1){
			return longestCommonPrefix(compare, prefix.substring(0, prefix.length() - 1));
		} else {
			return "";
		}
	}
}

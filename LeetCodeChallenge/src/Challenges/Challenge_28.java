package Challenges;
/*
Date: 11 September 2021
Challenge: Implement strStr()
	Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
	Clarification:
		What should we return when needle is an empty string? This is a great question to ask during an interview.
		For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().
	Example 1:
		Input: haystack = "hello", needle = "ll"
		Output: 2
	Example 2:
		Input: haystack = "aaaaa", needle = "bba"
		Output: -1
	Example 3:
		Input: haystack = "", needle = ""
		Output: 0
 	Constraints:
		0 <= haystack.length, needle.length <= 5 * 10^4
		haystack and needle consist of only lower-case English characters.
Developed by: Shu Yan
 */
public class Challenge_28 {
	public int strStr(String hayback, String needle) {
		if (needle.length() == 0) return 0;
		int nlength = needle.length();
		int lastIndex = hayback.length() - nlength;
		for (int i = 0; i <= lastIndex; i++) {
			if (hayback.substring(i, i + nlength).equals(needle)) {
				return i;
			}
		}
		return -1;
	}
}

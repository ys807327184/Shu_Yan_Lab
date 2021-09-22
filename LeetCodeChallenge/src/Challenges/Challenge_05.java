package Challenges;
/*
Date: 20 September 2021
Challenge: Longest Palindrome Substring
	Given a string s, return the longest palindromic substring in s.
	Example 1:
		Input: s = "babad"
		Output: "bab"
		Note: "aba" is also a valid answer.
	Example 2:
		Input: s = "cbbd"
		Output: "bb"
	Example 3:
		Input: s = "a"
		Output: "a"
	Example 4:
		Input: s = "ac"
		Output: "a"
 	Constraints:
		1 <= s.length <= 1000
		s consist of only digits and English letters.
Developed by: Shu Yan
 */
public class Challenge_05 {
	Boolean[][] checkArray;
	public String longestPalindrome(String s) {
		int start = 0;
		int end = 0;
		int max = 0;
		checkArray = new Boolean[s.length()][s.length()];
		for (int i = 0; i < s.length() - 1; i++) {
			for (int j = i + 1; j < s.length(); j++) {
				if (checkStringPal(s, i, j) && j - i > max) {
					max = j - i;
					start = i;
					end = j;
				}
			}
		}
		return s.substring(start, end + 1);
	}
	Boolean checkStringPal(String s, int i, int j) {
		if (checkArray[i][j] == null) {
			checkArray[i][j] = s.charAt(i) == s.charAt(j) && (i + 1 == j || i == j || (i < j && checkStringPal(s, i + 1, j - 1)));
		}
		return checkArray[i][j];
	}
}

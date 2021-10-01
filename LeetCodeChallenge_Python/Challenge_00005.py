"""
Date: 1 October 2021
Challenge: Longest Palindromic Substring
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
"""
class Solution:
    #Version 1 Exceeded time limit
    """
    def longestPalindrome(self, s: str) -> str:
        start, end, max = 0, 0, 0
        for i in range(len(s) - 1):
            for j in range(i + 1, len(s)):
                if self.checkStringPal(s, i, j) and j - i > max:
                    max = j - i
                    start = i
                    end = j
        return s[start : end + 1]

    def checkStringPal(self, s: str, i: int, j: int) -> bool:
        while i < j:
            if s[i] != s[j]:
                return False
            else:
                i += 1
                j -= 1
        return True
    """
    def longestPalindrome(self, s: str) -> str:
        longest_pal = ''
        dp = [[0] * len(s) for _ in range(len(s))]
        for i in range(len(s)):
            dp[i][i] = True
            longest_pal = s[i]
        for i in range(len(s) - 1, -1, -1):
            for j in range(i + 1, len(s)):
                if s[i] == s[j]:
                    if j - i == 1 or dp[i + 1][j - 1] is True:
                        dp[i][j] = True
                        if len(longest_pal) < len(s[i : j + 1]):
                            longest_pal = s[i : j + 1]
        return longest_pal

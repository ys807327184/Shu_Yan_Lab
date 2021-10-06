"""
Date: 6 October 2021
Challenge: Regular Expression Matching
    Given an input string s and a pattern p, implement regular expression matching with support for '.' and '*' where:
        '.' Matches any single character.
        '*' Matches zero or more of the preceding element.
    The matching should cover the entire input string (not partial).
    Example 1:
        Input: s = "aa", p = "a"
        Output: false
        Explanation: "a" does not match the entire string "aa".
    Example 2:
        Input: s = "aa", p = "a*"
        Output: true
        Explanation: '*' means zero or more of the preceding element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
    Example 3:
        Input: s = "ab", p = ".*"
        Output: true
        Explanation: ".*" means "zero or more (*) of any character (.)".
    Example 4:
        Input: s = "aab", p = "c*a*b"
        Output: true
        Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore, it matches "aab".
    Example 5:
        Input: s = "mississippi", p = "mis*is*p*."
        Output: false
    Constraints:
        1 <= s.length <= 20
        1 <= p.length <= 30
        s contains only lowercase English letters.
        p contains only lowercase English letters, '.', and '*'.
        It is guaranteed for each appearance of the character '*', there will be a previous valid character to match.
Developed by: Shu Yan
"""
class Solution:
    def isMatch(self, s: str, p: str) -> bool:
        indexS = len(s) - 1
        indexP = len(p) - 1
        return self.recursion(s, p, indexS, indexP)

    def recursion(self, s: str, p: str, indexS: int, indexP: int) -> bool:
        while indexS >= -1 and indexP >= 0:
            if p[indexP] != '*':
                if indexS == -1 or p[indexP] != '.' and p[indexP] != s[indexS]:
                    return False
                indexS -= 1
                indexP -= 1
            else:
                if self.recursion(s, p, indexS, indexP - 2):
                    return True
                if indexS == -1 or p[indexP] != '.' and s[indexS] != p[indexP - 1]:
                    return False
                return self.recursion(s, p, indexS - 1, indexP)
        if indexS == indexP == -1:
            return True
        else:
            return False
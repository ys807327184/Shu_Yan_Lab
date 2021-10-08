"""
Date: 8 October 2021
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
"""
class Solution:
    def longestCommonPrefix(self, strs: List[str]) -> str:
        longest_prefix_length = 200
        for i in strs:
            longest_prefix_length = min(longest_prefix_length, len(i))
        result = ""
        for i in range(longest_prefix_length):
            for k in range(1, len(strs)):
                if strs[0][i] != strs[k][i]:
                    return result
            result += strs[0][i]
        return result
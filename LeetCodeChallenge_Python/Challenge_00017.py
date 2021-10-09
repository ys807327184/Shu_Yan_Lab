"""
Date: 9 October 2021
Challenge: Letter Combinations of a Phone Number
    Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.
    A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
    Example 1:
        Input: digits = "23"
        Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
    Example 2:
        Input: digits = ""
        Output: []
    Example 3:
        Input: digits = "2"
        Output: ["a","b","c"]
    Constraints:
        0 <= digits.length <= 4
        digits[i] is a digit in the range ['2', '9'].
Developed by: Shu Yan
"""
from typing import List
class Solution:
    def letterCombinations(self, digits: str) -> List[str]:
        map = {
            "2" : "abc",
            "3" : "def",
            "4" : "ghi",
            "5" : "jkl",
            "6" : "mno",
            "7" : "pqrs",
            "8" : "tuv",
            "9" : "wxyz"
        }
        result = []
        if len(digits) == 1:
            for l1 in map[digits[0]]:
                result.append(l1)
        elif len(digits) == 2:
            for l1 in map[digits[0]]:
                for l2 in map[digits[1]]:
                    result.append("".join([l1, l2]))
        elif len(digits) == 3:
            for l1 in map[digits[0]]:
                for l2 in map[digits[1]]:
                    for l3 in map[digits[2]]:
                        result.append("".join([l1, l2, l3]))
        elif len(digits) == 4:
            for l1 in map[digits[0]]:
                for l2 in map[digits[1]]:
                    for l3 in map[digits[2]]:
                        for l4 in map[digits[3]]:
                            result.append("".join([l1, l2, l3, l4]))
        return result


"""
Date: 6 October 2021
Challenge: String to Integer(atoi)
    Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer (similar to C/C++'s atoi function).
    The algorithm for myAtoi(string s) is as follows:
        Read in and ignore any leading whitespace.
        Check if the next character (if not already at the end of the string) is '-' or '+'. Read this character in if it is either. This determines if the final result is negative or positive respectively. Assume the result is positive if neither is present.
        Read in next the characters until the next non-digit charcter or the end of the input is reached. The rest of the string is ignored.
        Convert these digits into an integer (i.e. "123" -> 123, "0032" -> 32). If no digits were read, then the integer is 0. Change the sign as necessary (from step 2).
        If the integer is out of the 32-bit signed integer range [-231, 231 - 1], then clamp the integer so that it remains in the range. Specifically, integers less than -231 should be clamped to -231, and integers greater than 231 - 1 should be clamped to 231 - 1.
        Return the integer as the final result.
    Note:
        Only the space character ' ' is considered a whitespace character.
        Do not ignore any characters other than the leading whitespace or the rest of the string after the digits.
    Constraints:
        0 <= s.length <= 200
        s consists of English letters (lower-case and upper-case), digits (0-9), ' ', '+', '-', and '.'.
"""
class Solution:
    def myAtoi(self, s: str) -> int:
        s = s.lstrip()
        result = 0
        negative = False
        sign = 0
        for i in range(len(s)):
            if '0' <= s[i] <= '9':
                result = result * 10 + int(s[i])
                sign = 1
            elif s[i] == '+' and sign == 0:
                negative = False
                sign = 1
            elif s[i] == '-' and sign == 0:
                negative = True
                sign = 1
            else:
                break
        if result > (2 ** 31) - 1:
            return -2 ** 31 if negative else (2 ** 31) - 1
        else:
            return result * -1 if negative else result
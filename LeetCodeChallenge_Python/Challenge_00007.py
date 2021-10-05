"""
Date: 5 October 2021
Challenge: Reverse Integer
    Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
    Assume the environment does not allow you to store 64-bit integers (signed or unsigned).
    Example 1:
        Input: x = 123
        Output: 321
    Example 2:
        Input: x = -123
        Output: -321
    Example 3:
        Input: x = 120
        Output: 21
    Example 4:
        Input: x = 0
        Output: 0
    Constraints:
        -2^31 <= x <= 2^31 - 1
Developed by: Shu Yan
"""
class Solution:
    def reverse(self, x: int) -> int:
        result = 0
        negative = x < 0
        if negative:
            x = x * -1
        while x > 0:
            remainder = x % 10
            result = remainder + (result * 10)
            x = x // 10
        if result > (2 ** 31) - 1 or result < -2 ** 31:
            return 0
        elif negative:
            return result * -1
        else:
            return result
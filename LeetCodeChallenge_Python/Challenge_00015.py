"""
Date: 8 October 2021
Challenge: 3Sum
    Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
    Notice that the solution set must not contain duplicate triplets.
    Example 1:
        Input: nums = [-1,0,1,2,-1,-4]
        Output: [[-1,-1,2],[-1,0,1]]
    Example 2:
        Input: nums = []
        Output: []
    Example 3:
        Input: nums = [0]
        Output: []
    Constraints:
        0 <= nums.length <= 3000
        -10^5 <= nums[i] <= 10^5
Developed by: Shu Yan
"""
from typing import List
class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        # Version Time Limit Exceeded
        """
        nums.sort()
        result = []
        check_repeat = set()
        for x in range(len(nums) - 2):
            for y in range(x + 1, len(nums) - 1):
                for z in range(y + 1, len(nums)):
                    if nums[x] + nums[y] + nums[z] == 0 and (nums[x], nums[y], nums[z]) not in check_repeat:
                        result.append([nums[x], nums[y], nums[z]])
                        check_repeat.add((nums[x], nums[y], nums[z]))
        return result
        """
        # Version 2
        """
        nums.sort()
        result = []
        check_repeat = set()
        for i in range(len(nums) - 1, -1, -1):
            start, end = 0, i - 1
            while start < end:
                sum = nums[i] + nums[start] + nums[end]
                if sum == 0:
                    if (nums[i], nums[start], nums[end]) not in check_repeat:
                        result.append([nums[i], nums[start], nums[end]])
                        check_repeat.add(nums[i], nums[start], nums[end])
                        start += 1
                    elif s > 0:
                        end -= 1
                    else:
                        start += 1
        return result
        """


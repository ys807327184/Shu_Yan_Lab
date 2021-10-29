"""
Date: 11 October 2021
Challenge: 4Sum
    Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:
        0 <= a, b, c, d < n
        a, b, c, and d are distinct.
        nums[a] + nums[b] + nums[c] + nums[d] == target
    You may return the answer in any order.
    Example 1:
        Input: nums = [1,0,-1,0,-2,2], target = 0
        Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
    Example 2:
        Input: nums = [2,2,2,2,2], target = 8
        Output: [[2,2,2,2]]
    Constraints:
        1 <= nums.length <= 200
        -10^9 <= nums[i] <= 10^9
        -10^9 <= target <= 10^9
Developed by: Shu Yan
"""
from typing import List
class Solution:
    def fourSum(self, nums: List[int], target: int) -> List[List[int]]:
        n = len(nums)
        nums.sort()
        num_counters = {}
        for num in nums:
            num_counters[num] = 1 if num not in num_counters else num_counters[nums] + 1
        def search(start, end, target) -> int:
            if target <= nums[start]:
                return start
            if nums[end] < target:
                return -1
            length = end - start + 1
            while length > 0:
                while start + length <= end and nums[start + length] < target:
                    start += length
                length = length // 2
            return start + 1
        def find_k_sum(k, start, target) -> List[List[int]]:
            if k == 1:
                if target in num_counters and num_counters[target] > 0:
                    return [[target]]
                return []
            target_i = search(start, n - k, target - sum(nums[n - k + 1 : ]))
            if target_i == -1:
                return []
            result = []
            for i in range(target_i, n - k + 1):
                if i > target_i and nums[i] == nums[i - 1]:
                    continue
                if sum(nums[i : i + k]) > target:
                    return result
                num_counters[nums[i]] -= 1
                for l in find_k_sum(k - 1, i + 1, target - nums[i]):
                    result.append([nums[i]] + l)
                num_counters[nums[i]] += 1
            return result
        return find_k_sum(4, 0, target)

"""
Date: 9 October 2021
Challenge: 3Sum Closest
    Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is closest to target.
    Return the sum of the three integers.
    You may assume that each input would have exactly one solution.
    Example 1:
        Input: nums = [-1,2,1,-4], target = 1
        Output: 2
        Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
    Example 2:
        Input: nums = [0,0,0], target = 1
        Output: 0
    Constraints:
        3 <= nums.length <= 1000
        -1000 <= nums[i] <= 1000
        -10^4 <= target <= 10^4
Developed by: Shu Yan
"""
class Solution:
    def threeSumClosest(self, nums: List[int], target: int) -> int:
        if not nums or len(nums) < 3:
            return 0
        nums.sort()
        min_sum = float("inf")
        for i in range(len(nums) - 2):
            if i > 0 and nums[i] == nums[i - 1]:
                continue
            left = i + 1
            right = len(nums) - 1
            while left < right:
                sum = nums[i] + nums[left] + nums[right]
                if sum > target:
                    right -= 1
                elif sum < target:
                    left += 1
                else:
                    left += 1
                    right -= 1
                    while left < right and nums[left] == nums[left - 1]:
                        left += 1
                    while left < right and nums[right] == nums[right + 1]:
                        right -= 1
                if abs(target - min_sum) > abs(target - sum):
                    min_sum = sum
        return min_sum
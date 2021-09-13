package Challenges;
/*
Date: 13 September 2021
Challenge: Maximum Subarray
	Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
	A subarray is a contiguous part of an array.
	Example 1:
		Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
		Output: 6
		Explanation: [4,-1,2,1] has the largest sum = 6.
	Example 2:
		Input: nums = [1]
		Output: 1
	Example 3:
		Input: nums = [5,4,-1,7,8]
		Output: 23
 	Constraints:
		1 <= nums.length <= 3 * 10^4
		-10^5 <= nums[i] <= 10^5
 */
public class Challenge_53 {
	public int maxSubArray(int[] nums) {
		int maxSum = nums[0];
		int currSum = maxSum;
		for (int i = 1; i < nums.length; i++) {
			currSum = Math.max(currSum + nums[i], nums[i]);
			maxSum = Math.max(maxSum, currSum);
		}
		return maxSum;
	}
}

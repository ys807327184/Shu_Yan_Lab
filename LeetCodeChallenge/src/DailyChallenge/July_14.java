package DailyChallenge;
/*
Date: 14 July 2021
Challenge: Find Peak Element
	A peak element is an element that is strictly greater than its neighbors.
	Given an integer array nums, find a peak element, and return its index. If the array contains multiple peaks, return the index to any of the peaks.
	You may imagine that nums[-1] = nums[n] = -??.
	You must write an algorithm that runs in O(log n) time.
	Example 1:
		Input: nums = [1,2,3,1]
		Output: 2
		Explanation: 3 is a peak element and your function should return the index number 2.
	Example 2:
		Input: nums = [1,2,1,3,5,6,4]
		Output: 5
		Explanation: Your function can return either index number 1 where the peak element is 2, or index number 5 where the peak element is 6.
 	Constraints:
		1 <= nums.length <= 1000
		-231 <= nums[i] <= 231 - 1
		nums[i] != nums[i + 1] for all valid i.
Developed by: Shu Yan
*/
public class July_14 {
	//Version 1
	/*public int findPeakElement(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			if (nums.length == 1) {
				return 0;
			}else if (i == 0) {
				if (nums[i] > nums[i + 1]) return i;
			} else if (i == nums.length - 1) {
				if (nums[i] > nums[i - 1]) return i;
			} else {
				if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) return i;
			}
		}
		return -1;
	}*/
	//Version 2 Simplified
	public int findPeakElement(int[] nums) {
		int left, right;
		if (nums.length == 1) {
			return 0;
		} else {
			for (int i = 0; i < nums.length; i++) {
				left = i > 0 ? nums[i - 1] : Integer.MIN_VALUE;
				right = i < nums.length - 1 ? nums[i + 1] : Integer.MIN_VALUE;
				if (nums[i] > left && nums[i] > right) return i;
			}
		}
		return -1;
	}
}

package DailyChallenge;
/*
Date: 22 September 2021
Challenge: Max Consecutive Ones
	Given a binary array nums, return the maximum number of consecutive 1's in the array.
	Example 1:
		Input: nums = [1,1,0,1,1,1]
		Output: 3
		Explanation: The first two digits or the last three digits are consecutive 1s. The maximum number of consecutive 1s is 3.
	Example 2:
		Input: nums = [1,0,1,1,0,1]
		Output: 2
	Constraints:
		1 <= nums.length <= 10^5
		nums[i] is either 0 or 1.
Developed by: Shu Yan
 */
public class September_22_2021 {
	public int findMaxConsecutiveOnes(int[] nums) {
		int result = 0;
		int max = 0;
		if (nums[0] == 1) max++;
		if (nums.length == 1) return max;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] == 0) {
				result = Math.max(max, result);
				max = 0;
			} else {
				max++;
			}
		}
		return Math.max(max, result);
	}
}

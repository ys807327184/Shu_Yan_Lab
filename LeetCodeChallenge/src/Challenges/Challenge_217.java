package Challenges;
/*
Date: 13 September 2021
Challenge: Contains Duplicate
	Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.
	Example 1:
		Input: nums = [1,2,3,1]
		Output: true
	Example 2:
		Input: nums = [1,2,3,4]
		Output: false
	Example 3:
		Input: nums = [1,1,1,3,3,4,3,2,4,2]
		Output: true
	Constraints:
		1 <= nums.length <= 10^5
		-10^9 <= nums[i] <= 10^9
 */
import java.util.*;
public class Challenge_217 {
	public boolean containsDuplicate(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(nums[i])) {
				return true;
			} else {
				map.put(nums[i], nums[i]);
			}
		}
		return false;
	}
}

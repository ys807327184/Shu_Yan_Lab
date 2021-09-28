package Challenges;
/*
Date: 28 September 2021
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
 */
import java.util.*;
public class Challenge_15 {
	public List<List<Integer>> threeSum(int[] nums){
		if (nums == null || nums.length == 0) {
			return new ArrayList<>();
		}
		HashSet<List<Integer>> result = new HashSet<>();
		Arrays.sort(nums);
		int length = nums.length;
		for (int i = 0; i < length - 2; i++) {
			int left = i + 1, right = length - 1;
			while (left < right) {
				int sum = nums[i] + nums[left] + nums[right];
				if (sum == 0) {
					result.add(Arrays.asList(nums[i], nums[left], nums[right]));
				} else if (sum < 0) {
					left++;
				} else {
					right++;
				}
			}
		}
		return new ArrayList<>(result);
	}
}

package DailyChallenge;

import java.util.Arrays;

/*
Date: 16 July 2021
Challenge: Valid Triangle Number
	Given an integer array nums, return the number of triplets chosen from the array that can make triangles if we take them as side lengths of a triangle.
	Example 1:
		Input: nums = [2,2,3,4]
		Output: 3
		Explanation: Valid combinations are: 
			2,3,4 (using the first 2)
			2,3,4 (using the second 2)
			2,2,3
	Example 2:
		Input: nums = [4,2,3,4]
		Output: 4
 	Constraints:
		1 <= nums.length <= 1000
		0 <= nums[i] <= 1000
Developed by: Shu Yan
*/
public class July_16 {
	//Version 1 Simply iterate through every value
	public int triangleNumber(int[] nums) {
		int count = 0;
		Arrays.sort(nums);
		for (int x = 0; x < nums.length - 2; x++) {
			if (nums[x] == 0) continue;
			for (int y = x + 1; y < nums.length - 1; y++) {
				if (nums[y] == 0) continue;
				for (int z = y + 1; z < nums.length; z++) {
					if (nums[z] == 0) continue;
					if (nums[x] + nums[y] > nums[z]) count++;
				}
			}
		}
		return count;
	}
}

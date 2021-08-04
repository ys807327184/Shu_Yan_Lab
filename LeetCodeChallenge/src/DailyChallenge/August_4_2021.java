package DailyChallenge;
/*
Date: 4 August 2021
Challenge: Subsets II
	Given an integer array nums that may contain duplicates, return all possible subsets (the power set).
	The solution set must not contain duplicate subsets. Return the solution in any order.
	Example 1:
		Input: nums = [1,2,2]
		Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
	Example 2:
		Input: nums = [0]
		Output: [[],[0]]
 	Constraints:
		1 <= nums.length <= 10
		-10 <= nums[i] <= 10
Developed by: Shu Yan
 */
import java.util.*;
public class August_4_2021 {
	private List<List<Integer>> result;
	
	public List<List<Integer>> subsetsWithDup(int[] nums){
		Arrays.sort(nums);
		result = new ArrayList();
		backTracking(0, nums, new ArrayList());
		return result;
	}
	
	public void backTracking(int index, int[] nums, List<Integer> list) {
		result.add(new ArrayList(list));
		for(int i = index; i < nums.length; i++) {
			if(i != index && nums[i] == nums[i - 1]) continue;
			list.add(nums[i]);
			backTracking(i + 1, nums, list);
			list.remove(list.size() - 1);
		}
	}
}

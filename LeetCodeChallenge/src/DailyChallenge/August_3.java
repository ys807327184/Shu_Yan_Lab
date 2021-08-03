package DailyChallenge;
/*
Date: 3 August 2021
Challenge: Two Sum
	Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
	You may assume that each input would have exactly one solution, and you may not use the same element twice.
	You can return the answer in any order.
	Example 1:
		Input: nums = [2,7,11,15], target = 9
		Output: [0,1]
		Output: Because nums[0] + nums[1] == 9, we return [0, 1].
	Example 2:
		Input: nums = [3,2,4], target = 6
		Output: [1,2]
	Example 3:
		Input: nums = [3,3], target = 6
		Output: [0,1]
 	Constraints:
		2 <= nums.length <= 10^4
		-10^9 <= nums[i] <= 10^9
		-10^9 <= target <= 10^9
		Only one valid answer exists.
Developed by: Shu Yan
 */
import java.util.*;
public class August_3 {
	//Version 1 
	//Runtime beats 64.85%
	//Memory usage beats 18.7%
	/*
	public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++){
            if (map.containsKey(target - nums[i]) && i != map.get(target - nums[i])){
                result[0] = i;
                result[1] = map.get(target - nums[i]);
                break;
            }
        }
        return result;
    }
    */
	//Version 2
	//Runtime beats 9.06%
	//Memory usage beats 64.42%
	/*
	public int[] twoSum(int[] nums, int target) {
		int[] result = new int[2];
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < nums.length; j++) {
				if (nums[i] + nums[j] == target && i != j) {
					result[0] = i;
					result[1] = j;
					return result;
				}
			}
		}
		return result;
	}
	*/
	//Version 3
	public int[] twoSum(int[] nums, int target) {
		for (int i = 0; i < nums.length - 1; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] + nums[j] == target) {
					System.gc();
					return new int[] {i, j};
				}
			}
		}
		return null;
	}
}

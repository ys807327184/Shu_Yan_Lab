package DailyChallenge;
/*
 * Date: 21 July 2021
 * Challenge: Shuffle an Array
		Given an integer array nums, design an algorithm to randomly shuffle the array. All permutations of the array should be equally likely as a result of the shuffling.
		Implement the Solution class:
			Solution(int[] nums) Initializes the object with the integer array nums.
			int[] reset() Resets the array to its original configuration and returns it.
			int[] shuffle() Returns a random shuffling of the array.
 		Example 1:
			Input
				["Solution", "shuffle", "reset", "shuffle"]
				[[[1, 2, 3]], [], [], []]
			Output
				[null, [3, 1, 2], [1, 2, 3], [1, 3, 2]]
		Explanation
			Solution solution = new Solution([1, 2, 3]);
			solution.shuffle();    // Shuffle the array [1,2,3] and return its result.
                       			   // Any permutation of [1,2,3] must be equally likely to be returned.
                                   // Example: return [3, 1, 2]
			solution.reset();      // Resets the array back to its original configuration [1,2,3]. Return [1, 2, 3]
			solution.shuffle();    // Returns the random shuffling of array [1,2,3]. Example: return [1, 3, 2]
		Constraints:
			1 <= nums.length <= 200
			-10^6 <= nums[i] <= 10^6
			All the elements of nums are unique.
			At most 5 * 104 calls in total will be made to reset and shuffle.
	Developed by: Shu Yan
 */
import java.util.*;
public class July_21 {
	private List<Integer> nums = new ArrayList<>();
	private int[] origin;
	
	public July_21(int[] nums) {//refers to Solution()
		this.origin = Arrays.copyOf(nums, nums.length);
		for (int i = 0; i < nums.length; i++) {
			this.nums.add(nums[i]);
		}
	}
	
	/** Resets the array to its original configuration and return it.*/
	public int[] reset() {
		return origin;
	}
	
	/** Returns a random shuffling of the array. */
	public int[] shuffle() {
		int[] result = new int[origin.length];
		Collections.shuffle(nums);
		for (int i = 0; i < origin.length; i++) {
			result[i] = nums.get(i);
		}
		return result;
	}
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
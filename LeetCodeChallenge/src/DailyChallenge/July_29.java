package DailyChallenge;
/*
Date: 29 July 2021
Challenge: Beautiful Array
	For some fixed n, an array nums is beautiful if it is a permutation of the integers 1, 2, ..., n, such that:
	For every i < j, there is no k with i < k < j such that nums[k] * 2 = nums[i] + nums[j].
	Given n, return any beautiful array nums.  (It is guaranteed that one exists.)
	Example 1:
		Input: n = 4
		Output: [2,1,4,3]
	Example 2:
		Input: n = 5
		Output: [3,1,2,5,4]
 	Note:
		1 <= n <= 1000
Developed by: Shu Yan
 */
import java.util.*;
public class July_29 {
	//Version 1 Found a dynamic programming pattern
	public int[] beautifulArray(int n) {
		return sortBeautifulArray(generateArray(n));
	}
	//Convert int n to an array of [1, 2, ..., n]
	public int[] generateArray(int n) {
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = i + 1;
		}
		return arr;
	}
	//Sort array
	public int[] sortBeautifulArray(int[] arr) {
		if (arr.length < 3) {
			return arr;
		} else {
			int[] odd = new int[arr.length / 2];
			int[] even = new int[(arr.length + 1) / 2];
			int oddNext = 0;
			int evenNext = 0;
			for (int i = 0; i < arr.length; i++) {
				if (i % 2 == 1) {
					odd[oddNext] = arr[i];
					oddNext++;
				} else {
					even[evenNext] = arr[i];
					evenNext++;
				}
			}
			int[] result = new int[arr.length];
			System.arraycopy(sortBeautifulArray(odd), 0, result, 0, odd.length);
			System.arraycopy(sortBeautifulArray(even), 0, result, odd.length, even.length);
			return result;
		}
	}
}

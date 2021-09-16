package DailyChallenge;
/*
Date: 16 September 2021
Challenge: Longest Turbulent Subarray
	Given an integer array arr, return the length of a maximum size turbulent subarray of arr.
	A subarray is turbulent if the comparison sign flips between each adjacent pair of elements in the subarray.
	More formally, a subarray [arr[i], arr[i + 1], ..., arr[j]] of arr is said to be turbulent if and only if:
	For i <= k < j:
		arr[k] > arr[k + 1] when k is odd, and
		arr[k] < arr[k + 1] when k is even.
	Or, for i <= k < j:
		arr[k] > arr[k + 1] when k is even, and
		arr[k] < arr[k + 1] when k is odd.
 	Example 1:
		Input: arr = [9,4,2,10,7,8,8,1,9]
		Output: 5
		Explanation: arr[1] > arr[2] < arr[3] > arr[4] < arr[5]
	Example 2:
		Input: arr = [4,8,12,16]
		Output: 2
	Example 3:
		Input: arr = [100]
		Output: 1
 	Constraints:
		1 <= arr.length <= 4 * 10^4
		0 <= arr[i] <= 10^9
Developed by: Shu Yan
 */
public class September_16_2021 {
	public int maxTurbulentSize(int[] arr) {
		int length = arr.length;
		if (length < 2) return length;
		
		int total = 1, max = 0;
		
		for (int i = 1; i < length; i++) {
			if (arr[i] != arr[i - 1]) total++;
			while (i < length - 1 && ((arr[i] - arr[i - 1]) / 10000.0) * ((arr[i] - arr[i + 1]) / 10000.0) > 0) {
				total++;
				i++;
			}
			max = Math.max(total, max);
			total = 1;
		}
		return max;
	}
}

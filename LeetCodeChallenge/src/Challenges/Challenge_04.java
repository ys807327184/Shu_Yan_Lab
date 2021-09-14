package Challenges;
/*
Date: 14 September 2021
Challenge: Median of Two Sorted Arrays
	Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
	The overall run time complexity should be O(log (m+n)).
	Example 1:
		Input: nums1 = [1,3], nums2 = [2]
		Output: 2.00000
		Explanation: merged array = [1,2,3] and median is 2.
	Example 2:
		Input: nums1 = [1,2], nums2 = [3,4]
		Output: 2.50000
		Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
	Example 3:
		Input: nums1 = [0,0], nums2 = [0,0]
		Output: 0.00000
	Example 4:
		Input: nums1 = [], nums2 = [1]
		Output: 1.00000
	Example 5:
		Input: nums1 = [2], nums2 = []
		Output: 2.00000
 	Constraints:
		nums1.length == m
		nums2.length == n
		0 <= m <= 1000
		0 <= n <= 1000
		1 <= m + n <= 2000
		-10^6 <= nums1[i], nums2[i] <= 10^6
 */
import java.util.*;
public class Challenge_04 {
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int[] merge = mergeArrays(nums1, nums2);
		if (merge.length == 1) {
			return Double.valueOf(merge[0]);
		} else {
			if (merge.length % 2 == 0) {
				return Double.valueOf(merge[merge.length / 2] + merge[(merge.length / 2) - 1]) / 2;
			} else {
				return Double.valueOf(merge[merge.length / 2]);
			}
		}
	}
	
	public int[] mergeArrays(int[] nums1, int[] nums2) {
		int m = nums1.length;
		int n = nums2.length;
		int[] merge = new int[m + n];
		if (m == 0) {
			return nums2;
		} else if (n == 0) {
			return nums1;
		} else {
			System.arraycopy(nums1, 0, merge, 0, m);
			System.arraycopy(nums2, 0, merge, m, n);
			Arrays.sort(merge);
			return merge;
		}
	}
}

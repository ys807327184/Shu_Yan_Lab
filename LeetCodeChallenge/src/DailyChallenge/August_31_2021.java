package DailyChallenge;
/*
Date: 31 August 2021
Challenge: Range Addition II
	You are given an m x n matrix M initialized with all 0's and an array of operations ops, where ops[i] = [ai, bi] means M[x][y] should be incremented by one for all 0 <= x < ai and 0 <= y < bi.
	Count and return the number of maximum integers in the matrix after performing all the operations.
	Example 1:
		Input: m = 3, n = 3, ops = [[2,2],[3,3]]
		Output: 4
		Explanation: The maximum integer in M is 2, and there are four of it in M. So return 4.
	Example 2:
		Input: m = 3, n = 3, ops = [[2,2],[3,3],[3,3],[3,3],[2,2],[3,3],[3,3],[3,3],[2,2],[3,3],[3,3],[3,3]]
		Output: 4
	Example 3:
		Input: m = 3, n = 3, ops = []
		Output: 9
 	Constraints:
		1 <= m, n <= 4 * 10^4
		0 <= ops.length <= 10^4
		ops[i].length == 2
		1 <= ai <= m
		1 <= bi <= n
 */
public class August_31_2021 {
	public int maxCount(int m, int n, int[][] ops) {
		int r = m, c = n;
		for (int[] op : ops) {
			r = Math.min(r, op[0]);
			c = Math.min(c, op[1]);
		}
		return r * c;
	}
}

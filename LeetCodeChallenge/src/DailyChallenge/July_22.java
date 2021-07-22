package DailyChallenge;
/*
Date: 22 July 2021
Challenge: Push Dominoes
	There are n dominoes in a line, and we place each domino vertically upright. In the beginning, we simultaneously push some of the dominoes either to the left or to the right.
	After each second, each domino that is falling to the left pushes the adjacent domino on the left. Similarly, the dominoes falling to the right push their adjacent dominoes standing on the right.
	When a vertical domino has dominoes falling on it from both sides, it stays still due to the balance of the forces.
	For the purposes of this question, we will consider that a falling domino expends no additional force to a falling or already fallen domino.
	You are given a string dominoes representing the initial state where:
		dominoes[i] = 'L', if the ith domino has been pushed to the left,
		dominoes[i] = 'R', if the ith domino has been pushed to the right, and
		dominoes[i] = '.', if the ith domino has not been pushed.
		Return a string representing the final state.
	Example 1:
		Input: dominoes = "RR.L"
		Output: "RR.L"
		Explanation: The first domino expends no additional force on the second domino.
	Example 2:
		Input: dominoes = ".L.R...LR..L.."
		Output: "LL.RR.LLRRLL.."
 	Constraints:
		n == dominoes.length
		1 <= n <= 10^5
		dominoes[i] is either 'L', 'R', or '.'.
Developed by: Shu Yan
 */
public class July_22 {
	//Version 1 Simply go through each domino
	public String pushDominoes(String dominoes) {
		char[] result = dominoes.toCharArray();
		for (int i = 0; i < result.length; i++) {
			if (result[i] == 'L' && i != 0) {
				for (int j = i - 1; j >= 0; j--) {
					if (result[j] == 'L' || (result[j] == '.' && j == 0)) {
						for (int m = j; m < i; m++) {
							result[m] = 'L';
						}
						break;
					} else if (result[j] == 'R') {
						for (int m = j; m < i; m++) {
							if (m < (double)(i + j) / 2) {
								result[m] = 'R';
							} else if (m > (double)(i + j) / 2) {
								result[m] = 'L';
							}
						}
						break;
					}
				}
			} else if (result[i] == 'R' && i != result.length - 1) {
				for (int j = i + 1; j < result.length; j++) {
					if (result[j] == 'R' || (result[j] == '.' && j == result.length - 1)) {
						for (int m = i; m < j + 1; m++) {
							result[m] = 'R';
						}
						i = j - 1;
						break;
					} else if (result[j] == 'L') {
						for (int m = i + 1; m < j; m++) {
							if (m < (double)(i + j) / 2) {
								result[m] = 'R';
							} else if (m > (double)(i + j) / 2) {
								result[m] = 'L';
							}
						}
						i = j - 1;
						break;
					}
				}
				
			}
		}
		return String.valueOf(result);
	}
}

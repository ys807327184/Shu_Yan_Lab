package Challenges;
/*
Date: 7 September 2021
Challenge: Palindrome Number
	Given an integer x, return true if x is palindrome integer.
	An integer is a palindrome when it reads the same backward as forward. For example, 121 is palindrome while 123 is not.
	Example 1:
		Input: x = 121
		Output: true
	Example 2:
		Input: x = -121
		Output: false
		Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
	Example 3:
		Input: x = 10
		Output: false
		Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
	Example 4:
		Input: x = -101
		Output: false
 	Constraints:
		-2^31 <= x <= 2^31 - 1
Developed by: Shu Yan
 */
public class Challenge_09 {
	public boolean isPalindrome(int x) {
		//Version 1 Simplest Approach
		/*
		if (x < 0) return false;
		else if (x >= 0 && x < 10) return true;
		else {
			char[] arr = String.valueOf(x).toCharArray();
			for (int i = 0; i < arr.length - 1 - i; i++) {
				if (arr[i] != arr[arr.length - 1 - i]) {
					return false;
				}
			}
			return true;
		}
		*/
		//Version 2 Genius Approach
		if (x < 0 || x % 10 == 0 && x != 0) return false;
		int reverse = 0;
		while (x > reverse) {
			reverse = reverse * 10 + x % 10;
			x /= 10;
		}
		return x == reverse || x == reverse / 10;
	}
}

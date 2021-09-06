package Challenges;
/*
Date: 6 September 2021
Challenge: Reverse Integer
	Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
	Assume the environment does not allow you to store 64-bit integers (signed or unsigned).
	Example 1:
		Input: x = 123
		Output: 321
	Example 2:
		Input: x = -123
		Output: -321
	Example 3:
		Input: x = 120
		Output: 21
	Example 4:
		Input: x = 0
		Output: 0
 	Constraints:
		-2^31 <= x <= 2^31 - 1
Developed by: Shu Yan
 */
public class Challenge_07 {
	//Version 1 Simplest Approach
	/*
	public int reverse(int x) {
		if (x < 10 && x > -10) return x;
		else {
			String xstr = String.valueOf(Math.abs(x));
			char[] xchar = xstr.toCharArray();
			int length = xchar.length;
			for (int i = xchar.length - 1; i > 0; i--) {
				if (xchar[i] == '0') length--;
				else break;
			}
			char[] resultchar = new char[length];
			for (int i = 0; i < length; i++) {
				resultchar[length - 1 - i] = xchar[i];
			}
			String resultstr = String.valueOf(resultchar);
			try {
				int result = Integer.valueOf(resultstr);
				if (x < 0) return 0 - result;
				else return result;
			} catch (NumberFormatException ex) {
				return 0;
			}
		}
	}
	*/
	//Version 2 Genius Approach
	public int reverse(int x) {
		int result = 0;
		while (x != 0) {
			if (result < -2147483648 / 10 || result > 2147483647 / 10) return 0;
			result = result * 10;
			if ((result == -2147483640 && x % 10 < -8) || (result == 2147483640 && x % 10 > 7)) return 0;
			result = result + (x % 10);
			x /= 10;
		}
		return result;
	}
}

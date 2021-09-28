package Challenges;
/*
Date: 28 September 2021
Challenge: Integer to Roman
 */
public class Challenge_12 {
	public String intToRoman(int num) {
		int[] nums = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
		String[] roman = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
		StringBuilder sb = new StringBuilder();
		for (int i = nums.length - 1; i >= 0; i--) {
			while (num >= nums[i]) {
				sb.append(roman[i]);
				num -= nums[i];
			}
			if (num == 0) {
				break;
			}
		}
		return sb.toString();
	}
}

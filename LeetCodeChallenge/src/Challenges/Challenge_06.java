package Challenges;
/*
Date: 20 September 2021
Challenge: ZigZag Conversion
	The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
	P   A   H   N
	A P L S I I G
	Y   I   R
	And then read line by line: "PAHNAPLSIIGYIR"
	Write the code that will take a string and make this conversion given a number of rows:
		string convert(string s, int numRows);
	Example 1:
		Input: s = "PAYPALISHIRING", numRows = 3
		Output: "PAHNAPLSIIGYIR"
	Example 2:
		Input: s = "PAYPALISHIRING", numRows = 4
		Output: "PINALSIGYAHRPI"
		Explanation:
			P     I    N
			A   L S  I G
			Y A   H R
			P     I
	Example 3:
		Input: s = "A", numRows = 1
		Output: "A"
 	Constraints:
		1 <= s.length <= 1000
		s consists of English letters (lower-case and upper-case), ',' and '.'.
		1 <= numRows <= 1000
 */
public class Challenge_06 {
	public String convert(String s, int numRows) {
		if (numRows == 1 || s.length() <= numRows) return s;
		String[] str = new String[numRows];
		boolean goDown = true;
		int pos = 0;
		for (int i = 0; i < s.length(); i++) {
			if (str[pos] == null) str[pos] = Character.toString(s.charAt(i));
			else str[pos] += s.charAt(i);
			if (pos == 0) goDown = true;
			else if (pos == numRows - 1) goDown = false;
			if (goDown) pos++;
			else pos--;
		}
		String result = "";
		for (int i = 0; i < str.length; i++) {
			result += str[i];
		}
		return result;
	}
}

package Challenges;
/*
Date: 8 September 2021
Challenge: Valid Parentheses
	Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
	An input string is valid if:
		Open brackets must be closed by the same type of brackets.
		Open brackets must be closed in the correct order.
 	Example 1:
		Input: s = "()"
		Output: true
	Example 2:
		Input: s = "()[]{}"
		Output: true
	Example 3:
		Input: s = "(]"
		Output: false
	Example 4:
		Input: s = "([)]"
		Output: false
	Example 5:
		Input: s = "{[]}"
		Output: true
 	Constraints:
		1 <= s.length <= 10^4
		s consists of parentheses only '()[]{}'.
 */
import java.util.*;
public class Challenge_20 {
	//Version 1 Stupid Approach
	/*
	public Map<Character, Character> map = new HashMap<>();
	public void createMap() {
		map.put('(', ')');
		map.put('[', ']');
		map.put('{', '}');
	}
	public boolean isValid(String s) {
		char[] arr = s.toCharArray();
		if (arr.length % 2 != 0) {
			return false;
		}
		createMap();
		if (map.containsKey(arr[0])) {
			if (arr.length == 2) {
				return arr[1] == map.get(arr[0]);
			}
			int indexOfClose = 0;
			for (int i = arr.length - 1; i > 0; i--) {
				if (map.get(arr[0]) == arr[i]) {
					indexOfClose = i;
					break;
				}
			}
			if (indexOfClose == 0) {
				return false;
			} else if (indexOfClose == arr.length - 1) {
				return isValid(String.valueOf(Arrays.copyOfRange(arr, 1, indexOfClose)));
			} else if (indexOfClose == 1) {
				return isValid(String.valueOf(Arrays.copyOfRange(arr, 2, arr.length)));
			} else {
				return isValid(String.valueOf(Arrays.copyOfRange(arr, 1, indexOfClose))) || isValid(String.valueOf(Arrays.copyOfRange(arr, indexOfClose + 1, arr.length)));
			}
		} else return false;
	}
	*/
	//Version 2 Stack Approach
	public boolean isValid(String s) {
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
				stack.push(s.charAt(i));
			} else if (s.charAt(i) == ')') {
				if (stack.isEmpty()) return false;
				if (stack.peek() == '(') stack.pop();
				else return false;
			} else if (s.charAt(i) == ']') {
				if (stack.isEmpty()) return false;
				if (stack.peek() == '[') stack.pop();
				else return false;
			} else if (s.charAt(i) == '}') {
				if (stack.isEmpty()) return false;
				if (stack.peek() == '{') stack.pop();
				else return false;
			}
		}
		return stack.isEmpty();
	}
}

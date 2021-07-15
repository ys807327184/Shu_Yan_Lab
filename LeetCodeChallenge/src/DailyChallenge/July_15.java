package DailyChallenge;
/*
Date: 15 July 2021
Challenge: Custom Sort String
	order and str are strings composed of lowercase letters. In order, no letter occurs more than once.
	order was sorted in some custom order previously. We want to permute the characters of str so that they match the order that order was sorted. More specifically, if x occurs before y in order, then x should occur before y in the returned string.
	Return any permutation of str (as a string) that satisfies this property.
	Example:
		Input: 
			order = "cba"
			str = "abcd"
		Output: "cbad"
	Explanation: 
		"a", "b", "c" appear in order, so the order of "a", "b", "c" should be "c", "b", and "a". 
		Since "d" does not appear in order, it can be at any position in the returned string. "dcba", "cdba", "cbda" are also valid outputs.
 	Note:
		order has length at most 26, and no character is repeated in order.
		str has length at most 200.
		order and str consist of lowercase letters only.
Developed by: Shu Yan
*/
import java.util.HashMap;
public class July_15 {
	//Version 1 Wrong Answer
	/*public String customSortString(String order, String str) {
		HashMap<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < order.length(); i++) {
			map.put(order.charAt(i), i);
		}
		Character temp;
		for (int i = 0; i < str.length(); i++) {
			if (map.containsKey(str.charAt(i))) {
				temp = str.charAt(map.get(str.charAt(i)));
				str = str.replace(temp, str.charAt(i));
				str = str.replace(str.charAt(i), temp);
			}
		}
		return str;
	}*/
	//Version 2 Unable to sort repeating character
	/*public String customerSortString(String order, String str) {
		HashMap<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < order.length(); i++) {
			map.put(order.charAt(i), i);
		}
		char sorted[] = new char[str.length()];
		int lastIndex = str.length() - 1;
		for (int i = 0; i < str.length(); i++) {
			if (map.containsKey(str.charAt(i))) {
				if (sorted[map.get(str.charAt(i))] == str.charAt(i)) sorted[map.get(str.charAt(i)) + 1] = str.charAt(i);
				else sorted[map.get(str.charAt(i))] = str.charAt(i);
			} else {
				sorted[lastIndex] = str.charAt(i);
			}
		}
		return new String(sorted);
	}*/
}

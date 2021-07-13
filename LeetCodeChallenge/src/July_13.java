/*
Date: 13 July 2021
Challenge: Isomorphic Strings
	Given two strings s and t, determine if they are isomorphic.
	Two strings s and t are isomorphic if the characters in s can be replaced to get t.
	All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.
	Example 1:
		Input: s = "egg", t = "add"
		Output: true
	Example 2:
		Input: s = "foo", t = "bar"
		Output: false
	Example 3:
		Input: s = "paper", t = "title"
		Output: true
 Constraints:
	1 <= s.length <= 5 * 10^4
	t.length == s.length
	s and t consist of any valid ascii character.
*/
import java.util.HashMap;
import java.util.Map;
public class July_13 {
	//Version 1 Convert s to a new string using map and compare to t
	/*
	public boolean isIsomorphic(String s, String t) {
		Map<Character, Character> map = new HashMap<>();
		String str = new String();
		for (int i = 0; i < s.length(); i++) {
			if (! map.containsKey(s.charAt(i)) && ! map.containsValue(t.charAt(i))) {
				map.put(s.charAt(i), t.charAt(i));
			}
			str += map.get(s.charAt(i));
		}
		return str.equals(t);
	}
	*/
	//Version 2 Compare during mapping
	public boolean isIsomorphic(String s, String t) {
		HashMap<Character, Character> map = new HashMap<>();
		for (int i = 0; i < s.length(); i ++) {
			if (map.containsKey(s.charAt(i))) {
				if (map.get(s.charAt(i)) != t.charAt(i)) return false;
			} else {
				if (map.containsValue(t.charAt(i))) return false;
				map.put(s.charAt(i), t.charAt(i));
			}
		}
		return true;
	}
}

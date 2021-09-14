package DailyChallenge;
/*
Date: 14 September 2021
Challenge: Maximum Number of Balloons
	Given a string text, you want to use the characters of text to form as many instances of the word "balloon" as possible.
	You can use each character in text at most once. Return the maximum number of instances that can be formed.
	Example 1:
		Input: text = "nlaebolko"
		Output: 1
	Example 2:
		Input: text = "loonbalxballpoon"
		Output: 2
	Example 3:
		Input: text = "leetcode"
		Output: 0
	Constraints:
		1 <= text.length <= 10^4
		text consists of lower case English letters only.
Developed by: Shu Yan
 */
import java.util.*;
public class September_14_2021 {
	public int maxNumberOfBalloons(String text) {
		Map<Character, Integer> map = new HashMap<>();
		map.put('b', 0);
		map.put('a', 0);
		map.put('l', 0);
		map.put('o', 0);
		map.put('n', 0);
		
		for (int i = 0; i < text.length(); i++) {
			if (map.containsKey(text.charAt(i))) {
				map.put(text.charAt(i), map.get(text.charAt(i)) + 1);
			}
		}
		
		int max = map.get('b');
		max = Math.min(max, map.get('a'));
		max = Math.min(max, map.get('l') / 2);
		max = Math.min(max, map.get('o') / 2);
		max = Math.min(max, map.get('n'));
		return max;
	}
}

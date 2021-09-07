package DailyChallenge;
/*
Date: 7 September 2021
Challenge: Slowest Key
	A newly designed keypad was tested, where a tester pressed a sequence of n keys, one at a time.
	You are given a string keysPressed of length n, where keysPressed[i] was the ith key pressed in the testing sequence, and a sorted list releaseTimes, where releaseTimes[i] was the time the ith key was released. Both arrays are 0-indexed. The 0th key was pressed at the time 0, and every subsequent key was pressed at the exact time the previous key was released.
	The tester wants to know the key of the keypress that had the longest duration. The ith keypress had a duration of releaseTimes[i] - releaseTimes[i - 1], and the 0th keypress had a duration of releaseTimes[0].
	Note that the same key could have been pressed multiple times during the test, and these multiple presses of the same key may not have had the same duration.
	Return the key of the keypress that had the longest duration. If there are multiple such keypresses, return the lexicographically largest key of the keypresses.
	Example 1:
		Input: releaseTimes = [9,29,49,50], keysPressed = "cbcd"
		Output: "c"
		Explanation: The keypresses were as follows:
			Keypress for 'c' had a duration of 9 (pressed at time 0 and released at time 9).
			Keypress for 'b' had a duration of 29 - 9 = 20 (pressed at time 9 right after the release of the previous character and released at time 29).
			Keypress for 'c' had a duration of 49 - 29 = 20 (pressed at time 29 right after the release of the previous character and released at time 49).
			Keypress for 'd' had a duration of 50 - 49 = 1 (pressed at time 49 right after the release of the previous character and released at time 50).
			The longest of these was the keypress for 'b' and the second keypress for 'c', both with duration 20.
			'c' is lexicographically larger than 'b', so the answer is 'c'.
	Example 2:
		Input: releaseTimes = [12,23,36,46,62], keysPressed = "spuda"
		Output: "a"
		Explanation: The keypresses were as follows:
			Keypress for 's' had a duration of 12.
			Keypress for 'p' had a duration of 23 - 12 = 11.
			Keypress for 'u' had a duration of 36 - 23 = 13.
			Keypress for 'd' had a duration of 46 - 36 = 10.
			Keypress for 'a' had a duration of 62 - 46 = 16.
			The longest of these was the keypress for 'a' with duration 16.
 	Constraints:
		releaseTimes.length == n
		keysPressed.length == n
		2 <= n <= 1000
		1 <= releaseTimes[i] <= 10^9
		releaseTimes[i] < releaseTimes[i+1]
		keysPressed contains only lowercase English letters.
Developed by: Shu Yan
 */
public class September_07_2021 {
	//Version 1
	/*
	public char slowestKey(int[] releaseTimes, String keysPressed) {
		if (releaseTimes.length == 1) return keysPressed.charAt(0);
		
		int longest = releaseTimes[0];
		char result = keysPressed.charAt(0);
		for (int i = 1; i < releaseTimes.length; i++) {
			if (longest < releaseTimes[i] - releaseTimes[i - 1]) {
					longest = releaseTimes[i] - releaseTimes[i - 1];
					result = keysPressed.charAt(i);
			} else if (longest == releaseTimes[i] - releaseTimes[i - 1]){
				if (result < keysPressed.charAt(i)) {
					result = keysPressed.charAt(i);
				}
			}
		}
		return result;
	}
	*/
	//Version 2
	public char slowestKey(int[] releaseTimes, String keysPressed) {
		if (releaseTimes.length == 1) return keysPressed.charAt(0);
		
		char[] keys = keysPressed.toCharArray();
		int duration = 0;
		int longest = releaseTimes[0];
		char result = keys[0];
		
		for (int i = 1; i < keys.length; i++) {
			duration = releaseTimes[i] - releaseTimes[i - 1];
			if (duration > longest) {
				longest = duration;
				result = keys[i];
			} else if (duration == longest) {
				if (keys[i] > result) {
					result = keys[i];
				}
			}
		}
		return result;
	}
}

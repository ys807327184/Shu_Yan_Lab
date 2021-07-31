package DailyChallenge;
/*
Date: 31 July 2021
Challenge: Map Sum Pairs
	Implement the MapSum class:
		MapSum() Initializes the MapSum object.
		void insert(String key, int val) Inserts the key-val pair into the map. If the key already existed, the original key-value pair will be overridden to the new one.
		int sum(string prefix) Returns the sum of all the pairs' value whose key starts with the prefix.
	Example 1:
		Input
			["MapSum", "insert", "sum", "insert", "sum"]
			[[], ["apple", 3], ["ap"], ["app", 2], ["ap"]]
		Output
			[null, null, 3, null, 5]
	Explanation
		MapSum mapSum = new MapSum();
		mapSum.insert("apple", 3);  
		mapSum.sum("ap");           // return 3 (apple = 3)
		mapSum.insert("app", 2);    
		mapSum.sum("ap");           // return 5 (apple + app = 3 + 2 = 5)
 	Constraints:
		1 <= key.length, prefix.length <= 50
		key and prefix consist of only lowercase English letters.
		1 <= val <= 1000
		At most 50 calls will be made to insert and sum.
 */
import java.util.*;
public class July_31 {
	
	private Map<String, Integer> map;
	
	public July_31() {//refers to MapSum()
		map = new HashMap<String, Integer>();
	}
	
	public void insert(String key, int val) {
		map.put(key, val);
	}
	
	public int sum(String prefix) {
		int result = 0;
		for (String str : map.keySet()) {
			if (str.length() < prefix.length()) continue;
			if (str.substring(0, prefix.length()).equals(prefix)) result += map.get(str);
		}
		return result;
	}
}

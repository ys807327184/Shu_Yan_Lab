package DailyChallenge;
/*
Date: 27 August 2021
Challenge: Verify Preorder Serialization of a Binary Tree
	One way to serialize a binary tree is to use preorder traversal. When we encounter a non-null node, we record the node's value. If it is a null node, we record using a sentinel value such as '#'.
	For example, the above binary tree can be serialized to the string "9,3,4,#,#,1,#,#,2,#,6,#,#", where '#' represents a null node.
	Given a string of comma-separated values preorder, return true if it is a correct preorder traversal serialization of a binary tree.
	It is guaranteed that each comma-separated value in the string must be either an integer or a character '#' representing null pointer.
	You may assume that the input format is always valid.
	For example, it could never contain two consecutive commas, such as "1,,3".
	Note: You are not allowed to reconstruct the tree.
	Example 1:
		Input: preorder = "9,3,4,#,#,1,#,#,2,#,6,#,#"
		Output: true
	Example 2:
		Input: preorder = "1,#"
		Output: false
	Example 3:
		Input: preorder = "9,#,#,1"
		Output: false
 	Constraints:
		1 <= preorder.length <= 10^4
		preorder consist of integers in the range [0, 100] and '#' separated by commas ','.
Developed by: Shu Yan
 */
public class August_27_2021 {
	public boolean isValidSerialization(String preorder) {
		//Version 1 Focus on numbers of values and hashes only
		/*
		if ((preorder.charAt(0) == '#' && preorder.length() != 1) || preorder.charAt(preorder.length() - 1) != '#') return false;
		int values = 0;
		int hashes = 0;
		for (int i = 0; i < preorder.length(); i++) {
			if (preorder.charAt(i) == '#') hashes++;
			else if (preorder.charAt(i) != '#' && preorder.charAt(i) != ',') values++;
		}
		if (values == hashes - 1) return true;
		else return false;
		*/
		preorder += ',';
		int req = 1;
		for (int i = 0; i < preorder.length(); ++i) {
			while (preorder.charAt(i) != ',') ++i;
			if (preorder.charAt(i - 1) == '#') --req;
			else ++req;
			if (req < 0) return false;
			if (req == 0 && i != preorder.length() - 1) return false;
		}
		if (req == 0) return true;
		return false;
	}
}

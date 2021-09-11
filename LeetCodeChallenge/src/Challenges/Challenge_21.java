package Challenges;
/*
Date: 8 September 2021
Challenge: Merge Two Sorted Lists
	Merge two sorted linked lists and return it as a sorted list. The list should be made by splicing together the nodes of the first two lists.
	Example 1:
		Input: l1 = [1,2,4], l2 = [1,3,4]
		Output: [1,1,2,3,4,4]
	Example 2:
		Input: l1 = [], l2 = []
		Output: []
	Example 3:
		Input: l1 = [], l2 = [0]
		Output: [0]
 	Constraints:
		The number of nodes in both lists is in the range [0, 50].
		-100 <= Node.val <= 100
		Both l1 and l2 are sorted in non-decreasing order.
Developed by: Shu Yan
 */
public class Challenge_21 {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode result, curr, temp;
		if (l1 == null && l2 == null) {
			return l1;
		} else if (l1 == null && l2 != null) {
			return l2;
		} else if (l1 != null && l2 == null) {
			return l1;
		} else if (l1.val > l2.val) {
			result = l2;
			l2 = l2.next;
		} else {
			result = l1;
			l1 = l1.next;
		}
		curr = result;
		while (true) {
			if (l1 == null && l2 != null) {
				curr.next = l2;
				break;
			} else if (l1 != null && l2 == null) {
				curr.next = l1;
				break;
			} else if (l1 == null & l2 == null){
				break;
			} else if (l1.val > l2.val) {
				curr.next = l2;
				l2 = l2.next;
				curr = curr.next;
			} else {
				curr.next = l1;
				l1 = l1.next;
				curr = curr.next;
			}
		}
		return result;
	}
}

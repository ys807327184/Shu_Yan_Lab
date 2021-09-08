package DailyChallenge;
/*
Date: 8 September 2021
Challenge: Reverse Linked List
	Given the head of a singly linked list, reverse the list, and return the reversed list.
	Example 1:
		Input: head = [1,2,3,4,5]
		Output: [5,4,3,2,1]
	Example 2:
		Input: head = [1,2]
		Output: [2,1]
	Example 3:
		Input: head = []
		Output: []
 	Constraints:
		The number of nodes in the list is the range [0, 5000].
		-5000 <= Node.val <= 5000
 */
public class September_08_2021 {
	public ListNode reverseList(ListNode head) {
		ListNode curr = head, prev = null, next = null;
		while (curr != null) {
			next = curr.next;
			if (prev != null) curr.next = prev;
			if (prev == head) prev.next = null;
			prev = curr;
			curr = next;
		}
		return prev;
	}
}

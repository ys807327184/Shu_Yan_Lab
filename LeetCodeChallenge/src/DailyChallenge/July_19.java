package DailyChallenge;
/*
Date: 19 July 2021
Challenge: Reverse Nodes in k-Group
	Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
	k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.
	You may not alter the values in the list's nodes, only nodes themselves may be changed.
	Example 1:
		Input: head = [1,2,3,4,5], k = 2
		Output: [2,1,4,3,5]
	Example 2:
		Input: head = [1,2,3,4,5], k = 3
		Output: [3,2,1,4,5]
	Example 3:
		Input: head = [1,2,3,4,5], k = 1
		Output: [1,2,3,4,5]
	Example 4:
		Input: head = [1], k = 1
		Output: [1]
 	Constraints:
		The number of nodes in the list is in the range sz.
		1 <= sz <= 5000
		0 <= Node.val <= 1000
		1 <= k <= sz
*/
public class July_19 {
	public ListNode reverseKGroup(ListNode head, int k) {
		ListNode curr = head;
		//check if linked list is long enough to reverse
		for (int i = 1; i < k && curr != null; i++) curr = curr.next;
		if (curr == null) return head;
		//reverse current k-nodes-long linked list
		ListNode next = curr.next;
		curr.next = null;
		ListNode reversed = reverse(head);
		//reverse next k-nodes-long linked list
		head.next = reverseKGroup(next, k);
		return reversed;
	}
	public ListNode reverse(ListNode head) {
		ListNode curr = head, prev = null, next = null;
		while (curr != null) {
			next = curr.next;
			if (prev != null) curr.next = prev;
			prev = curr;
			curr = next;
		}
		return prev;
	}
}

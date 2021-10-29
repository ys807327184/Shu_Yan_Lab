"""
Date: 11 October 2021
Challenge: Remove Nth Node From End of List
    Given the head of a linked list, remove the nth node from the end of the list and return its head.
    Example 1:
        Input: head = [1,2,3,4,5], n = 2
        Output: [1,2,3,5]
    Example 2:
        Input: head = [1], n = 1
        Output: []
    Example 3:
        Input: head = [1,2], n = 1
        Output: [1]
    Constraints:
        The number of nodes in the list is sz.
        1 <= sz <= 30
        0 <= Node.val <= 100
        1 <= n <= sz
Developed by: Shu Yan
"""
from typing import Optional
class ListNode:
    def __init__(self, val = 0, next = None):
        self.val = val
        self.next = next
class Solution:
    def removeNthFromEnd(self, head: Optional[ListNode], n: int) -> Optional[ListNode]:
        if head.next is None:
            return None
        curr = head
        length = 0
        while curr:
            length += 1
            curr = curr.next
        if length == n:
            head = head.next
            return head
        cut = head
        for i in range(length - n - 1):
            cut = cut.next
        if cut.next.next is None:
            cut.next = None
            return head
        cut.next = cut.next.next
        return head
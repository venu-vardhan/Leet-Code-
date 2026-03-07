/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Create a dummy node to handle edge cases, such as removing the head node
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;

        // Move the first pointer n+1 steps forward to create the gap
        for (int i = 1; i <= n + 1; i++) {
            if (first != null) {
                first = first.next;
            } else {
                // Handle cases where n is larger than the list size (though constraints usually prevent this)
                return head; 
            }
        }

        // Move both pointers until the first pointer reaches the end of the list
        while (first != null) {
            first = first.next;
            second = second.next;
        }

        // The second pointer is now at the node before the one to be removed. 
        // Skip the target node by updating the next pointer.
        second.next = second.next.next;

        // Return the new head of the list (which is dummy.next)
        return dummy.next;
    }
}

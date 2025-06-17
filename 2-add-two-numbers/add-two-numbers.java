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

// Definition for singly-linked list.
// class ListNode {
//     int val;
//     ListNode next;
    
//     ListNode() {}
//     ListNode(int val) { this.val = val; }
//     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
// }

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Dummy node to start the result list
        ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead;

        int carry = 0;

        // Traverse both lists
        while (l1 != null || l2 != null) {
            // Get values or 0 if null
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;

            // Add current digits with carry
            int sum = x + y + carry;

            // Update carry
            carry = sum / 10;

            // Create new node with remainder and link it
            current.next = new ListNode(sum % 10);
            current = current.next;

            // Move to next nodes
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        // If carry remains
        if (carry > 0) {
            current.next = new ListNode(carry);
        }

        // Return the head of the resulting list
        return dummyHead.next;
    }
}

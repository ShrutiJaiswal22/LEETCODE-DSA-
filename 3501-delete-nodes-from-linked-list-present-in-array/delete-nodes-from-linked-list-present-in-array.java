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
import java.util.*;

class Solution {
    public ListNode modifiedList(int[] nums, ListNode head) {
        // Step 1: Store nums in a HashSet for O(1) lookup
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        // Step 2: Create a dummy node to handle removals easily
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // Step 3: Traverse and remove matching nodes
        ListNode current = dummy;
        while (current.next != null) {
            if (set.contains(current.next.val)) {
                // Skip the node
                current.next = current.next.next;
            } else {
                // Move forward
                current = current.next;
            }
        }

        // Step 4: Return the new head
        return dummy.next;
    }
}

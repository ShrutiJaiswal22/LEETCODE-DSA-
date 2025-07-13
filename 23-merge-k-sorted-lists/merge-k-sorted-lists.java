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
    public ListNode mergeKLists(ListNode[] lists) {
        // Edge case
        if (lists == null || lists.length == 0) return null;

        // PriorityQueue to get minimum value node at top
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);

        // Add the head of all non-null lists into the heap
        for (ListNode node : lists) {
            if (node != null)
                minHeap.add(node);
        }

        // Dummy node to build the result list
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while (!minHeap.isEmpty()) {
            ListNode node = minHeap.poll(); // extract smallest node
            current.next = node; // add it to result
            current = current.next;

            if (node.next != null) {
                minHeap.add(node.next); // push next node from same list
            }
        }

        return dummy.next;
    }
}

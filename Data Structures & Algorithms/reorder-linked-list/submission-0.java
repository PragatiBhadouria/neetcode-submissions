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
    public void reorderList(ListNode head) {

        if (head == null || head.next == null) {
            return;
        }

        // 1. Find middle
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 2. Reverse second half
        ListNode prev = null;

        while (slow != null) {
            ListNode next = slow.next;

            slow.next = prev;
            prev = slow;
            slow = next;
        }

        // prev = head of reversed second half

        // 3. Reorder
        ListNode curr = head;

        while (prev.next != null) {

            ListNode tempCurrent = curr.next;
            ListNode tempPrev = prev.next;

            curr.next = prev;
            prev.next = tempCurrent;

            curr = tempCurrent;
            prev = tempPrev;
        }
    }
}

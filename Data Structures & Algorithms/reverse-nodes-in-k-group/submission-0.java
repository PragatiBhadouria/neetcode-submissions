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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;
        ListNode prev = null;

        while(temp != null) {
            ListNode kthNode = getKthNode(temp, k);
            if(kthNode == null){
                if(prev != null) prev.next = temp;
                break;
                }

            ListNode nextNode = kthNode.next;
            kthNode.next = null;
            reverseNode(temp);
            if(temp == head){
                head = kthNode;
            } else {
                prev.next = kthNode;
            }
            prev = temp;
            temp = nextNode;

        }
        return head;
        
    }

    public ListNode reverseNode(ListNode temp) {
        ListNode curr = temp;
        ListNode prev = null;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev.next;
    }

    public ListNode getKthNode(ListNode kthNode, int k) {
        k -= 1;
        while(kthNode != null && k>0) {
            kthNode = kthNode.next;
            k--;
        }
        return kthNode;
    }
}

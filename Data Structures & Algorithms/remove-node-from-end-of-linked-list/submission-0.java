/*
edge case - if head is null

optimal solution - fast and slow pointer technique
1. create two pointers, both at dummy
2. first move fast pointer n times
3. then move slow, fast 1-1 step
4. now, slow.next will be node, that need to remove
5. slow.next = slow.next.next
6. return dummy.next

TC - O(n)
SC - O(1)
*/

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
        //create dummy node
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        //create fast and slow 
        ListNode slow = dummy;
        ListNode fast = dummy;

        //move fast n times
        for(int i = 0; i <= n; i++){
            fast = fast.next;
        }

        //move both slow and fast
        while(fast != null){
            slow = slow.next;
            fast = fast.next;
        }

        //remove node
        slow.next = slow.next.next;

        return dummy.next;
    }
}

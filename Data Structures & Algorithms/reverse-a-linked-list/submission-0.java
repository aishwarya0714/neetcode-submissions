/*
edge case -

bruteforcr - Stack
1. add each node to stack one by one
2. pop out each node and form linkedlist
3. as Stack follows LIFO will get reversed linkedlist
TC - O(n)
SC - O(1)

optimal - Three pointer interation approach
1. ill use Three pointer interation approach
2. take 3 pointers - prev, curr, next
3. initialize prev = null, curr = head
4. while itrating, take temp node as next pass curr.next to it
5. change curr.next = prev it will brek the chain and pointer backward
6. now shift prev = curr and curr = next
7. return prev it will be head of reversed likedlist

TC - O(1)
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
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while(curr!=null){

            //temp node
            ListNode next = curr.next;
            curr.next = prev; //this will breck the chain

            prev = curr;
            curr = next;
        }

        return prev;
    }
}

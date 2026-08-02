/*
edge case - head is null 

optimal - 
1. find the mid - slow anf fast pointer
2. reverse the second half
3. merge both halves

TC = O(n)
SC = O(1)
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
    public void reorderList(ListNode head) {
        //edge case
        if(head == null || head.next == null) return;

        //step 1 = find the mid - slow and fast pointer
        ListNode slow = head;
        ListNode fast = head;

        //start iteration
        while(fast.next != null && fast.next.next != null){
            //move the pointers
            slow = slow.next;
            fast = fast.next.next;
        } 
        // slow = mid

        //Step 2 = Reverse the second half
        //we have found the mid, its next will be head of second half to reverse
        ListNode second = slow.next; //4

        //need to breck the list
        slow.next = null;      //0->1->2->3->null / 4->5->6

        //to reverse second half, need prev node
        ListNode prev = null; 

        //start iteration
        while(second != null){
            //take out next 
            ListNode next = second.next; //5

            second.next = prev;  // prev <- 4 <- 5 <- 6

            //move points
            prev = second;
            second = next;
        }

        //prev = head of reverse list 6->5->4

        //Step 3 = merger both 
        //f = 0->1->2->3
        //s = 6->5->4

        //tow point at both head
        ListNode first = head;
        ListNode sec = prev;

        //start iteration
        while(sec != null){
            //take out next nodes
            ListNode firstNext = first.next;
            ListNode secNext = sec.next;

            first.next = sec; //0 -> 6 -> 1
            sec.next = firstNext; 

            //move pointers
            first = firstNext;
            sec = secNext;
        }

    }
}

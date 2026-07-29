/*
edge case - 
if head = null
return false;

bruteforce - Use HashSet
1. stroe all element in set
2. if node already in set there is cycle
3. return true
TC - O(n)
SC- O(1)

Optimal - 2 Pointer
1. create 2 pointers, slow and fast
2. slow pointer move 1 step
3. fast pointer move 2 step
4. if fast pointer ctach up with slow, there is cycle, return true
5. when fast = null return false, no cycle
TC - O(n)
sc - O(1)
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
    public boolean hasCycle(ListNode head) {
        //create 2 pointer
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            //move slow pointer
            slow = slow.next;

            //move fast pointer
            fast = fast.next.next;

            //if both met, cycle detected
            if(slow == fast){
                return true;
            }
        }

        return false;
    }
}

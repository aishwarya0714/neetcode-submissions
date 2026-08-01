/*
edge cases-
lists can be empty

brutforce - ArrayList
1. store all nodes in arraylist
2. sort it
3. create new linkedlist from it

TC - O(n log n)
SC - O(n)

==================================================

Optimal Solution - minHeap priority queue
1. ill use priority queue minHeap
2. store all heads of each list in it
3. create dummy node initialize it with -1
4. create curr node initialize it with dummy
5. take out samllest from pq
6. make it curr.next
7. make curr = curr.next
8. after polling node, check its next add it to pq for processing
9. when qp become empty, i have processed all nodes
10. return dummy.next

TC - O(n log k)
SC - O(k)
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
    public ListNode mergeKLists(ListNode[] lists) {
        //create min heap
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val - b.val);

        //store all heads of list
        for(ListNode node : lists){
            if(node != null){
                pq.offer(node);
            }
        }

        //create dummy node and curr pointer
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        //start iteration
        while(!pq.isEmpty()){
             //new node to store smallers
        ListNode smallest = pq.poll();

        curr.next = smallest;
        curr = curr.next;

        //check if node has next
        if(smallest.next != null){
            pq.offer(smallest.next);
        }
        }
       
       return dummy.next;
    }
}

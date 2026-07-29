/*
edge case- 
both lists are null return null

bruteforce - 
1. create arraylist
2. store all nodes in it
3. sort arraylist
4. create new linkedlist from arraylist
TC - O(n+m)log(n+m)
SC = O(n+m)
ArrayList<ListNode> arrlist = new ArrayList<>();

        ListNode currNode1 = list1;
        ListNode currNode2 = list2;

        while(currNode1 != null){
            arrlist.add(currNode1);
            currNode1 = currNode1.next;
        }

        while(currNode2 != null){
            arrlist.add(currNode2);
            currNode2 = currNode2.next;
        }

        Collections.sort(arrlist);
=====================================================================        

optimal - two pointer / 3 pointer interative approach
1. ill create 3 points, curr, remaing to at head of each list
2. create dummy node
3. initialize curr = dummy
4. start while loop, compare both heads of list
5. if list1.val <= list2.val - curr.next = list1 else curr.next = list2;
6. also move all three pointer forward, list = list.next/list2 = list2.next
    and curr = curr.next
7. if any one list completes -> curr.next = (list1 != null) ? list1 : list2;
8. return dummy.next;

TC - O(n+m)
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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        //create dummy and curr node
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        //start iteration
        while(list1 != null && list2 != null){

            //comare both node
            if(list1.val <= list2.val){
                curr.next = list1;
                list1 = list1.next;
            }else{
                curr.next = list2;
                list2 = list2.next;
            }
            curr = curr.next;
        }

        //if any list complete
        curr.next = (list1 != null) ? list1 : list2;

        return dummy.next;

        
    }
}
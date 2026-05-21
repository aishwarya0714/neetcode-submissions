/*
edge cases/ assumptions-
1. array can be empty
2. array have only one element
===================================
bruteforce-
bf approach woulld be checking all possible ways, comapring each element with all other element,
for that will require 2 nested loops,
TC - O(n^2)
SC - O(1)
======================================
Optimal approach-
using hashset- keep adding element in set and check if any element already present or not 
if present return true else return false
TC - O(n) - adding n elements in arraya and check is duplicate prasent
SC - O(n) - adding n elements in array

*/

class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for(int i = 0; i< nums.length; i++){
            if(set.contains(nums[i])){
                return true;
            }

            set.add(nums[i]);
        }

        return false;
    }
}
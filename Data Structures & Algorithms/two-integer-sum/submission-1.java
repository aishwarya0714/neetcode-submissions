/*
edge cases/assumption
1. nums is empty
2. target is 0

brute forece -
1. using nested loops
2. looking for all possible pairs
3. in outer loop for each ith element will take inner loops jth value add up them 
    and compare with target
4. if addition and target same will return indices
TC - nested loop - O(n^2)
SC - O(1) - no extra space used
* INIFFICIENT *

Optimal - HashMap + compliment 
1. Hashmap will store value and its index
2. compliment = target - i 
3. look for compliment in map
4. if present we got 2 indices/ answer
TC - O(n) - hashmap takes O(1) avg time for lookup and to strore elements
            iterating n element form array
SC - O(n) - storing n elements in map

*/
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i = 0;i < nums.length; i++){
            int compliment = target - nums[i];

            if(map.containsKey(compliment)){
                return new int[]{map.get(compliment),i};
            }

            map.put(nums[i],i);
        }

        return new int[]{};
    }
}

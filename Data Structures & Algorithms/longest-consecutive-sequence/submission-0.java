/*
edge cases-
nums is empty return 0

bruteforce-
1. for each num check it greater no and keep increasing length
2. return max length
TC - o(n^2) - 2 loops

optimal = HashSet + Strating point
1. ill Use HashSet and store all elem in it, beacause HashSet take O(1) avg
    time for look up
2. traverse set, for each no n check if set contains n - 1, 
    if not means it is a starting point, else skip small nos are already will already counted
3. from string point, get all n+1 no and increase consicutive sequency length
4. return maz length
TC - O(n) - each element visited at most twice
SC - O(n) - set will contain n no

*/

class Solution {
    public int longestConsecutive(int[] nums) {
        //Step1: store all no in set
        HashSet<Integer> set = new HashSet<>();

        for(int num : nums){
            set.add(num);
        }

        int longest = 0;

        //step2 : check for each no
        for(int num : nums){

            //check string point
            if(!set.contains(num - 1)){

                int currNum = num;
                int count = 1;

                //get consiqutive sequece
                while(set.contains(currNum + 1)){
                    currNum++;
                    count++;
                }

                longest = Math.max(longest, count);
            }
        }

        return longest;
    }
}

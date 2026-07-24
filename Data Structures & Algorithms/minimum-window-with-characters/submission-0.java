/*
edge case- 
s.lenght() > t.length() return empty string

bruteforce- 
try all possible window
will take upto O(n^2) time

optimal - Sliding Window
1. ill use sliding window, use 2 points to form window left and right
2. create frqMap to store freq of t sting char
3. move right pointer to from window,
4. while moving check frqMap if char needed, increse match count
5. when match count == t.length, we found valid window, update minlen
6. now keep shrinking window from left, to make as samll as possible min window
7. while shrinking check, char needed, if yes dont shrink, keep expanding
8. return final min sunstring

TC - O(n) 
SC - O(1) constant time
*/
class Solution {
    public String minWindow(String s, String t) {
        //edge case 
        if(s.length() < t.length()) return "";

        //left pointer
        int left = 0;

        //min length
        int minLen = Integer.MAX_VALUE;

        //match count
        int matched = 0;

        //staring point of window
        int start = 0;

        //freq Map 
        int[] freq = new int[128];

        for(char ch : t.toCharArray()){
            freq[ch]++;
        }

        //form window
        for(int right = 0; right < s.length(); right++){

            char ch = s.charAt(right);

            //check if char needed
            if(freq[ch] > 0){
                matched ++;
            }

            freq[ch]--;

            //check window form, and shrink window
            while(matched == t.length()){

                if(right - left + 1 < minLen){
                    minLen = right - left + 1;
                    start = left;
                }

                //shrink from left
                char leftChar = s.charAt(left);

                 //add back to freq map
                freq[leftChar]++;

                //check if char needed before shrinking
                if(freq[leftChar] > 0){
                    matched --;
                }
               
                left ++;

            }
            
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start+minLen);
    }
}

/*
edge cases-

bruteforce- tring out all possible wondows

optimal solution - Sliding Window
1. ill use sliding window
2. for each window, im going to keep track of frequency for each char,
    max freq,
3. so the no character needs to replace would be current window length - max freq
4. if this value is greater than k, ill shrink window from left,
5. else ill keep expanding the window and update the max length

TC - O(n) - visiting n character in string
SC - O(1) - constant time, feq arr size is constant - 26
*/

class Solution {
    public int characterReplacement(String s, int k) {
        //freq array 
        int[] freq = new int[26];
        int left = 0;
        int maxFreq = 0;
        int maxLength = 0;

        //iterate each char
        for(int right = 0; right < s.length(); right ++){
            //take freq of char
            freq[s.charAt(right) - 'A']++;

            //update maxFre
            maxFreq = Math.max(maxFreq, freq[s.charAt(right) - 'A']);

            //current window length
            int windowLength = right - left + 1;

            //if windowLength - maxFreq > k
            if(windowLength - maxFreq > k){
                freq[s.charAt(left) - 'A']--;
                left++;
            }
            
            windowLength = right - left + 1;
            maxLength = Math.max(maxLength, windowLength);
        }
        return maxLength;
    }
}

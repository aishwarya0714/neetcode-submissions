/*
edge case - 
if s is null, return 0

optimal approach - Sliding Window + HashMap + Two Pointer
1, ill use Sliding Window 
2. ill take two pointers, starting at 0th index
3. keep moving right pointer to form window
4. while moving add char and index in map, and keep track of window length
    with right - left + 1
5. while adding check if char is already present in map.
6. if yes, move left pointer left + 1
7. at the end return maxLength

TC - O(n) - visiting each index at most twice, by right and left pointers
SC - O(n) - storing upto n char in map

*/
class Solution {
    public int lengthOfLongestSubstring(String s) {
        //HashMap - char : index
        HashMap<Character, Integer> map = new HashMap<>();

        //left pointer
        int left = 0;

        //max lenght
        int maxLength = 0;

        //start iteration
        for(int right = 0; right < s.length(); right ++){
            char curr = s.charAt(right);

            //check map
            if(map.containsKey(curr)){
                left = Math.max(left, map.get(curr) + 1);
            }

            //add to map
            map.put(curr,right);

            //update maxLength
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}

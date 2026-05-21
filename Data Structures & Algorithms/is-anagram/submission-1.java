/*
edge cases / assumption-
1. s and t of diff length
2. s and t empty
3. s or t empty

approach-

using 2 hash map for storing character and their frequencies
then compare character and frequeny if frequency mismatch or character
not present its not anagram

TC - O(n) - using hashmap
sc - O(n) - storing n elements in map

*/

class Solution {
    public boolean isAnagram(String s, String t) {
        if( s.length() != t.length()) return false;

        HashMap<Character, Integer> map1 = new HashMap<>();
        for(char c : s.toCharArray()){
            map1.put(c,map1.getOrDefault(c,0)+1);
        }

        HashMap<Character, Integer> map2 = new HashMap<>();
        for(char c : t.toCharArray()){
            map2.put(c,map2.getOrDefault(c,0)+1);
        }

        

        for(Map.Entry<Character,Integer> entry : map1.entrySet()){

            if(map2.containsKey(entry.getKey()) && (map1.get(entry.getKey()).equals(map2.get(entry.getKey())))){
                continue;
            }
            else{
                return false;
            }
        }

        return true;
    }
}

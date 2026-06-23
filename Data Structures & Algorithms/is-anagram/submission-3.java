/*
edge cases / assumption-
1. s and t of diff length
2. s and t empty
3. s or t empty
========================================
brutefire approach-
convert string to char arr and sort it
then comapre element and return ture/ false
TC - O(n log n) - sorting
SC - O(n) 
=============================================
Optimal Approach-
using 2 hash map for storing character and their frequencies
then compare character and frequeny if frequency mismatch or character
not present its not anagram
TC - O(n) - using hashmap
sc - O(n) - storing n elements in map
=============================================
better optimal approach-
1. using single hashmap
2. storing s char and frequency
3. traverse t and decrease frequency
4. if char not present or frequency in negative retunr false
TC - O(n) - using hashmap
SC - O(n) - storing n elements in map

*/

class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;

        HashMap<Character,Integer> map = new HashMap<>();

        for(char c : s.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }

        for(char c: t.toCharArray()){
            if(!map.containsKey(c)) return false;

            map.put(c,map.get(c)-1);

            if(map.get(c) < 0) return false;
        }

        return true;

        // HashMap<Character, Integer> map1 = new HashMap<>();
        // for(char c : s.toCharArray()){
        //     map1.put(c,map1.getOrDefault(c,0)+1);
        // }

        // HashMap<Character, Integer> map2 = new HashMap<>();
        // for(char c : t.toCharArray()){
        //     map2.put(c,map2.getOrDefault(c,0)+1);
        // }

        

        // for(Map.Entry<Character,Integer> entry : map1.entrySet()){

        //     if(map2.containsKey(entry.getKey()) && (map1.get(entry.getKey()).equals(map2.get(entry.getKey())))){
        //         continue;
        //     }
        //     else{
        //         return false;
        //     }
        // }

        // return true;
    }
}

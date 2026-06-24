/*
edge cases-
- empty strings
-case sensitive

optimal approach- HashMap = key -> sorted string; value -> list of original strings
1. create hashmap to store sorted sting and its original strings(anagrams) list
 as value
2. traverse strs, take string sort it
3. check if map contains key, yes = add original string in lsit
4. no = create new list with key
5. return all grouped lists with map.values()

TC- O(n * k log k) - n strings with k length, soting takes O(k log k) time
SC- O(n*k) - storing n stirngs of k length in map
*/

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        //key = sorted string; value = orginal strings list
        HashMap<String, List<String>> map = new HashMap<>();

        for(String s : strs){

            //convert string to char array
            char[] chars = s.toCharArray();

            //sort 
            Arrays.sort(chars);

            //store in key string
            String key = new String(chars);

            //check key in map
            if(!map.containsKey(key)){
                map.put(key, new ArrayList<>());
            }

            map.get(key).add(s);
        }

        return new ArrayList<>(map.values());
    }
}

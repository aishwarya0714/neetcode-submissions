/*
edge cases-
1. empty list
2. empty string
3. contains numbers

optimal approach=
1. During encoding->
    - ill use StringBuilder to add each string in it,
    - while adding ill add it length first, then seperator "#" and string
2. During Decoding->
    - ill start fron 0 index and take seperator possition first to extract length
    - after geting length i process exact length character and build string
    - add this string in to result list and move the pointer

TC-> O(N)
    - visiting n strings once 
    - string builder will have N character
SC-> O(N)
    - getting encoded string of N length
    - List will contain N characters 
*/

class Solution {

    public String encode(List<String> strs) {
        //StringBuilder
        StringBuilder s = new StringBuilder();

        //iterate strs and add string to s
        for(String str : strs){
            s.append(str.length())
            .append("#")
            .append(str);
        }

        return s.toString();
    }

    public List<String> decode(String str) {

        //List
        List<String> result = new ArrayList<>();

        //index strts from 0
        int i = 0;

        //iterate 
        while(i < str.length()){

            //get separator possition
            int seperator = str.indexOf("#",i);

            //extract length
            int length = Integer.parseInt(str.substring(i,seperator));

            //move index
            i = seperator + 1;

            //bild string
            String s = str.substring(i,i+length);

            result.add(s); 

            //move forward
            i = i + length;
        }

        return result;

    }
}

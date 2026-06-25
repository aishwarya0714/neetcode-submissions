/*
edge case-
- nums empty
- k = 0

===
optimal approach- Hashmap + minHeap
- Hahsmap- no and frequency
- priorityQueue, minHeap - store no based on frequency
- store k elements in minHeap, k frequent elements
- return result arr

==
tc - O(n log k) - scanning n elements from hashmap, maintaing heap size of k
sc - O(n) - map will store upto n elements and heap will contain upto k elements
*/

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        //map- no + freq
        HashMap<Integer, Integer> map = new HashMap<>();

        //store elem in mao
        for(int num : nums){
            map.put(num, map.getOrDefault(num,0)+1);
        }

        //minHeap
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a,b) -> map.get(a) - map.get(b));

        for(int num : map.keySet()){
            minHeap.add(num);

            if(minHeap.size() > k){
                minHeap.poll();
            }
        }

        //result arr
        int[] result = new int[k];
        for(int i = 0; i<k;i++){
            result[i] = minHeap.poll();
        }

        return result;

    }
}

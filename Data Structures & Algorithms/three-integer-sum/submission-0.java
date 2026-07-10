/*
edge cases-
1. if array is empty or has less than 3 elm return empty list

brutrforce-
- try all possible triplets.
- 3 for loop
tc - O(n^3)

optimal approach - Set + Tw0 Pointer
1. ill sort the array
2. ill create set to store triplets
3. i traverse the sorted array and take the fixed value at each index,
4. for each fixed value, i find remaining to values using two pointer
5. sum up these 3 values and check if its 0
6. if yes add to set and move pointers to find another triplet
7. is sum < 0, move left pointer
8. id sum > 0 mover right pointer
9. return set

TC - O(n^2) for each n fixed value i am goint to find reaming to two values 
    so 

SC - O(1)
*/
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        //edge
        if(nums == null || nums.length < 3) {
            return new ArrayList<>();
        }

        //sort the nums
        Arrays.sort(nums);

        //set to store the triplets
        Set<List<Integer>> result = new HashSet<>();

        //fix value and find remaing two numbers
        for(int i = 0; i< nums.length - 2; i++){
            //two pointers
            int left = i+1;
            int right = nums.length-1;

            //get pair and check sum
            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];

                if(sum == 0){
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left ++;
                    right --;
                }else if(sum < 0){
                    left ++;
                }else{
                    right--;
                }

            }

        }

        return new ArrayList<>(result);
    }
}

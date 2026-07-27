/*
edge case- 
array has only one element

bruteforce - single pass
1. traverse array and find min value
tc - O(n)

optimal - Binary Search
1. as array sorted ill use binary search
2. initialize left, right, min
3. find the sorted part, its left most will be min, errase and apply BS on remaing part
4. if num[left] <= nums[mid], this part is sorted, nums[left] = min
5. else, nums[mid] = min
6. return min

TC - O(log n)
SC - O(1)
*/

class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        int min = Integer.MAX_VALUE;

        while(left <= right){

            int mid = (left + right) / 2;

            if(nums[left] <= nums[mid]){
                min = Math.min(min, nums[left]);
                left = mid + 1;
            }else{
                min = nums[mid];
                right = mid - 1;
            }
        }

        return min;
    }
}

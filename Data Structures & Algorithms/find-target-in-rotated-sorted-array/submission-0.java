/*
edge case-

bruteforce - traverse array and compare each num with trget
TC - O(n)
SC - O(1)

Optimal - Binary Serach
1. ill use binary search, because array is sorted
2. ill initialize left, right, mid
3. find the sorted part, check of taget lies in that part
4. otherwise scan other half
5. return answer

TC - O(log n)
SC - O(1)
*/

class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while(left <= right){

            int mid = (left + right) / 2;

            //mid is target
            if(nums[mid] == target){
                return mid;
            }

            //if left part is sorted
            if(nums[left] <= nums[mid]){
                if(nums[left] <= target && target < nums[mid]){
                    right = mid - 1;
                }
                else{
                    left = mid + 1;
                }
            }
            else{// right half is sorted
                if(nums[mid] < target && target <= nums[right]){
                    left = mid + 1;
                }else{
                    right = mid - 1;
                }
            }
            
        }

        return -1;
    }
}

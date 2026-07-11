/*
edge cases-

bruteforce- try all possible ways
-required 2 for loop
-tc - O(n^2)

Optimal Solution- Two Pointers
1. ill use two pointers
2. start from both the ends,left and right
3. take height as min of both bars
4. take width as distance between both bar, right - left
5. calculate area and store it
6. move pointer with small bar, bcoz it will affect the area
7. repeat till 2 points meet and return max area

TC - O(n) - visit each index once
SC - O(1) - no extra space
*/
class Solution {
    public int maxArea(int[] heights) {

        //2 points
        int left = 0;
        int right = heights.length -1;

        int maxArea = 0;

        while(left < right){
            int height = Math.min(heights[left], heights[right]);
            int width = right - left;

            int area = height * width;

            maxArea = Math.max(maxArea,area);

            //move pointer
            if(heights[left] < heights[right]){
                left ++;
            }else{
                right --;
            }
        }
        return maxArea;
    }
}

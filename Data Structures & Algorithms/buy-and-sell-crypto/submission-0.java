/*
edge cases
1. prices array will containg only one price 
2. array can be empty

bruteforce -
1. try all possible ways
2. for each stock subtract it from all future prices and take profit
3. required 2 leasted loops
TC - O(n^2) - INIFFICIENT

Optimal - Greedy (Single pass)
1. ill traverse array in single go
2. ill imagine each day as selling day
3. for each selling day, ill subtract it from previous min stock prince
    -> previous minimum stock price will be my BestBuyPrice
4. if BestBuyPrice < current selling price, subtract both and get profit
5. ill keep track of max profit with Math.max
6. ill keep track of BestBuyPrice with Math.min
7. return maxProfit at end

TC - O(n) - visiting each stock only once
SC - O(1) - no extra space used

*/

class Solution {
    public int maxProfit(int[] prices) {
        //previous best buy price
        int BestBuyPrice = prices[0];

        //declare Max Profit
        int maxProfit = 0;

        //single pass
        for(int currSellingPrice = 1; currSellingPrice < prices.length; currSellingPrice++){
            if(BestBuyPrice < prices[currSellingPrice]){
                int currProfit = prices[currSellingPrice] - BestBuyPrice;
                maxProfit = Math.max(maxProfit, currProfit);
            }

            //update BestBuyPrice
            BestBuyPrice = Math.min(BestBuyPrice, prices[currSellingPrice]);
        }

        return maxProfit;
    }
}

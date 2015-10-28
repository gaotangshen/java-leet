public class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length==0 || prices==null){
            return 0;
        }
        int profit = 0;
        int min = prices[0];
        for(int i=1; i<prices.length; i++){
            if(min>=prices[i]){
                min = prices[i];
            }
            if(prices[i]-min>profit){
                profit = prices[i]-min;
            }
            
        }
        return profit;
    }
}
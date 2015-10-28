public class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length==0){
            return 0;
        }
        int profits = 0;
        int start = Integer.MAX_VALUE;
        for(int i=0; i<prices.length-1; i++){
            if(prices[i]<start){
                start = prices[i];
            }
            //  System.out.println(start);
            if(prices[i]>=prices[i+1] && prices[i]>start){
                profits += prices[i]-start;
                start=prices[i+1];
                // System.out.println(profits);
                
            }else if(i+1==prices.length-1&&prices[i]<prices[i+1]){
                profits += prices[i+1]-start;
            }
        }
        return profits;
    } 
}
public int maxProfit(int[] prices) {
    int profit = 0;
    for(int i=1; i<prices.length; i++){
        int diff = prices[i]-prices[i-1];
        if(diff > 0){
            profit += diff;
        }
    }
    return profit;
}
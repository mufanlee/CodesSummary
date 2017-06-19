/**
 * 122. Best Time to Buy and Sell Stock II
 * @author LiPeng
 * @since 2017/6/1922:25
 */
public class BestTimetoBuyandSellStockII {
    public int maxProfit(int[] prices) {
        int max = 0;
        for(int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i-1])
                max += prices[i] - prices[i-1];
        }
        return max;
    }
}

/**
 * 121. Best Time to Buy and Sell Stock
 * @author LiPeng
 * @since 2017/6/1723:48
 */
public class BestTimetoBuyandSellStock {
    public int maxProfit(int[] prices) {
        if (prices.length <= 1 || prices == null) return 0;
        int dp[] = new int[prices.length - 1];
        for (int i = 1; i < prices.length; i++)
            dp[i-1] = prices[i] - prices[i-1];
        int res = 0, sum = 0;
        for (int i = 0; i < dp.length; i++) {
            sum += dp[i];
            if (sum < 0)
                sum = 0;
            res = Math.max(res, sum);
        }
        return res;
    }

    public int maxProfit2(int[] prices) {
        int maxcur = 0, maxsofar = 0;
        for (int i = 1; i < prices.length; i++) {
            maxcur = Math.max(0, maxcur += prices[i] - prices[i-1]);
            maxsofar = Math.max(maxcur, maxsofar);
        }
        return maxsofar;
    }

    public int maxProfit3(int[] prices) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice)
                minprice = prices[i];
            else if (prices[i] - minprice > maxprofit)
                maxprofit = prices[i] - minprice;
        }
        return maxprofit;
    }
}

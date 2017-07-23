import java.util.Arrays;
import java.util.Comparator;

/**
 * 646. Maximum Length of Pair Chain
 * @author LiPeng
 * @since 2017/7/2321:10
 */
public class MaximumLengthofPairChain {

    //contest
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0])
                    return o1[1] - o2[1];
                else
                    return o1[0] - o2[0];
            }
        });
        int dp[] = new int[pairs.length];
        dp[0] = 1;
        int max = 1;
        for (int i = 1; i < pairs.length; i++) {
            int j = i-1;
            while (j >= 0 && pairs[j][1] >= pairs[i][0])
                j--;
            if (j == -1) {
                dp[i] = 1;
            } else {
                dp[i] = dp[j] + 1;
            }
            if (dp[i] > max) max = dp[i];
        }
        return max;
    }
}

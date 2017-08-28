/**
 * 63. Unique Paths II
 * @author LiPeng
 * @since 2017/7/2021:07
 */
public class UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int dp[] = new int[obstacleGrid[0].length];
        dp[0] = 1;
        for (int i = 0; i < obstacleGrid.length; i++) {
            for (int j = 0; j < obstacleGrid[i].length; j++) {
                if (obstacleGrid[i][j] == 1)
                    dp[j] = 0;
                else if (j > 0)
                    dp[j] += dp[j-1];
            }
        }
        return dp[obstacleGrid[0].length-1];
    }

    public int uniquePathsWithObstacles2(int[][] obstacleGrid) {
        int dp[][] = new int[obstacleGrid.length][obstacleGrid[0].length];
        int k = 0;
        while (k < obstacleGrid.length && obstacleGrid[k][0] == 0) {
            dp[k++][0] = 1;
        }
        while (k < obstacleGrid.length) {
            dp[k++][0] = 0;
        }
        k = 0;
        while (k < obstacleGrid[0].length && obstacleGrid[0][k] == 0) {
            dp[0][k++] = 1;
        }
        while (k < obstacleGrid[0].length) {
            dp[0][k++] = 0;
        }
        for (int i = 1; i < obstacleGrid.length; i++) {
            for (int j = 1; j < obstacleGrid[0].length; j++) {
                if (obstacleGrid[i][j] == 0) {
                    if (obstacleGrid[i-1][j] == 0) {
                        dp[i][j] += dp[i-1][j];
                    }
                    if (obstacleGrid[i][j-1] == 0) {
                        dp[i][j] += dp[i][j-1];
                    }
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return dp[obstacleGrid.length-1][obstacleGrid[0].length-1];
    }
}

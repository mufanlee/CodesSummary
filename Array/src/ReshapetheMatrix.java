/**
 * 566. Reshape the Matrix
 * @author LiPeng
 * @since 2017/6/1519:45
 */
public class ReshapetheMatrix {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        if (nums == null || nums.length == 0 || nums.length * nums[0].length != r * c)
            return nums;
        int [][]res = new int[r][c];
        int m = 0, n = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                res[m][n++] = nums[i][j];
                if (n == c) {
                    m++;
                    n = 0;
                }
            }
        }
        return res;
    }

    public int[][] matrixReshape2(int[][] nums, int r, int c) {
        int[][] res = new int[r][c];
        if (nums.length == 0 || r * c != nums.length * nums[0].length)
            return nums;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[0].length; j++) {
                res[count / c][count % c] = nums[i][j];
                count++;
            }
        }
        return res;
    }
}

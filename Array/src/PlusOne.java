/**
 * 66. Plus One
 * @author LiPeng
 * @since 2017/6/1421:28
 */
public class PlusOne {
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] == 9)
                digits[i] = 0;
            else {
                digits[i]++;
                return digits;
            }
        }
        int []res = new int[digits.length + 1];
        res[0] = 1;
        return res;
    }
}

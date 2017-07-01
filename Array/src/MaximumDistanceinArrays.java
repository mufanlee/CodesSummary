import java.util.List;

/**
 * 624. Maximum Distance in Arrays
 * @author LiPeng
 * @since 2017/7/120:47
 */
public class MaximumDistanceinArrays {
    public int maxDistance(List<List<Integer>> arrays) {
        int res = Integer.MIN_VALUE;
        int min = arrays.get(0).get(0), max = arrays.get(0).get(arrays.get(0).size() - 1);
        for (int i = 1; i < arrays.size(); i++) {
            res = Math.max(res, Math.max(Math.abs(max - arrays.get(i).get(0)), Math.abs(arrays.get(i).get(arrays.get(i).size() - 1) - min)));
            min = Math.min(min, arrays.get(i).get(0));
            max = Math.max(max, arrays.get(i).get(arrays.get(i).size() - 1));
        }
        return res;
    }
}

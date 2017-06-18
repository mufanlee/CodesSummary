import java.util.ArrayList;
import java.util.List;

/**
 * 119. Pascal's Triangle II
 * @author LiPeng
 * @since 2017/6/1723:39
 */
public class PascalsTriangleII {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++) {
            res.add(0, 1);
            for (int j = 1; j < res.size() - 1; j++)
                res.set(j, res.get(j) + res.get(j+1));
        }
        return res;
    }
}

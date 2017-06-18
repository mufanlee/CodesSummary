import java.util.ArrayList;
import java.util.List;

/**
 * 118. Pascal's Triangle
 * @author LiPeng
 * @since 2017/6/1719:39
 */
public class PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            for(int j = 0; j < i + 1; j++) {
                if(j == 0 || j == i)
                    row.add(1);
                else
                    row.add(res.get(i-1).get(j-1) + res.get(i-1).get(j));
            }
            res.add(row);
        }
        return res;
    }

    public List<List<Integer>> generate2(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        ArrayList<Integer> row = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            row.add(0, 1);
            for (int j = 1; j < row.size() - 1; j++)
                row.set(j, row.get(j) + row.get(j+1));
            res.add(new ArrayList<>(row));
        }
        return res;
    }
}

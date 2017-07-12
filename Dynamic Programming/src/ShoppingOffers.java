import java.util.ArrayList;
import java.util.List;

/**
 * 638. Shopping Offers
 * @author LiPeng
 * @since 2017/7/921:46
 */
public class ShoppingOffers {
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        return shopping(price, special, needs, 0);
    }

    public int shopping(List<Integer> price, List<List<Integer>> special, List<Integer> needs, int i) {
        if (i == special.size()) {
            return dot(price, needs);
        }
        List<Integer> clone = new ArrayList<>(needs);
        int j = 0;
        for (; j < special.get(i).size() - 1; j++) {
            int diff = needs.get(j) - special.get(i).get(j);
            if (diff < 0) break;
            clone.set(j, diff);
        }
        if (j == special.get(i).size() - 1) {
            return Math.min(special.get(i).get(special.get(i).size() - 1)+shopping(price, special, clone, i), shopping(price, special, needs, i+1));
        } else {
            return shopping(price, special, needs, i+1);
        }
    }

    public int dot(List<Integer> price, List<Integer> needs) {
        int sum = 0;
        for (int i = 0; i < needs.size(); i++) {
            sum += needs.get(i) * price.get(i);
        }
        return sum;
    }
}

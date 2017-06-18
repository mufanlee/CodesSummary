import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * 414. Third Maximum Number
 * @author LiPeng
 * @since 2017/6/1718:07
 */
public class ThirdMaximumNumber {
    public int thirdMax(int[] nums) {
        Integer first = null, second = null, third = null;
        for (Integer i : nums) {
            if (i.equals(first) || i.equals(second) || i.equals(third)) continue;
            if (first == null || i > first) {
                third = second;
                second = first;
                first = i;
            } else if (second == null || i > second) {
                third = second;
                second = i;
            } else if (third == null || i > third) {
                third = i;
            }
        }
        return third == null ? first : third;
    }

    public int thirdMax2(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            if (!set.contains(i)) {
                pq.offer(i);
                set.add(i);
                if (pq.size() > 3) {
                    set.remove(pq.poll());
                }
            }
        }
        if (pq.size() < 3) {
            while (pq.size() > 1) {
                pq.poll();
            }
        }
        return pq.peek();
    }
}

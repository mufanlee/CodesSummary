import java.util.HashSet;
import java.util.Set;

/**
 * 645. Set Mismatch
 * @author LiPeng
 * @since 2017/7/2321:06
 */
public class SetMismatch {
    public int[] findErrorNums(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int duplicate = 0, n = nums.length;
        long sum = (n * (n+1)) / 2;
        for(int i : nums) {
            if(set.contains(i)) duplicate = i;
            sum -= i;
            set.add(i);
        }
        return new int[] {duplicate, (int)sum + duplicate};
    }

    // contest
    public int[] findErrorNums2(int[] nums) {
        int[] res = new int[2];
        int[] map = new int[nums.length+1];
        for (int i = 0; i < nums.length; i++) {
            map[nums[i]]++;
        }
        for (int i = 1; i < map.length; i++) {
            if (map[i] == 2)
                res[0] = i;
            if (map[i] == 0)
                res[1] = i;
        }
        return res;
    }
}

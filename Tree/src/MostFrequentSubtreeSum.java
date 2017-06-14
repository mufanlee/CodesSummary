import java.util.*;

/**
 * LeetCode
 * 508. Most Frequent Subtree Sum
 */
public class MostFrequentSubtreeSum {
    int max = 0;
    public int[] findFrequentTreeSum(TreeNode root) {
        if (root == null) return new int[0];
        Map<Integer, Integer> map = new HashMap<>();
        travel(root, map);
        List<Integer> list = new ArrayList<>();
        for (int key : map.keySet()) {
            if (map.get(key) == max)
                list.add(key);
        }
        /*int []res = new int[list.size()];
        for (int i = 0; i < list.size(); i++)
            res[i] = list.get(i);
        return res;*/

        return list.stream().mapToInt(i->i).toArray();
    }

    public int travel(TreeNode root, Map<Integer, Integer> map) {
        if (root == null) return 0;
        int left = travel(root.left, map);
        int right = travel(root.right, map);
        int sum = left + right + root.val;
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        max = Math.max(max, map.get(sum));
        return sum;
    }
}

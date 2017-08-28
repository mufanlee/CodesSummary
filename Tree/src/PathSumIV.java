import java.util.HashMap;
import java.util.Map;

/**
 * 666. Path Sum IV
 * If the depth of a tree is smaller than 5, then this tree can be represented by a list of three-digits integers.
 * For each integer in this list:
 *   1.The hundreds digit represents the depth D of this node, 1 <= D <= 4.
 *   2.The tens digit represents the position P of this node in the level it belongs to, 1 <= P <= 8. The position is the same as that in a full binary tree.
 *   3.The units digit represents the value V of this node, 0 <= V <= 9.
 * Given a list of ascending three-digits integers representing a binary with the depth smaller than 5. You need to return the sum of all paths from the root towards the leaves.
 *
 * Example 1:
 * Input: [113, 215, 221]
 * Output: 12
 * Explanation:
 * The tree that the list represents is:
 *   3
 *  / \
 * 5   1
 * The path sum is (3 + 5) + (3 + 1) = 12.
 * Example 2:
 * Input: [113, 221]
 * Output: 4
 * Explanation:
 * The tree that the list represents is:
 * 3
 *  \
 *   1
 * The path sum is (3 + 1) = 4.
 *
 * 思路：树中的每个节点用一个整数表示，整数的百位是树的深度，十位是每层中节点的位置（从1开始），个位是每个节点的值。
 * 我们可以用Map来存储树，Map的Key是百位和十位的值，Value是个位的值，即节点的值，然后遍历该树。
 * 树的每个节点，其左孩子是i*2-1，右孩子是i*2。遍历每个节点时，当其为叶结点则求和。
 *
 * @author LiPeng
 * @since 2017/8/289:57
 */
public class PathSumIV {
    Map<Integer, Integer> map = new HashMap<>();
    int res = 0;
    public int pathSum(int[] nums) {
        for (int n : nums)
            map.put(n / 10, n % 10);
        dfs(nums[0] / 10, 0);
        return res;
    }

    void dfs(int root, int sum) {
        sum += map.get(root);
        int left = (root / 10 + 1) * 10 + (root % 10) * 2 - 1;
        int right = (root / 10 + 1) * 10 + (root % 10) * 2;
        if (!map.containsKey(left) && !map.containsKey(right)) {
            res += sum;
            return;
        }
        if (map.containsKey(left))
            dfs(left, sum);
        if (map.containsKey(right))
            dfs(right, sum);
    }
}

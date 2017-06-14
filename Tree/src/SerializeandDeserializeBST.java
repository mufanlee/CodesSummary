import java.util.LinkedList;
import java.util.Queue;

/**
 * LeetCode
 * 449. Serialize and Deserialize BST
 */
public class SerializeandDeserializeBST {
    public class Codec {

        // 先序遍历
        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if (root == null) return "";
            String str = String.valueOf(root.val) + ",";
            str += serialize(root.left);
            str += serialize(root.right);
            return str;
        }

        public TreeNode deserialize(String data) {
            if (data.length() == 0) return null;
            String []strs = data.split(",");
            Queue<Integer> queue = new LinkedList<>();
            for (String s : strs)
                queue.add(Integer.parseInt(s));
            return DFS(queue);
        }

        public TreeNode DFS(Queue<Integer> queue) {
            if (queue.isEmpty()) return null;
            TreeNode root = new TreeNode(queue.poll());
            Queue<Integer> sq = new LinkedList<>();
            while (!queue.isEmpty() && queue.peek() < root.val)
                sq.offer(queue.poll());
            root.left = DFS(sq);
            root.right = DFS(queue);
            return root;
        }

        // 用二叉搜索树的插入
        // Decodes your encoded data to tree.
        public TreeNode deserialize2(String data) {
            if (data.length() == 0) return null;
            String []strs = data.split(",");
            int x = Integer.parseInt(strs[0]);
            TreeNode root = new TreeNode(x);
            for (int i = 1; i < strs.length; i++)
                insert(root, Integer.parseInt(strs[i]));
            return root;
        }

        boolean insert(TreeNode root, final int x) {
            if (root == null) return false;
            if (root.val > x) {
                if (root.left == null)
                    root.left = new TreeNode(x);
                else return insert(root.left, x);
            }
            if (root.val < x) {
                if (root.right == null)
                    root.right = new TreeNode(x);
                return insert(root.right, x);
            }
            return false;
        }
    }

    public Codec getCodec() {
        return new Codec();
    }

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));

    public static void main(String []args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);

        Solution.inorder(root);
        System.out.println();

        Codec codec = new SerializeandDeserializeBST().getCodec();
        String str = codec.serialize(root);
        System.out.println(str);
        TreeNode p = codec.deserialize2(str);
        Solution.inorder(p);
    }
}

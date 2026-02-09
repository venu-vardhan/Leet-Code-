/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    List<Integer> inorder = new ArrayList<>();

    public TreeNode balanceBST(TreeNode root) {
        // Step 1: Store inorder traversal
        inorderTraversal(root);

        // Step 2: Build balanced BST
        return buildBalancedBST(0, inorder.size() - 1);
    }

    private void inorderTraversal(TreeNode node) {
        if (node == null) return;

        inorderTraversal(node.left);
        inorder.add(node.val);
        inorderTraversal(node.right);
    }

    private TreeNode buildBalancedBST(int left, int right) {
        if (left > right) return null;

        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(inorder.get(mid));

        root.left = buildBalancedBST(left, mid - 1);
        root.right = buildBalancedBST(mid + 1, right);

        return root;
    }
}

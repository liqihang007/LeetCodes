//Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
//Note: 
//You may assume k is always valid, 1 <= k <= BST's total elements.

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class KthSmallestElementinaBST {
	
	private int counter;

    private TreeNode kthSmallestNode(TreeNode root, int k) {
        if (root == null) return null;
        TreeNode left = kthSmallestNode(root.left, k);
        if (left != null) return left;
        counter++;
        if (counter == k) return root;
        return kthSmallestNode(root.right, k);
    }

    public int kthSmallest(TreeNode root, int k) {
        counter = 0;
        return kthSmallestNode(root, k).val;
    }
}

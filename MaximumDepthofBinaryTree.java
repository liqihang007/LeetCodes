//Given a binary tree, find its maximum depth.
//The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class MaximumDepthofBinaryTree {

	public int maxDepth(TreeNode root) {
		if(root==null){return 0;}
		return finddp(root,0);
    }
	
	public int finddp(TreeNode node, int i) {
		if(node==null){return i;}
		else{
			return Math.max(finddp(node.left,i+1),finddp(node.right,i+1));
		}
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

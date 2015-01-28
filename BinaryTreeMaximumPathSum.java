//Given a binary tree, find the maximum path sum.
//The path may start and end at any node in the tree.
//For example: Given the below binary tree,
//       1
//      / \
//     2   3
//Return 6.

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BinaryTreeMaximumPathSum {

	private int res=Integer.MIN_VALUE;
	public int maxPathSum(TreeNode root) {
        dfs(root);
        return res;
    }
	
	public int dfs(TreeNode node){ // node.val could be negative
		if(node==null){return 0;}
		int left=Math.max(dfs(node.left),0);
		int right=Math.max(dfs(node.right),0);
		res=Math.max(left+node.val+right,res);
		return node.val+Math.max(left,right);
	}
	
	public static void main(String[] args) {
		
	}
}

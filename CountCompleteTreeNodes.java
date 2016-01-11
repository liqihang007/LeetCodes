//Given a complete binary tree, count the number of nodes.
//In a complete binary tree every level, except possibly the last, is completely filled, and all nodes 
//in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class CountCompleteTreeNodes {
	public int countNodes(TreeNode root) {
		if(root==null) 
	        return 0;
	    int l=getHeight(root.left);
	    int r=getHeight(root.right);
	    return l==r ? countNodes(root.right)+(1<<l+1) : countNodes(root.left)+(1<<r+1);
	}

	public int getHeight(TreeNode node){
	    return node==null? -1 : 1+getHeight(node.left);
    }
}

//Invert a binary tree.
//
//     4
//   /   \
//  2     7
// / \   / \
//1   3 6   9
//to
//     4
//   /   \
//  7     2
// / \   / \
//9   6 3   1

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class InvertBinaryTree {
	
	public TreeNode invertTree(TreeNode root) {
        if(root==null)
        	return root;
        TreeNode tmp=root.right;
       	root.right=root.left;
       	root.left=tmp;
       	invertTree(root.left);
       	invertTree(root.right);
        return root;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

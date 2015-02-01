//Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
//For example, this binary tree is symmetric:
//    1
//   / \
//  2   2
// / \ / \
//3  4 4  3
//But the following is not:
//    1
//   / \
//  2   2
//   \   \
//   3    3

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class SymmetricTree {

	public boolean isSymmetric(TreeNode root) {
        if(root==null){return true;}
    	return check(root.left,root.right);
    }

	public boolean check(TreeNode left, TreeNode right){
		if(left == null && right == null){return true;}
		if(left == null || right == null){return false;}
		return left.val == right.val && check(left.left, right.right) && check(left.right, right.left);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

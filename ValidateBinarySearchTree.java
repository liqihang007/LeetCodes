import ConvertSortedArraytoBinarySearchTree.TreeNode;

//Given a binary tree, determine if it is a valid binary search tree (BST).
//Assume a BST is defined as follows:
//The left subtree of a node contains only nodes with keys less than the node's key.
//The right subtree of a node contains only nodes with keys greater than the node's key.
//Both the left and right subtrees must also be binary search trees.

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class ValidateBinarySearchTree {
	boolean isRoot = true;
	int last=Integer.MIN_VALUE;
	public boolean isValidBST(TreeNode root) {
		if(root==null){
			return true;
		}
		if(!isValidBST(root.left)){
			return false;
		}
		if(!isRoot && last>=root.val){
			return false;
		}
		isRoot=false;
		last=root.val;
		if(!isValidBST(root.right)){
			return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		
	}
}

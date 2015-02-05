//Given a binary tree, determine if it is height-balanced.
//For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

import java.util.*;

private class BalancedBinaryTree {
	
	public boolean isBalanced(TreeNode root) {
		if(root==null){return true;}
        if(Math.abs(findheight(root.left,0)-findheight(root.right,0))>1){
        	return false;
        }
        else{
        	return isBalanced(root.left) && isBalanced(root.right);
        }
	}
	
	public int findheight(TreeNode node,int i){
		if(node==null){return i;}
		else{
			return Math.max(findheight(node.left,i+1), findheight(node.right,i+1));
		}
	}
		
	public static void main(String[] args) {

	}

}

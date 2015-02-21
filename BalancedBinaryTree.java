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
        if(Math.abs(findheight(root.left)-findheight(root.right))>1){
        	return false;
        }
        else{
        	return isBalanced(root.left) && isBalanced(root.right);
        }
	}
	
	public int findheight(TreeNode node){
		if(node==null){return 0;}
        return Math.max(1+findheight(node.left), 1+findheight(node.right));
	}
		
	public static void main(String[] args) {

	}

}

//Given preorder and inorder traversal of a tree, construct the binary tree.

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

public class ConstructBinaryTreefromPreorderandInorderTraversal {

	static class TreeNode {
		int val;
	    TreeNode left;
	    TreeNode right;
	    TreeNode(int x) { val = x; }
	}
	
	public int findpos(int[] A, int start, int end, int tar){
		for(int i=start;i<=end;i++){
			if(A[i]==tar)
				return i;
		}
		return -1;
	}
	
	public TreeNode buildtree(int[] preorder, int prestart, int preend, int[] inorder, int instart, int inend){
		if(instart>inend) return null;
		TreeNode root = new TreeNode(preorder[prestart]);
		int pos = findpos(inorder, instart, inend, preorder[prestart]);
		root.left=buildtree(preorder, prestart+1, prestart+(pos-instart), inorder, instart, pos-1);//pos-instart is the nodes' size at left
		root.right=buildtree(preorder, preend-(inend-pos)+1, preend, inorder, pos+1, inend);//inend-pos is the nodes' size on right
		return root;
	}
	
	public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length!=inorder.length) return null;
        return buildtree(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
    }
	
	public static void main(String[] args) {
		
	}
}

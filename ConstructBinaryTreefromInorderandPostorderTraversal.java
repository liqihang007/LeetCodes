//Given inorder and postorder traversal of a tree, construct the binary tree.

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

import ConstructBinaryTreefromPreorderandInorderTraversal.TreeNode;

public class ConstructBinaryTreefromInorderandPostorderTraversal {

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
	
//    public TreeNode buildtree(int[] preorder, int prestart, int preend, int[] inorder, int instart, int inend){
//        if(instart>inend) return null;
//        TreeNode root = new TreeNode(preorder[prestart]);
//        int pos = findpos(inorder, instart, inend, preorder[prestart]);
//        root.left=buildtree(preorder, prestart+1, prestart+(pos-instart), inorder, instart, pos-1);//pos-instart is the nodes' size at left
//        root.right=buildtree(preorder, preend-(inend-pos)+1, preend, inorder, pos+1, inend);//inend-pos is the nodes' size on right
//        return root;
//    }
    
	public TreeNode buildtree(int[] inorder, int instart, int inend, int[] postorder, int poststart, int postend){
		if(instart>inend) return null;
		TreeNode root = new TreeNode(postorder[postend]);
		int pos = findpos(inorder, instart, inend, postorder[postend]);
		root.left=buildtree(inorder, instart, pos-1, postorder, poststart, poststart+(pos-instart)-1);
		root.right=buildtree(inorder, pos+1, inend, postorder, poststart+(pos-instart), postend-1);
		return root;
	}
	
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		if(postorder.length!=inorder.length) return null;
        return buildtree(inorder, 0, inorder.length-1,postorder, 0, postorder.length-1);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

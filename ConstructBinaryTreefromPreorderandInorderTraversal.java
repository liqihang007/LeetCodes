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

//	public static TreeNode buildTree(int[] preorder, int[] inorder) {
//		TreeNode root=null;
//		if(preorder!=null && inorder!=null && preorder.length==inorder.length){
//			if(preorder.length==1 && preorder[0]==inorder[0]){
//				root=TreeNode(preorder[0]);
//			}
//			else{
//				int n = preorder.length;
//				root=constructtree(root, preorder, inorder);
//			}
//		}
//		
//		return root;
//    }
//	
//	public static TreeNode constructtree(TreeNode node, int[] preorder, int[] inorder){
//		if(preorder.length==0 || inorder.length==0){
//			return null;
//		}
//		if(preorder.length==1 || inorder.length==1){
//			return TreeNode(preorder[0]);
//		}
//		else{
//			int marker=0;
//			for (int i=0;i<preorder.length;i++){
//				if(inorder[i]==preorder[0]){
//					marker=i;
//					break;
//				}
//			}
//			node.left=
//		}
//	}
	
	public static void main(String[] args) {
		int[]A=new int[]{1,2,3};
		Arrays.copyOfRange(A,10,11);
	}
}

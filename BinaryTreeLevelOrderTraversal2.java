//Given a binary tree, return the bottom-up level order traversal of its nodes' values. 
//(ie, from left to right, level by level from leaf to root).
//For example:
//Given binary tree {3,9,20,#,#,15,7},
//    3
//   / \
//  9  20
//    /  \
//   15   7
//return its bottom-up level order traversal as:
//[
//  [15,7],
//  [9,20],
//  [3]
//]

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

public class BinaryTreeLevelOrderTraversal2 {

	public static List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		int height = findheight(root,0);
		if(height==0){return res;}
		for(int i=0;i<height;i++){
			res.add(new ArrayList<Integer>());
		}
		filllist(root,height-1,res);
		return res;
    }
	
	public static void filllist(TreeNode node, int i, List<List<Integer>> res){
		if(node==null){return;}
		else{
			res.get(i).add(node.val);
			filllist(node.left,i-1,res);
			filllist(node.right,i-1,res);
		}
	}
	
	public static int findheight(TreeNode node, int i){
		if(node==null){return i;}
		return Math.max(findheight(node.left,i+1), findheight(node.right,i+1));
	}
	
	public static void main(String[] args) {
		TreeNode n1=new TreeNode(3);
		TreeNode n2=new TreeNode(9);
		TreeNode n3=new TreeNode(20);
		TreeNode n4=new TreeNode(15);
		TreeNode n5=new TreeNode(7);
		n1.left=n2;
		n1.right=n3;
		n3.left=n4;
		n3.right=n5;
		System.out.println(levelOrderBottom(n1));
	}

}

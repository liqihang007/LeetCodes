//Given a binary tree, return the zigzag level order traversal of its nodes' values. 
//		(ie, from left to right, then right to left for the next level and alternate between).
//For example: Given binary tree {3,9,20,#,#,15,7},
//    3
//   / \
//  9  20
//    /  \
//   15   7
//return its zigzag level order traversal as:
//[
//  [3],
//  [20,9],
//  [15,7]
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

public class BinaryTreeZigzagLevelOrderTraversal {

	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> res= new ArrayList<List<Integer>>();
		int height=findheight(root);
		if(height==0){return res;}
		for(int i=0;i<height;i++){
			res.add(new ArrayList<Integer>());
		}
		filllist(res,root,1);
		for(int i=1;i<height;i+=2){
			List<Integer>temp=new ArrayList<Integer>();
			for(int j=res.get(i).size()-1;j>=0;j--){
				temp.add(res.get(i).get(j));
			}
			res.set(i,temp);
		}
		return res;
    }
	
	public void filllist(List<List<Integer>>res, TreeNode node, int i){
		if(node==null){return;}
		res.get(i-1).add(node.val);
		filllist(res, node.left, i+1);
		filllist(res, node.right, i+1);
	}
	
	public int findheight(TreeNode root){
		if(root==null){return 0;}
		return Math.max(1+findheight(root.left), 1+findheight(root.right)); 
	}
	
	public static void main(String[] args) {
		
	}

}

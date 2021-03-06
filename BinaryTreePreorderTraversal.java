//Given a binary tree, return the preorder traversal of its nodes' values.
//For example: Given binary tree {1,#,2,3},
//   1
//    \
//     2
//    /
//   3
//return [1,2,3].

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

public class BinaryTreePreorderTraversal {

	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer>res=new ArrayList<Integer>();
		travel_preorder(root,res);
		return res;
    }
	
	public void travel_preorder(TreeNode node, List<Integer> res){
		if(node==null){return;}
		res.add(node.val);
		travel_preorder(node.left, res);
		travel_preorder(node.right, res);
	}
	
	public static void main(String[] args) {
		
	}
}

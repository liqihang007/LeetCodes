//Given a binary tree, return the inorder traversal of its nodes' values.
//For example: Given binary tree {1,#,2,3},
//   1
//    \
//     2
//    /
//   3
//return [1,3,2].

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

public class BinaryTreeInorderTraversal {

	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer>res=new ArrayList<Integer>();
        travel_inorder(root,res);
        return res; 
    }
	
	public void travel_inorder(TreeNode node, List<Integer> res){
		if(node==null){return;}
		travel_inorder(node.left, res);
		res.add(node.val);
		travel_inorder(node.right, res);
	}
	
	public static void main(String[] args) {
		
	}
}

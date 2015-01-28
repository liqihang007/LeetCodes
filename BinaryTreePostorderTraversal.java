//Given a binary tree, return the postorder traversal of its nodes' values.
//For example: Given binary tree {1,#,2,3},
//   1
//    \
//     2
//    /
//   3
//return [3,2,1].

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

public class BinaryTreePostorderTraversal {

	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer>res=new ArrayList<Integer>();
		travel_postorder(root,res);
		return res;
    }
	
	public void travel_postorder(TreeNode node, List<Integer> res){
		if(node==null){return;}
		travel_postorder(node.left, res);
		travel_postorder(node.right, res);
		res.add(node.val);
	}
	
	public static void main(String[] args) {
		
	}
}

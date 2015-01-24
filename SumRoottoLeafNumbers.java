//Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
//An example is the root-to-leaf path 1->2->3 which represents the number 123.
//Find the total sum of all root-to-leaf numbers.
//For example,
//    1
//   / \
//  2   3
//The root-to-leaf path 1->2 represents the number 12.
//The root-to-leaf path 1->3 represents the number 13.
//Return the sum = 12 + 13 = 25.

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

public class SumRoottoLeafNumbers {

	public int sumNumbers(TreeNode root) {
		int res=0;
        if(root==null){return res;}
        return getres(root, res);
    }

	public int getres(TreeNode node, int res){
		if(node.left==null && node.right==null){return res*10+node.val;}
		if(node.left==null && node.right!=null){return getres(node.right, res*10+node.val);}
		if(node.left!=null && node.right==null){return getres(node.left, res*10+node.val);}
		return getres(node.left, res*10+node.val) + getres(node.right, res*10+node.val);
	}
	
	public static void main(String[] args) {
		
	}

}

//Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
//For example:
//Given the below binary tree and sum = 22,
//              5
//             / \
//            4   8
//           /   / \
//          11  13  4
//         /  \    / \
//        7    2  5   1
//return
//[
//   [5,4,11,2],
//   [5,8,4,5]
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

public class PathSum2 {

	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> res=new ArrayList<List<Integer>>();
		List<Integer> sub = new ArrayList<Integer>();
		checkpath(root,sum,sub,res);
		return res;
    }
	
	public void checkpath(TreeNode root, int sum, List<Integer> sub,List<List<Integer>> res){
		if(root==null)
            return;
		List<Integer> sub2=new ArrayList<Integer>(sub);
		sub2.add(root.val);
		if(root.val == sum && root.left==null && root.right==null){
			res.add(sub2);
		}
		else{
			checkpath(root.left,sum-root.val,sub2,res);
			checkpath(root.right,sum-root.val,sub2,res);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

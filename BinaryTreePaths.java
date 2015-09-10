//Given a binary tree, return all root-to-leaf paths.
//For example, given the following binary tree:
//   1
// /   \
//2     3
// \
//  5
//All root-to-leaf paths are:
//["1->2->5", "1->3"]
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

import java.util.*;

import BinaryTreeLevelOrderTraversal.TreeNode;

public class BinaryTreePaths {


	
	public List<String> binaryTreePaths(TreeNode root) {
		List<String>ans = new ArrayList<String>();
        List<List<Integer>>res = new ArrayList<List<Integer>>();
        if(root==null) return ans;
        help(res, new ArrayList<Integer>(), root);
        for(int i=0;i<res.size();i++){
        	String tmp="";
        	for(Integer j:res.get(i)){
        		tmp=tmp+j+"->";
        	}
        	ans.add(tmp.substring(0, tmp.length()-2));
        }
        return ans;
    }
	
	public void help(List<List<Integer>> res, List<Integer> tmp, TreeNode node){
		if (node.left==null && node.right==null){
			tmp.add(node.val);
			res.add(new ArrayList<Integer>(tmp));
			tmp.remove(tmp.size()-1);
		}
		if(node.left!=null){
			tmp.add(node.val);
			help(res, tmp, node.left);
			tmp.remove(tmp.size()-1);
		}
		if(node.right!=null){
			tmp.add(node.val);
			help(res, tmp, node.right);
			tmp.remove(tmp.size()-1);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

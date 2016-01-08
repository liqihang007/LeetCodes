//Given a binary tree, imagine yourself standing on the right side of it, 
//return the values of the nodes you can see ordered from top to bottom.
//For example:
//Given the following binary tree,
//   1            <---
// /   \
//2     3         <---
// \     \
//  5     4       <---
//You should return [1, 3, 4].

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

//Using level Order Travaling:Travel each level ,find the last TreeNode of the level and add its val into our result . 

public class BinaryTreeRightSideView {
	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> res=new ArrayList<Integer>();
	      if(root==null) return res;
	      Queue<TreeNode> queue=new LinkedList<TreeNode>();
	      queue.add(root);
	      while(queue.size()!=0){
	        int level=queue.size(); // how many nodes in this level
	        for(int i=1;i<=level;i++){
	           TreeNode temp=queue.poll();
	           if(level==i) 
	        	   res.add(temp.val);
	           if(temp.left!=null) 
	        	   queue.add(temp.left);
	           if(temp.right!=null) 
	        	   queue.add(temp.right);
	        }
	    }
	    return res;
    }
}

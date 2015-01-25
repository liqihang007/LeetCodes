//Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.
//Calling next() will return the next smallest number in the BST.
//Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

import java.util.*;

public class BinarySearchTreeIterator {   // Stack
	private Stack<TreeNode> stack;
	
	public BSTIterator(TreeNode root) {
        stack=new Stack<TreeNode>();
        TreeNode temp=root;
        while(temp!=null){
        	stack.push(temp);
        	temp=temp.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode temp=stack.pop();
        int res=temp.val;
        if(temp.right!=null){
        	temp=temp.right;
        	stack.push(temp);
        	temp=temp.left;
        	while(temp!=null){
        		stack.push(temp);
        		temp=temp.left;
        	}
        }
        return res;
    }
    
}

//public class BSTIterator {    // flatting the tree
//    private TreeNode head;
//    private TreeNode pre;
//    public BSTIterator(TreeNode root) {
//            convert(root);
//    }
//
//    private void convert(TreeNode root) {
//        if (root == null) {
//            return;
//        }
//        if (root.left != null){
//            convert(root.left);
//        }
//        if (head == null) {
//            head = root;
//        }
//        if (pre == null) {
//            pre = root;
//        } else {
//            pre.right = root;
//            pre = root;
//        }
//        if (root.right != null) {
//            convert(root.right);
//        }
//
//    }
//
//	 /** @return whether we have a next smallest number */
//   public boolean hasNext() {
//        return head != null;
//    }
//
//	  /** @return the next smallest number */
//    public int next() {
//        if (hasNext()) {
//                   TreeNode t = head;
//        head = head.right;
//        return t.val; 
//        } else {
//            return -1;
//        }
//    }
//}

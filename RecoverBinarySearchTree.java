//Two elements of a binary search tree (BST) are swapped by mistake.
//Recover the tree without changing its structure.

/*The basic idea is to use stack to do in-order traversal. In the processing of traversal, 
keep comparing the current value with the previous value. Since each previous value should be 
less than the current value, once an exception is found, record the previous node as the 
First Mistaken Node and the current node as Second. If one more exceptions are found, override 
the current node to the Second Mistaken Node. Because if a series of mistaken nodes are found, 
the only possible way to correct them with one swap is to switch the head and tail node.*/

import java.util.*;

public class RecoverBinarySearchTree {
	public void recoverTree(TreeNode root) {
	    TreeNode pre = null, first = null, second = null;
	    Deque<TreeNode> stack = new LinkedList<TreeNode>();
	    while (root != null) {
	        stack.push(root);
	        root = root.left;
	    }
	    while (!stack.isEmpty()) {
	        TreeNode temp = stack.pop();
	        if (pre != null)
	            if (pre.val > temp.val) {
	                if (first == null)
	                    first = pre;
	                second = temp;
	            }
	        pre = temp;
	        if (temp.right != null) {
	            temp = temp.right;
	            while (temp != null) {
	                stack.push(temp);
	                temp = temp.left;
	            }
	        }
	    }
	    int temp = first.val; // swap first and second
	    first.val = second.val;
	    second.val = temp;
	}
}

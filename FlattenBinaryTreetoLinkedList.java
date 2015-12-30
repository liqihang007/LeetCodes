//Given a binary tree, flatten it to a linked list in-place.
//For example,
//Given
//         1
//        / \
//       2   5
//      / \   \
//     3   4   6
//The flattened tree should look like:
//   1
//    \
//     2
//      \
//       3
//        \
//         4
//          \
//           5
//            \
//             6
//If you notice carefully in the flattened tree, each node's right child points to the next node of a pre-order traversal.

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

public class FlattenBinaryTreetoLinkedList {
	
	static class TreeNode {
		int val;
	    TreeNode left;
	    TreeNode right;
	    TreeNode(int x) { val = x; }
	}
		
	public static void flatten(TreeNode root) {	//	Stack
		if (root == null) return;
        Stack<TreeNode> stk = new Stack<TreeNode>();
        stk.push(root);
        while (!stk.isEmpty()){
            TreeNode curr = stk.pop();
            if (curr.right!=null)  
                 stk.push(curr.right);
            if (curr.left!=null)  
                 stk.push(curr.left);
            if (!stk.isEmpty()) 
                 curr.right = stk.peek();
            curr.left = null;  // dont forget this!! 
        }
	}
	
//	public static void flatten_Rec(TreeNode root) { //	Recursion
//		rec(root);
//	}
//	public static TreeNode rec(TreeNode node) {
//		if (node == null) return null;
//		TreeNode tmp=node.right;
//        if(node.left!=null){
//        	node.right=node.left;
//        	node.left=null;
//        	node=rec(node.right);
//        }
//        if(tmp!=null){
//        	node.right=tmp;
//        	node=rec(node.right);
//        }
//        return node;
//	}
	
	public static void main(String[] args) {
		TreeNode n1=new TreeNode(3);
		TreeNode n2=new TreeNode(9);
		TreeNode n3=new TreeNode(20);
		TreeNode n4=new TreeNode(15);
		TreeNode n5=new TreeNode(7);
		n1.left=n2;
		n1.right=n3;
		n3.left=n4;
		n3.right=n5;
		flatten_Rec(n1);
		System.out.println(n1.val);
		System.out.println(n1.right.val);
		System.out.println(n1.right.right.val);
		System.out.println(n1.right.right.right.val);
		System.out.println(n1.right.right.right.right.val);
	}

}

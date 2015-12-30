//Given a binary tree, find the lowest common ancestor of two given nodes in the tree.
//        _______3______
//       /              \
//    ___5__          ___1__
//   /      \        /      \
//   6      _2       0       8
//         /  \
//         7   4
//II:
//Given a binary tree, find the lowest common ancestor of two given nodes in the tree. Each node contains a parent pointer which links to its parent.
//
//
//Note: 
//This is Part II of Lowest Common Ancestor of a Binary Tree. If you need to find the lowest common ancestor without parent pointers, please read Lowest Common Ancestor of a Binary Tree Part I. 
//        _______3______
//       /              \
//    ___5__          ___1__
//   /      \        /      \
//   6      _2       0       8
//         /  \
//         7   4

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class LowestCommonAncestorofBinaryTree {

	public TreeNode LCA_I(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null) {
	        return null;
	    } else if (root == p) {
	        return p;
	    } else if (root == q) {
	        return q;
	    }
	    if (LCA_I(root.left, p, q) == null) {
	        return LCA_I(root.right, p, q);
	    } else if (LCA_I(root.right, p, q) == null) {
	        return LCA_I(root.left, p, q);
	    } else {
	        return root;
	    }
	}
	
	public TreeNode LCA_II(TreeNode p, TreeNode q) {
		int h1 = getHeight(p);
		int h2 = getHeight(q);
		if (h1 > h2) {
			swap(h1, h2);
			swap(p, q);
		}
		int dh = h2 - h1;
		for (int h = 0; h < dh; h++)
			q = q.parent;
		while (p && q) {
			if (p == q) return p;
			p = p.parent;
			q = q.parent;
		}
		return null;  // p and q are not in the same tree
	}
	
	public int getHeight(TreeNode p) {
		int height = 0;
		while (p) {
			height++;
			p = p.parent;
		}
		return height;
	}
	
	public static void main(String[] args) {
		
	}
}

//Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.
//For example, Given n = 3, your program should return all 5 unique BST's shown below.
//   1         3     3      2      1
//    \       /     /      / \      \
//     3     2     1      1   3      2
//    /     /       \                 \
//   2     1         2                 3

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; left = null; right = null; }
 * }
 */

import java.util.*;

public class UniqueBinarySearchTrees2 {

	static class TreeNode {
		    int val;
		    TreeNode left;
		    TreeNode right;
		    TreeNode(int x) { val = x; left = null; right = null; }
		}
	
//	Recursive - O(n*n)
//	Given a consecutive sequence, eg. [1,2,3,4,5].
//	The way to generate every possible binary search tree for this sequence is take each number as root node and then assign both child.
//	Thus, [1,2,3,4,5] will be computed as,
//	First take 1 as root node, then left child will be null, right child will be sequence [2,3,4,5].
//	Second take 2 as root node, then left child will be 1, right child will be sequence [3,4,5].
//	Then take 3 as root node, then left child will be [1,2], right child will be sequence [4,5].
//	Next take 4 as root node, then left child will be [1,2,3], right child will be [5].
//	Finally take 5 as root node, then left child will be [1,2,3,4], right child will be null.
	
	public static List<TreeNode> generateTrees(int n) {
        return buildtrees(1,n+1);
    }
	
	public List<TreeNode> buildtrees(int min, int max){
		List<TreeNode> res= new ArrayList<>();
		if(min>=max){
			TreeNode root=null;
			res.add(root);
		}
		for(int i=min;i<max;i++){
			List<TreeNode> left= buildtrees(min,i);
			List<TreeNode> right= buildtrees(i+1,max);
			for(int x=0;x<left.size();x++){
				for(int y=0;y<right.size();y++){
					TreeNode node = new TreeNode(i);
					node.left=left.get(x);
					node.right=right.get(y);
					res.add(node);
				}
			}
		}
		return res;
	}
	
////	HashMap (+DP?) - O(n*n*logn)
////	The idea is to generate binary trees for every number from 1 and store them in map. 
////	And for every next N get roots from 1 to N and just link left and right subtrees generated previously. 
////	All values in right subtree should be encreased by the root value.
//	public List<TreeNode> generateTrees(int n) {	
//	    Map<Integer, List<TreeNode>> lists = new HashMap<Integer, List<TreeNode>>();
//
//	    List<TreeNode> list = new LinkedList<TreeNode>();
//	    list.add(null);
//	    if (n==0) return list;
//	    lists.put(0, list);
//
//	    list = new LinkedList<TreeNode>();
//	    TreeNode root = new TreeNode(1);
//	    list.add(root);
//	    lists.put(1, list);
//
//	    for (int i=2; i<=n; i++) {
//	        list = new LinkedList<TreeNode>();
//	        for (int j=1; j<=i; j++) {
//	            for (TreeNode left:lists.get(j-1)) {
//	                for (TreeNode right:lists.get(i-j)) {
//	                    root = new TreeNode(j);
//	                    root.left = left;
//	                    root.right = copynode(right, j);
//	                    list.add(root);
//	                }
//	            }
//	        }
//	        lists.put(i, list);
//	    }
//	    return list;
//	}
//	public static TreeNode copynode(TreeNode node, int i){
//		if(node==null){return null;}
//		TreeNode res=new TreeNode(node.val+i);
//		res.left=copynode(node.left,i);
//		res.right=copynode(node.right,i);
//		return res;
//	}
	
	public static void main(String[] args) {
		List<TreeNode> res=generateTrees(2);
		System.out.println(res.get(1).val);
		System.out.println(res.get(1).left.val);
		System.out.println(res.get(1).left.right.val);
	}

}

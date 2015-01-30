//Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class ConvertSortedArraytoBinarySearchTree {

	static class TreeNode {
	    int val;
	    TreeNode left;
	    TreeNode right;
	    TreeNode(int x) { val = x; }
	}
	public static TreeNode sortedArrayToBST(int[] num) {
        if(num==null || num.length==0){return null;}
        if(num.length==1){return new TreeNode(num[0]);}
        TreeNode root=buildtree(num,0,num.length-1);
        return root;
    }
	
	public static TreeNode buildtree(int[] num, int a,int b){
		if(a>b){
			return null;
		}
		if(a==b){
			TreeNode node=new TreeNode(num[a]);
			return node;
		}
		int mid=(a+b)/2;
		TreeNode node=new TreeNode(num[mid]);
		node.left=buildtree(num,a,mid-1);
		node.right=buildtree(num,mid+1,b);
		return node;
	}
	
	public static void main(String[] args) {
		TreeNode n1=sortedArrayToBST(new int[]{1,2,3});
		System.out.println(n1.val);
		System.out.println(n1.left.val);
		System.out.println(n1.right.val);
	}
}

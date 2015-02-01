//Given a binary tree, print it vertically. The following example illustrates vertical order traversal.
//           1
//        /    \
//       2      3
//      / \    / \
//     4   5  6   7
//             \   \
//              8   9 
//The output of print this tree vertically will be:
//4
//2
//1 5 6
//3 8
//7
//9

import java.util.*;

public class PrintaBinaryTreeinVerticalOrder {

	static class Node
	{
	    int val;
	    Node left;
	    Node right;
	    Node(int x){
	    	this.val=x;
	    	left=null;
	    	right=null;
	    }
	}
	
	public static List<List<Integer>> rintaBinaryTreeinVerticalOrder(Node root){
		List<List<Integer>>res=new ArrayList<List<Integer>>();
		if(root==null){return res;}
		int[] range=new int[2];
		range[0]=Integer.MAX_VALUE;
		range[1]=Integer.MIN_VALUE;
		findrange(root, range,0);
		for(int i=0;i<range[1]-range[0]+1;i++){
			res.add(new ArrayList<Integer>());
		}
		fillList(root,res,-range[0]);
		return res;
	}
	
	public static void fillList(Node node, List<List<Integer>>res, int pos){
		if(node==null){return;}
		res.get(pos).add(node.val);
		fillList(node.left,res,pos-1);
		fillList(node.right,res,pos+1);
	}
	
	public static void findrange(Node node, int[] range, int i){
		if(node==null){return;}
		if(i<range[0]){
			range[0]=i;
		}
		if(i>range[1]){
			range[1]=i;
		}
		findrange(node.left, range,i-1);
		findrange(node.right, range,i+1);
	}
	
	public static void main(String[] args) {
		Node root = new Node(1);
	    root.left = new Node(2);
	    root.right = new Node(3);
	    root.left.left = new Node(4);
	    root.left.right = new Node(5);
	    root.right.left = new Node(6);
	    root.right.right = new Node(7);
	    root.right.left.right = new Node(8);
	    root.right.right.right = new Node(9);
	    System.out.println(rintaBinaryTreeinVerticalOrder(root));
	}

}

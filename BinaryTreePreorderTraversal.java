//Given a binary tree, return the preorder traversal of its nodes' values.
//For example: Given binary tree {1,#,2,3},
//   1
//    \
//     2
//    /
//   3
//return [1,2,3].

import java.util.List;

public class BinaryTreePreorderTraversal {  // recursive

	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> res=new ArrayList<Integer>();
		travel(root,res);
		return res;
    }
	
	public void travel(TreeNode node, List<Integer> res){
		if(node==null){return;}
		res.add(node.val);
		travel(node.left,res);
		travel(node.right,res);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

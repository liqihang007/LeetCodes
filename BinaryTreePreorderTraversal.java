import java.util.List;

import FlattenBinaryTreetoLinkedList.TreeNode;


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

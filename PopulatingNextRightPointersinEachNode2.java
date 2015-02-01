//Follow up for problem "Populating Next Right Pointers in Each Node".
//What if the given tree could be any binary tree? Would your previous solution still work?
//Note:
//You may only use constant extra space.
//For example,
//Given the following binary tree,
//         1
//       /  \
//      2    3
//     / \    \
//    4   5    7
//After calling your function, the tree should look like:
//         1 -> NULL
//       /  \
//      2 -> 3 -> NULL
//     / \    \
//    4-> 5 -> 7 -> NULL

/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */

public class PopulatingNextRightPointersinEachNode2 {

	public void connect(TreeLinkNode root) {
        if(root==null ||(root.left==null && root.right==null)){
        	return;
        }
        TreeLinkNode levelnext=root.next;
        TreeLinkNode lowernext=null;
        while(levelnext!=null && lowernext==null){
        	if(levelnext.left!=null){
        		lowernext=levelnext.left;
        	}else if(levelnext.right!=null){
        		lowernext=levelnext.right;
        	}else{
        		levelnext=levelnext.next;
        	}
        }
        if(root.left==null){
        	root.right.next=lowernext;
        } else if(root.right==null){
        	root.left.next=lowernext;
        } else{
        	root.left.next=root.right;
        	root.right.next=lowernext;
        }
        connect(root.right);
        connect(root.left);
    }

	public static void main(String[] args) {
		
	}
}

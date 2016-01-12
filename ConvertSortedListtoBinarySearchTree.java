//Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
*/

/*
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
*/

import java.util.*;

public class ConvertSortedListtoBinarySearchTree {

	public TreeNode sortedListToBST(ListNode head) {
        if(head==null){
            return null;
        }
        if(head.next==null){
            TreeNode treeNode=new TreeNode(head.val);
            return treeNode;
        }
        ListNode slow=head;
        ListNode fast=head.next.next;
        while(fast!=null&&fast.next!=null){ // find the mid node
            slow=slow.next;
            fast=fast.next.next;
        }
        TreeNode root=new TreeNode(slow.next.val);
        ListNode temp=slow.next.next;
        slow.next=null;
        root.left=sortedListToBST(head);
        root.right=sortedListToBST(temp);
        return root;
    }
	
//	public TreeNode sortedListToBST(ListNode head) {
//        if(head==null){return null;}
//        if(head.next==null){return new TreeNode(head.val);}
//        List<Integer>list=new ArrayList<Integer>();
//        while(head!=null){
//        	list.add(head.val);
//        	head=head.next;
//        }
//        int[] num=new int[list.size()];
//        for(int i=0;i<list.size();i++){
//        	num[i]=list.get(i);
//        }
//        TreeNode root=buildtree(num,0,num.length-1);
//        return root;
//    }
//	
//	public static TreeNode buildtree(int[] num, int a,int b){
//		if(a>b){
//			return null;
//		}
//		if(a==b){
//			TreeNode node=new TreeNode(num[a]);
//			return node;
//		}
//		int mid=(a+b)/2;
//		TreeNode node=new TreeNode(num[mid]);
//		node.left=buildtree(num,a,mid-1);
//		node.right=buildtree(num,mid+1,b);
//		return node;
//	}

}

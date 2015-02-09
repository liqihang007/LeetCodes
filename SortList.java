//Sort a linked list in O(n log n) time using constant space complexity.

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

import java.util.*;

public class SortList {

	static class ListNode {
	    int val;
	    ListNode next;
	    ListNode(int x) {
	        val = x;
	        next = null;
		}
	}
	
	public ListNode sortList(ListNode head) {
        if(head==null || head.next==null) return head;
        if(head.next.next==null){
        	if(head.next.val<head.val){
        		ListNode p=head.next;
        		head.next=null;
        		p.next=head;
        		return p;
        	}
        	else{
        		return head;
        	}
        }
        ListNode p1=head, p2=head.next.next;
        while(p2!=null && p2.next!=null){
        	p1=p1.next;
        	p2=p2.next.next;
        }
        p2=p1.next;
        p1.next=null;
        p1=head;
        ListNode head1=sortList(p1);
        ListNode head2=sortList(p2);
        return merge(head1, head2);
    }
	
	public ListNode merge(ListNode node1, ListNode node2){
		ListNode root=new ListNode(0), p=root;
		while(node1!=null && node2!=null){
			if(node1.val>node2.val){
				p.next=new ListNode(node2.val);
				node2=node2.next;
			}
			else{
				p.next=new ListNode(node1.val);
				node1=node1.next;
			}
			p=p.next;
		}
		if(node1==null){
			p.next=node2;
		}
		if(node2==null){
			p.next=node1;
		}
		return root.next;
	}

	public static void main(String[] args) {
		ListNode p= new ListNode(1);
		ListNode head=p;
		System.out.println(p.val);
		for(int i=2;i<=20;i++){
			p.next=new ListNode(new Random().nextInt((20 - 1) + 1) + 1);
			System.out.println(p.next.val);
			p=p.next;
		}
		System.out.println("===");
		p=new SortList().sortList(head);
		while(p!=null){
			System.out.println(p.val);
			p=p.next;
		}
	}
}

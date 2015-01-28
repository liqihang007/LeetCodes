//Sort a linked list using insertion sort.

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

import java.util.*;

public class InsertionSortList {
	
	static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
		
	public static ListNode insertionSortList(ListNode head) {
        if(head==null || head.next==null){return head;}
        ListNode p1 = head, p2=head,p3=p1.next;
        while(p1.next!=null){
        	p2 = head;
        	p3 = p1.next;
        	if(p3.val>=p1.val){
        		p1=p1.next;
        	}
        	else{
        		if(head.val>=p3.val){ // add to head
        			p1.next=p3.next;
        			p3.next=head;
        			head=p3;
        		}
        		else{
        			while(p2.next.val<p3.val){ // insert p3
        				p2=p2.next;
        			}
        			p1.next=p3.next;
        			p3.next=p2.next;
        			p2.next=p3;
        		}
        	}
        }
        return head;
    }

	public static void main(String[] args) {
		ListNode A=new ListNode((int)(1+Math.random()*100));
		ListNode Head =A;
		for(int i=0;i<100;i++){
			A.next=new ListNode((int)(1+Math.random()*100));
			A=A.next;
		}
		ListNode p2=insertionSortList(Head);
		while(p2!=null){
			System.out.println(p2.val);
			p2=p2.next;
		}
	}
}

//Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.

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

public class MergeTwoSortedLists {

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if(l1==null){return l2;}
        if(l2==null){return l1;}
        ListNode p1=l1, p2=l2,p3,p4,res;
        if(p1.val>p2.val){
        	p3=p1;
    		p1=p2;
    		p2=p3;
        }
        p4=new ListNode(p1.val);
        res=p4;
        p1=p1.next;
        while(p1!=null && p2!=null){
        	if(p1.val<=p2.val){
        		p4.next=p1;
        		p1=p1.next;
        		p4=p4.next;
        	}
        	else{
        		p4.next=p2;
        		p2=p2.next;
        		p4=p4.next;
        	}
        }
        if(p2==null){
        	while(p1!=null){
        		p4.next=p1;
            	p4=p4.next;
            	p1=p1.next;
        	}
        }
        else{
        	while(p2!=null){
        		p4.next=p2;
            	p4=p4.next;
            	p2=p2.next;
        	}
        }
        return res;
    }
	
	public static void main(String[] args) {

	}

}

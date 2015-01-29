import InsertionSortList.ListNode;

//Given a linked list, determine if it has a cycle in it.

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

public class LinkedListCycle {

	public boolean hasCycle(ListNode head) {
        if(head==null || head.next==null){return false;}
        ListNode p1=head, p2=head.next;
        while(p2!=null && p2.next!=null){
        	if(p1==p2){
        		return true;
        	}
        	p1=p1.next;
        	p2=p2.next.next;
        }
        return false;
    }
	
	public static void main(String[] args) {
		
	}

}

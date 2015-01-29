import InsertionSortList.ListNode;

//Given a list, rotate the list to the right by k places, where k is non-negative.
//For example:
//Given 1->2->3->4->5->NULL and k = 2,
//return 4->5->1->2->3->NULL.

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

public class RotateList {

	public ListNode rotateRight(ListNode head, int n) {
        if(n==0 || head==null){return head;}
        int size=0;
        ListNode p1=head, p2=head;
        while(p1!=null){
        	p1=p1.next;
        	size++;
        }
        if(n>=size){n%=size;}
        if(n==0){return head;}
        p1=head;
        for(int i=0;i<n;i++){
        	p2=p2.next;
        }
        while(p2.next!=null){
        	p1=p1.next;
        	p2=p2.next;
        }
        ListNode rehead=p1.next;
        p1.next=null;
        p2.next=head;
        return rehead;
    }
	
	public static void main(String[] args) {
		
	}
}

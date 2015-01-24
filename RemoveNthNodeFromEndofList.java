//Given a linked list, remove the nth node from the end of list and return its head.
//For example,
//   Given linked list: 1->2->3->4->5, and n = 2.
//   After removing the second node from the end, the linked list becomes 1->2->3->5.
//Note:
//Given n will always be valid.
//Try to do this in one pass.

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

public class RemoveNthNodeFromEndofList {

	public ListNode removeNthFromEnd(ListNode head, int n) {
        int size=0;
        ListNode pA=head;
        while(pA!=null){
        	pA=pA.next;
        	size++;
        }
        int which=size-n;
        if(which==0){
        	return head.next;
        }
        else{
        	pA=head;
        	for(int i=0;i<which-1;i++){
            	pA=pA.next;
        	}
	        if(pA.next.next==null){
	        	pA.next=null;
	        	return head;
	        }
	        else{
	        	pA.next=pA.next.next;
	        	return head;
	        }
        }
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

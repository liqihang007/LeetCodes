//Given a sorted linked list, delete all duplicates such that each element appear only once.
//For example,
//Given 1->1->2, return 1->2.
//Given 1->1->2->3->3, return 1->2->3.
		
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

public class RemoveDuplicatesfromSortedList {

	public ListNode deleteDuplicates(ListNode head) {
        if(head==null || head.next==null){return head;}
        else{
        	ListNode pA=head;
        	while(pA.next!=null){
        		if(pA.next.val==pA.val){
        			pA.next=pA.next.next;
        		}
        		else{
        			pA=pA.next;
        		}
        	}
        	return head;
        }
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

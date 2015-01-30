import InsertionSortList.ListNode;

//Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
//Follow up: Can you solve it without using extra space?

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

public class LinkedListCycle2 {

	public ListNode detectCycle(ListNode head) {
        if(head==null || head.next==null){return null;}
        if(head.next==head){return head;}
        ListNode slow=head, fast=head.next;
        int slowval=0, fastval=1;
        while(fast!=null && fast.next!=null){
        	slow=slow.next;
        	fast=fast.next.next;
        	slowval++;
        	fastval+=2;
        	if(slow==fast){
        		break;
        	}
        }
        if(fast==null || fast.next==null){return null;}
        int loopsize=fastval-slowval;
        slow=head;
        fast=head;
        for(int i=0;i<loopsize;i++){
        	fast=fast.next;
        }
        while(slow!=fast){
        	slow=slow.next;
        	fast=fast.next;
        }
        return slow;
    }

	public static void main(String[] args) {
		
	}
}

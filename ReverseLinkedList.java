//Reverse a linked list.
//For example:
//Given 1->2->3->4->5->NULL,
//return 5->4->3->2->1->NULL

public class ReverseLinkedList {

	static class ListNode {
	    int val;
	    ListNode next;
	    ListNode(int x) {
	        val = x;
	        next = null;
	    }
	}
	
	public static ListNode reverseLinkedList_while(ListNode head){	// while loop
		if(head==null || head.next==null){return head;}
		ListNode p1=head;
		ListNode p2=head.next;
		p1.next=null;
		while(p2!=null){
			ListNode tmp=p2.next;
			p2.next=p1;
			p1=p2;
			p2=tmp;
		}
		return p1;
	}
	
	public static ListNode reverseLinkedList_recursion(ListNode head){	// recursion
		if(head==null || head.next==null){return head;}
		ListNode newhead=reverseLinkedList_recursion(head.next);
		head.next.next=head;
		head.next=null;
		return newhead;
	}
	
	public static void main(String[] args) {
		ListNode p= new ListNode(1);
		ListNode head=p;
		for(int i=2;i<=10;i++){
			System.out.println(p.val);
			p.next=new ListNode(i);
			p=p.next;
		}
		System.out.println("===");
//		p=reverseLinkedList_while(head);
		p=reverseLinkedList_recursion(head);
		while(p!=null){
			System.out.println(p.val);
			p=p.next;
		}
	}
}

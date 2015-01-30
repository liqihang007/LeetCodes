//Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
//If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
//You may not alter the values in the nodes, only nodes itself may be changed.
//Only constant memory is allowed.
//For example,
//Given this linked list: 1->2->3->4->5
//For k = 2, you should return: 2->1->4->3->5
//For k = 3, you should return: 3->2->1->4->5
	
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

public class ReverseNodesinKGroup {

	private static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	
    public static ListNode reverseKGroup(ListNode head, int k) {
    	if(k<=1){return head;}
    	if(head==null || head.next==null){return head;}
    	ListNode root=new ListNode(0);
    	root.next=head;
    	ListNode pre=root, after=head, revbegin, revend;
    	int p=1;
    	while(after!=null){
    		revbegin=pre.next;
    		revend=revbegin;
    		for(p=1;p<k;p++){
    			revend=revend.next;
    			if(revend==null){return root.next;}
    		}
    		after=revend.next;
    		revend.next=null;
    		pre.next=reverseList(revbegin);
    		revbegin.next=after;
    		pre=revbegin;
    	}
    	return root.next;
    }
    
    public static ListNode reverseList(ListNode head) {
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
    
    public static void main(String[] args) {
		ListNode p= new ListNode(1);
		ListNode head=p;
		for(int i=2;i<=10;i++){
			System.out.println(p.val);
			p.next=new ListNode(i);
			p=p.next;
		}
		System.out.println("===");
		p=reverseKGroup(head,5);
		while(p!=null){
			System.out.println(p.val);
			p=p.next;
		}
	}

}

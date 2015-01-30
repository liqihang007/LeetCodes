//Given a singly linked list L: L0->L1->...->Ln-1->Ln,
//reorder it to: L0->Ln->L1->Ln-1->L2->Ln-2->...
//You must do this in-place without altering the nodes' values.
//For example,
//Given {1,2,3,4}, reorder it to {1,4,2,3}.

public class ReorderList {

	static class ListNode {
	    int val;
	    ListNode next;
	    ListNode(int x) {
	        val = x;
	        next = null;
	    }
	}
	
	public static void reorderList(ListNode head) {
		if(head==null || head.next==null){return;}
		int size=0;
		ListNode p=head, cloneroot=new ListNode(0),cp=cloneroot;
		while(p!=null){
			cp.next=new ListNode(p.val);
			cp=cp.next;
			p=p.next;
			size++;
		}
		ListNode root=new ListNode(0), p1=head, p2=reverseNode(cloneroot.next);
		p=root;
		for(int i=0;i<size/2;i++){
			p.next=p1;
			p1=p1.next;
			p.next.next=p2;
			p=p.next.next;
			
			p2=p2.next;
		}
		if(size%2==1){
			p.next=p1;
			p=p.next;
		}
		p.next=null;
		head=root.next;
    }

	public static ListNode reverseNode(ListNode head){
		if(head==null || head.next==null){return head;}
		ListNode p1=head, p2=head.next;
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
		reorderList(head);
		while(head!=null){
			System.out.println(head.val);
			head=head.next;
		}
	}
}

//Reverse a linked list from position m to n. Do it in-place and in one-pass.
//For example:
//Given 1->2->3->4->5->NULL, m = 2 and n = 4,
//return 1->4->3->2->5->NULL.
//Note:
//Given m, n satisfy the following condition:
//1 <= m <= n <= length of list.

public class ReverseLinkedList2 {
	
	static class ListNode {
	    int val;
	    ListNode next;
	    ListNode(int x) {
	        val = x;
	        next = null;
	    }
	}
	
	public static ListNode reverseBetween(ListNode head, int m, int n) {
        if(m==n){return head;}
        ListNode root=new ListNode(0);
        root.next=head;
        ListNode pre=root, end, after, reversenode;
	    int p=1;
	    for(;p<m;p++){
	    	pre=pre.next;
	    }
	    end=pre;
	    reversenode = pre.next;
	    for(;p<=n;p++){
	    	end=end.next;
	    }
	    after=end.next;
	    end.next=null;
	    pre.next=reverseList(reversenode);
	    while(pre.next!=null){
	    	pre=pre.next;
	    }
	    pre.next=after;
        return root.next;
    }
	
	public static ListNode reverseList(ListNode node){
		if(node.next==null){return node;}
		ListNode p1=node;
		ListNode p2=node.next;
		p1.next=null;
		while(p2!=null){
			ListNode tmp=p2.next;
			p2.next=p1;
			p1=p2;
			p2=tmp;
		}
		return p1;
	}
	
//	
//	public static ListNode reverseBetween(ListNode head, int m, int n) {
//        if(m==n){return head;}
//        ListNode root=new ListNode(0);
//        root.next=head;
//        if(n>m+1){
//	        ListNode pre1=root, pre2;
//	        int p=1;
//	        for(;p<m;p++){
//	        	pre1=pre1.next;
//	        }
//	        ListNode nodem=pre1.next;
//	        ListNode after1=nodem.next;
//	        pre2=pre1;
//	        for(;p<n;p++){
//	        	pre2=pre2.next;
//	        }
//	        ListNode noden=pre2.next;
//	        ListNode after2=noden.next;
//	        pre1.next=noden;
//	        noden.next=after1;
//	        pre2.next=nodem;
//	        nodem.next=after2;
//        }
//        else{
//        	ListNode pre=root, after;
//        	int p=1;
//	        for(;p<m;p++){
//	        	pre=pre.next;
//	        }
//	        ListNode nodem=pre.next;
//	        ListNode noden=nodem.next;
//	        after=noden.next;
//	        pre.next=noden;
//	        noden.next=nodem;
//	        nodem.next=after;
//        }
//        return root.next;
//    }

	public static void main(String[] args) {
		ListNode p= new ListNode(1);
		ListNode head=p;
		for(int i=2;i<=10;i++){
			System.out.println(p.val);
			p.next=new ListNode(i);
			p=p.next;
		}
		System.out.println("===");
		p=reverseBetween(head,4,7);
		while(p!=null){
			System.out.println(p.val);
			p=p.next;
		}
	}
}

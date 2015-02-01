//Given a linked list, swap every two adjacent nodes and return its head.
//For example, Given 1->2->3->4, you should return the list as 2->1->4->3.
//Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.

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

public class SwapNodesinPairs {

	static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	
	public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode temp = head.next;
        head.next = swapPairs(temp.next);
        temp.next = head;
        return temp;
    }
	
//	public ListNode swapPairs(ListNode head) {
//        if(head==null || head.next==null){return head;}
//        ListNode p1=head;
//        ListNode p2=p1.next;
//        ListNode pre;
//        p1.next=p2.next;
//        p2.next=p1;
//        head=p2;
//        pre=p1;
//        if(p1.next!=null){
//        	p1=p1.next;
//        	p2=p1.next;
//        }
//        else{
//        	return head;
//        }
//        while(p2!=null){
//        	swap(pre,p1,p2);
//        	pre=p1;
//        	p1=p1.next;
//        	if(p1==null || p1.next==null){
//        		return head;
//        	}
//        	else{
//        		p2=p1.next;
//        	}
//        }
//        return head;
//    }
//	
//	public void swap(ListNode pre, ListNode node1, ListNode node2){
//		pre.next=node2;
//		node1.next=node2.next;
//		node2.next=node1;
//		pre=node1;
//	}
	
	public static void main(String[] args) {
		SwapNodesinPairs test=new SwapNodesinPairs();
		ListNode p= new ListNode(1);
		ListNode head=p;
		for(int i=2;i<=9;i++){
			System.out.println(p.val);
			p.next=new ListNode(i);
			p=p.next;
		}
		System.out.println("===");
		p=test.swapPairs(head);
		while(p!=null){
			System.out.println(p.val);
			p=p.next;
		}
	}
}

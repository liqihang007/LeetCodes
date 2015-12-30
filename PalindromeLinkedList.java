import InsertionSortList.ListNode;

//Given a singly linked list, determine if it is a palindrome.
//Follow up:
//Could you do it in O(n) time and O(1) space?

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

public class PalindromeLinkedList {

	public boolean isPalindrome(ListNode head) {
		if(head==null || head.next==null) return true;
        int len=0, half;
        ListNode tmp=head, head2;
        while(tmp!=null){
        	tmp=tmp.next;
        	len++;
        }
        tmp=head;
        if(len%2==0){
        	half=len/2;
        	for(int i=0;i<half-1;i++)
            	tmp=tmp.next;
            head2=reverse(tmp.next);
            tmp.next=null;
        }
        else{
        	half=(len-1)/2;
        	for(int i=0;i<half;i++)
            	tmp=tmp.next;
            head2=reverse(tmp.next);
            tmp.next=null;
        }
        tmp=head;
        for(int i=0;i<half;i++)
        	tmp=tmp.next;
        for(int i=0;i<half;i++){
        	if(head.val!=head2.val)
        		return false;
        	else{
        		head=head.next;
        		head2=head2.next;
        	}
        }
        return true;
    }
	
	public ListNode reverse(ListNode node){
		if(node==null || node.next==null)
			return node;
		ListNode p1=node, p2=node.next;
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
		// TODO Auto-generated method stub

	}

}

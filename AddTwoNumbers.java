//You are given two linked lists representing two non-negative numbers. 
//The digits are stored in reverse order and each of their nodes contain a single digit. 
//Add the two numbers and return it as a linked list.
//Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
//Output: 7 -> 0 -> 8

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

public class AddTwoNumbers {

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null){return l2;}
        if(l2==null){return l1;}
        int carry=0;
        int temp=l1.val+l2.val;
        carry=temp/10;
        temp=temp%10;
        ListNode res=new ListNode(temp);
        ListNode p = res;
        l1=l1.next;
        l2=l2.next;
        while(l1!=null && l2!=null){
        	temp=l1.val+l2.val+carry;
        	carry=temp/10;
        	temp=temp%10;
        	p.next=new ListNode(temp);
        	p=p.next;
        	l1=l1.next;
        	l2=l2.next;
        }
        if(l1==null){
        	while(l2!=null){
        		temp=l2.val+carry;
            	carry=temp/10;
            	temp=temp%10;
            	p.next=new ListNode(temp);
            	p=p.next;
            	l2=l2.next;
        	}
        }
        if(l2==null){
        	while(l1!=null){
        		temp=l1.val+carry;
            	carry=temp/10;
            	temp=temp%10;
            	p.next=new ListNode(temp);
            	p=p.next;
            	l1=l1.next;
        	}
        }
        if(carry>0){p.next=new ListNode(carry);}
        return res;
    }
	
	public static void main(String[] args) {
		
	}

}

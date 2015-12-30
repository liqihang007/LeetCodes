import InsertionSortList.ListNode;

//Remove all elements from a linked list of integers that have value val.
//Example
//Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
//Return: 1 --> 2 --> 3 --> 4 --> 5

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

public class RemoveLinkedListElements {

	public ListNode removeElements(ListNode head, int val) {
        if(head==null)
        	return null;
        ListNode Dummy=new ListNode(0);
        Dummy.next=head;
        ListNode p1=Dummy, p2=p1.next;
        while(p2!=null){
        	if(p2.val!=val){
	        	p1=p2;
	        	p2=p1.next;
        	}
        	else{
	        	p1.next=p2.next;
	        	p2=p1.next;
        	}
        }
        return Dummy.next;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

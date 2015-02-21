//Merge k sorted linked lists and return it as one sorted list.

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

public class MergekSortedLists {

	public ListNode mergeKLists(List<ListNode> lists) {
		if(lists.size()==0){return null;}
		return mergeKLists(lists,0,lists.size()-1);
    }
	
	public ListNode mergeKLists(List<ListNode> lists, int a, int b) {
		if(a==b)
            return lists.get(a);
		if(a==b-1)
			return mergeTwoLists(lists.get(a),lists.get(b));
		int mid=(a+b)/2;
		ListNode tmp1= mergeKLists(lists, a, mid);
		ListNode tmp2= mergeKLists(lists, mid+1, b);
		return mergeTwoLists(tmp1,tmp2);
    }
	
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if(l1==null) return l2;
        if(l2==null) return l1;
        ListNode root=new ListNode(0);
        ListNode head=root;
        while(l1!=null && l2!=null){
        	if(l1.val<l2.val){
        		head.next=l1;
        		l1=l1.next;
        	}
        	else{
        		head.next=l2;
        		l2=l2.next;
        	}
        	head=head.next;
        }
        if(l1==null){
        	head.next=l2;
        }
        if(l2==null){
        	head.next=l1;
        }
        return root.next;
    }
	
	public static void main(String[] args) {
		
	}
}

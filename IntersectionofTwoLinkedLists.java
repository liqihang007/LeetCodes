//Write a program to find the node at which the intersection of two singly linked lists begins.
//For example, the following two linked lists:
//A:		  a1 -> a2
//          	 	   \
//						 ->  c1 -> c2 -> c3
//                     /      
//B:	b1 -> b2 -> b3
//begin to intersect at node c1.
//Notes:
//If the two linked lists have no intersection at all, return null.
//The linked lists must retain their original structure after the function returns.
//You may assume there are no cycles anywhere in the entire linked structure.
//Your code should preferably run in O(n) time and use only O(1) memory.


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

public class IntersectionofTwoLinkedLists {

	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null || headB==null){return null;}
        int i=0, j=0;
        ListNode pA=headA, pB=headB;
        while(pA!=null){
        	pA=pA.next;
        	i++;
        }
        while(pB!=null){
        	pB=pB.next;
        	j++;
        }
        boolean which = i>j ? true : false;
        int diff = which ? i-j : j-i;
        if (i==j){diff=0;}
        pA=headA; 
        pB=headB;
        if(which){
        	for(int k=0;k<diff;k++){
        		pA=pA.next;
        	}
        }
        else{
        	for(int k=0;k<diff;k++){
        		pB=pB.next;
        	}
        }
        if(pA==pB){return pA;}
        else{
	        while(pB!=null && pA!=null && pA.next!=pB.next){
	        	pA=pA.next;
	        	pB=pB.next;
	        }
        }
        return pA.next;
    }
	
	public static void main(String[] args) {

	}

}

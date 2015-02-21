import InsertionSortList.ListNode;

//Given a linked list, determine if it has a cycle in it.

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

/*  Proof:
 Suppose there is a loop, say of length L.
 
 Easy case first
 
 To make it easier, first consider the case where the two particles entire loop at the same time. These particles are at the same position whenever n*A = n*B (mod L) for some positive integer n, which is the number of steps until they meet again. Taking n=L gives one solution (though there may be a smaller solution). So after L units of time, particle A has made A trips around the loop to be back at the beginning and particle B has made B trips around the loop to be back at the beginning, where they happily collide.
 
 General Case
 
 Now what happens when they do not enter the loop at the same time? Let A be the slower particle, i.e. A<B, and suppose A enters the loop at time m, and let's call the position at which A enters the loop 0 (since they're in the loop, they can never leave it, so I'm just renaming positions by subtracting A*m, the distance A has traveled after m time units). Then, at that time, B is already at position m*(B-A) (it's real position after m time units is B*m and it's renamed position is therefore B*m-A*m). Then we need to show that there is a time n such that n*A = n*B+m*(B-A) (mod L). That is, we need a solution to the modular equation
 
 (n+m) * (A-B) = 0 (mod L)
 Taking n = k*L-m for k large enough that k*L>m does the trick, though again, there may be a smaller solution.
 
 Therefore, yes, they always meet.
*/

public class LinkedListCycle {

	public boolean hasCycle(ListNode head) {
        if(head==null || head.next==null){return false;}
        ListNode p1=head, p2=head.next;
        while(p2!=null && p2.next!=null){
        	if(p1==p2){
        		return true;
        	}
        	p1=p1.next;
        	p2=p2.next.next;
        }
        return false;
    }
	
	public static void main(String[] args) {
		
	}

}

//A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
//Return a deep copy of the list.

/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */

import java.util.*;

public class CopyListwithRandomPointer {

	public RandomListNode copyRandomList(RandomListNode head) {
        if(head==null){return head;}
        HashMap<RandomListNode,RandomListNode>hash=new HashMap<RandomListNode,RandomListNode>();
        RandomListNode newhead=new RandomListNode(head.label);
        RandomListNode p1=newhead;
        RandomListNode p2=head.next;
        hash.put(head,newhead);
        while(p2!=null){        	
        	p1.next=new RandomListNode(p2.label);
        	p1=p1.next;
        	hash.put(p2,p1); // map old node to new node
        	p2=p2.next;
        }
        p1=newhead;
        p2=head;
        while(p2!=null){
        	if(p2.random!=null){
        		p1.random=hash.get(p2.random);
        	}
        	p1=p1.next;
        	p2=p2.next;
        }
        return newhead;
    }
	
	public static void main(String[] args) {
		
	}
}

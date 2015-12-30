//Implement the following operations of a queue using stacks.
//push(x) -- Push element x to the back of queue.
//pop() -- Removes the element from in front of queue.
//peek() -- Get the front element.
//empty() -- Return whether the queue is empty.
//Notes:
//You must use only standard operations of a stack -- which means only push to top, peek/pop from top, size, and is empty operations are valid.
//Depending on your language, stack may not be supported natively. 
//You may simulate a stack by using a list or deque (double-ended queue), as long as you use only standard operations of a stack.
//You may assume that all operations are valid (for example, no pop or peek operations will be called on an empty queue).

import java.util.*;

public class ImplementQueueusingStacks {
	
	Stack<Integer> s1=new Stack<Integer>();
	Stack<Integer> s2=new Stack<Integer>();

	public void push(int x) {
        s1.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
    	while(!s1.isEmpty()){
    		int tmp=s1.pop();
    		s2.push(tmp);
    	}
        s2.pop();
        while(!s2.isEmpty()){
    		int tmp=s2.pop();
    		s1.push(tmp);
    	}
    }

    // Get the front element.
    public int peek() {
    	while(!s1.isEmpty()){
    		int tmp=s1.pop();
    		s2.push(tmp);
    	}
        int res=s2.peek();
        while(!s2.isEmpty()){
    		int tmp=s2.pop();
    		s1.push(tmp);
    	}
        return res;
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return s1.isEmpty();
    }

}

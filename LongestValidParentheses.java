//Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
//For "(()", the longest valid parentheses substring is "()", which has length = 2.
//Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.

import java.util.*;

public class LongestValidParentheses {

	public static int longestValidParentheses(String s) {
        if(s==null || s.length()<2){return 0;}
        Stack<Integer> stack = new Stack<Integer>();
        int res=0;
        int left=-1;
        for(int i=0;i<s.length();i++){
        	if(s.charAt(i)=='(')
        		stack.push(i);
        	else{	// s.charAt(i)=')'
        		if(stack.isEmpty())
        			left=i;
        		else{
        			stack.pop();
        			if(stack.isEmpty())
        				res=Math.max(res, i-left);
        			else
        				res=Math.max(res, i-stack.peek());
        		}
        	}
        }
        return res;
    }

	public static void main(String[] args) {
		System.out.println(longestValidParentheses("()"));
		System.out.println(longestValidParentheses("((((("));
		System.out.println(longestValidParentheses("))))))"));
		System.out.println(longestValidParentheses("((()()(()((()"));
		System.out.println(longestValidParentheses("(()"));
		System.out.println(longestValidParentheses("(()()"));
	}

}

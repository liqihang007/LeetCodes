//Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
//The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.

import java.util.*;

public class ValidParentheses {

	public boolean isValid(String s) {
        Stack <Integer> stack = new Stack<Integer>();
        for (int i=0;i<s.length();i++){
            int sign=0;
            if(s.charAt(i)=='('){sign=1;}
            if(s.charAt(i)=='['){sign=2;}
            if(s.charAt(i)=='{'){sign=3;}
            if(s.charAt(i)==')'){sign=-1;}
            if(s.charAt(i)==']'){sign=-2;}
            if(s.charAt(i)=='}'){sign=-3;}
            if(!stack.isEmpty() && stack.peek()==sign*-1){
                stack.pop();
            }
            else{
                stack.push(sign);
            }
        }
        if(stack.isEmpty()){return true;}
        else{return false;}
    }
	
	public static void main(String[] args) {
		
	}

}

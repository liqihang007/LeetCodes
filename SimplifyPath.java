//Given an absolute path for a file (Unix-style), simplify it.
//For example,
//path = "/home/", => "/home"
//path = "/a/./b/../../c/", => "/c"
//Corner Cases:
//Did you consider the case where path = "/../"?
//In this case, you should return "/".
//Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
//In this case, you should ignore redundant slashes and return "/home/foo".
		
import java.util.*;

public class SimplifyPath {

	public static String simplifyPath(String path) {
        String[] strs=path.split("/");
        Stack<String> stack=new Stack<String>();
        for(int i=0;i<strs.length;i++){
        	if(strs[i].length()==0){
        		continue;
        	}
        	if(strs[i].equals(".")){
        		continue;
        	}
        	if(strs[i].equals("..")){
        		if(!stack.isEmpty()){
        			stack.pop();
        		}
        		continue;
        	}
        	stack.push(strs[i]);
        }
        String res="";
        while(!stack.isEmpty()){
        	res="/"+stack.pop()+res;
        }
        if(res.length()==0){return "/";}
        return res;
    }
	
	public static void main(String[] args) {
		System.out.println(simplifyPath("/abc/.../"));
	}

}

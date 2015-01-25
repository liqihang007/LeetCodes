//Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
//For example, given n = 3, a solution set is:
//"((()))", "(()())", "(())()", "()(())", "()()()"

import java.util.*;

public class GenerateParentheses {

	public static List<String> generateParenthesis(int n) {
		List<String> res=new ArrayList<String>();
		if(n==0){
			res.add(null);
			return res;
		}
		if(n>=1){
			res.add("()");
		}
		for(int i=2;i<=n;i++){
			HashSet<String> sub=new HashSet<String>();
			for(int j=0;j<res.size();j++){
				String temp=res.get(j);
				for(int k=0;k<=temp.length();k++){
					StringBuilder newstring=new StringBuilder(temp);
					newstring.insert(k,"()");
					sub.add(newstring.toString());
				}
			}
			res=new ArrayList<String>(sub);
		}
		return res;
    }
	
	public static void main(String[] args) {
		System.out.println(generateParenthesis(3));
	}

}

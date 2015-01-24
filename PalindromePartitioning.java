//Given a string s, partition s such that every substring of the partition is a palindrome.
//Return all possible palindrome partitioning of s.
//For example, given s = "aab",
//Return
//  [
//    ["aa","b"],
//    ["a","a","b"]
//  ]
		  
import java.util.*;

public class PalindromePartitioning {

	public static List<List<String>> partition(String s) {
		List<List<String>> res = new ArrayList<List<String>>();
		if(s==null || s.length()==0){return res;}
		ArrayList<String> sub = new ArrayList<String>();
		findpart(s, sub, res);
		return res;
    }
	
	public static void findpart(String s, ArrayList<String> sub, List<List<String>> res){
		if(s.length()>0){
			for(int i=1;i<=s.length();i++){
				if(check(s.substring(0,i))){
					if(i==s.length()){
						sub.add(s.substring(0,i));
						res.add(sub);
						return;
					}
					else{
						ArrayList<String> sub2= new ArrayList<String>(sub);
						sub2.add(s.substring(0,i));
						findpart(s.substring(i,s.length()),sub2,res);
					}
				}
			}
		}
		return;
	}
	
	public static boolean check(String s){
		if(s.length()==0){return false;}
		else{
			int i=0,j=s.length()-1;
			while(i<j){
				if(s.charAt(i)==s.charAt(j)){i++;j--;}
				else{return false;}
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		System.out.println(partition("abcbaa"));
		System.out.println(partition("abb"));
		System.out.println(partition("aaa"));
	}

}

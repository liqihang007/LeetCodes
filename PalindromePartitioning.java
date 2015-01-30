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
		ArrayList<String> list = new ArrayList<String>();
		findpart_DP(res, new ArrayList<String>(), s, 0, checkpal_DP(s));
//		findpart(res, new ArrayList<String>(), s, 0);
		return res;
    }
	
	public static void findpart_DP(List<List<String>> res, ArrayList<String> list,
			String s, int pos, boolean[][]table){
		if(pos>=s.length()){
			res.add(new ArrayList<String>(list));
			return;
		}
		for(int i=pos;i<s.length();i++){
			if(table[pos][i]){
				list.add(s.substring(pos,i+1));
				findpart_DP(res, list, s, i+1, table);
				list.remove(list.size()-1);
			}
		}
	}
	
	public static void findpart(List<List<String>> res, ArrayList<String> list, String s, int pos){
		if(pos>=s.length()){
			res.add(new ArrayList<String>(list));
			return;
		}
		for(int i=pos+1;i<=s.length();i++){
			if(checkpal(s.substring(pos,i))){
				list.add(s.substring(pos,i));
				findpart(res, list, s, i);
				list.remove(list.size()-1);
			}
		}
	}
	
	public static boolean checkpal(String s){	// non-DP
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
	
	public static boolean[][] checkpal_DP(String s){	// DP, table[i][j] -> if s.sub(i,j) is pal
		int n=s.length();
		boolean[][] table=new boolean[n][n];
		char[] chars=s.toCharArray();
		for(int i=n-1;i>=0;i--){
			for(int j=i;j<n;j++){
				if(i==j){table[i][j]=true;}
				else if(j-i==1){
					table[i][j]=(chars[i]==chars[j]);
				}
				else{
					table[i][j]=(chars[i]==chars[j] && table[i+1][j-1]);
				}
			}
		}
		return table;
	}
	
	public static void main(String[] args) {
		System.out.println(partition("abcbaa"));
		System.out.println(partition("abb"));
		System.out.println(partition("aaa"));
	}

}

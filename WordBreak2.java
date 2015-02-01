//Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary word.
//Return all such possible sentences.
//For example, given
//s = "catsanddog",
//dict = ["cat", "cats", "and", "sand", "dog"].
//A solution is ["cats and dog", "cat sand dog"].

import java.util.*;

public class WordBreak2 {

	public static List<String> wordBreak(String s, Set<String> dict) {
		List<String>res=new ArrayList<String>();
		if(s==null || s.length()==0 || dict==null || dict.size()==0){
			return res;
		}
		if(!canBreak(s, dict)){
			return res;
		}
		check(res,"",s,0,dict);
		return res;
    }
	
	public static void check(List<String>res, String ans, String s, int pos, Set<String> dict){
		if(pos==s.length()){
			ans=ans.substring(1);
			res.add(ans);
			return;
		}
		for(int i=pos;i<s.length();i++){
			String sub=s.substring(pos,i+1);
			if(dict.contains(sub)){
				String tmp=ans;
				ans+=" "+sub;
				check(res,ans,s,i+1,dict);
				ans=tmp;
			}
		}
	}
	
	public static boolean canBreak(String s, Set<String> dict){
		boolean [] dp=new boolean[s.length()+1];
		dp[0]=true;
		for(int i=1;i<=s.length();i++){
			for(int j=i-1;j>=0;j--){
				if(dp[j] && dict.contains(s.substring(j,i))){
					dp[i]=true;
				}
			}
		}
		return dp[s.length()];
	}
	
	public static void main(String[] args) {
		
	}
}

//Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.
//For example, given
//s = "leetcode",
//dict = ["leet", "code"].
//Return true because "leetcode" can be segmented as "leet code".

import java.util.*;

public class WordBreak {

	public boolean wordBreak(String s, Set<String> dict) {
        boolean [] check = new boolean[s.length()+1];
        Arrays.fill(check, false);
        check[0]=true;
        for(int i=1;i<=s.length();i++){
        	for(int j=i-1;j>=0;j--){
        		if(check[j]==true && dict.contains(s.substring(j,i))){
        			check[i]=true;
        			break;
        		}
        	}
        }
        return check[s.length()];
    }

	public static void main(String[] args) {
		
	}

}

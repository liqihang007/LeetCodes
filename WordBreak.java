//Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.
//For example, given
//s = "leetcode",
//dict = ["leet", "code"].
//Return true because "leetcode" can be segmented as "leet code".

import java.util.*;

public class WordBreak {

	public boolean wordBreak(String s, Set<String> dict) {
        boolean [] check = new boolean[s.length()+1];
        check[0]=true;
        int maxLength = getMaxLength(dict);
        for(int i=1;i<=s.length();i++){
        	for(int j=i-1;j>=0 && j>=i-maxLength;j--){
        		if(check[j] && dict.contains(s.substring(j,i))){
        			check[i]=true;
        			break;
        		}
        	}
        }
        return check[s.length()];
    }

	public int getMaxLength(Set<String> dict) {
        int maxLength = 0;
        for (String word : dict)
            maxLength = Math.max(maxLength, word.length());
        return maxLength;
    }
	
	public static void main(String[] args) {
		
	}

}

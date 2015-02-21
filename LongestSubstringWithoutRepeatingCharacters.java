//Given a string, find the length of the longest substring without repeating characters. 
//For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3. 
//For "bbbbb" the longest substring is "b", with the length of 1.

import java.util.*;

public class LongestSubstringWithoutRepeatingCharacters {

	public static int lengthOfLongestSubstring(String s) {
        if(s==null){return 0;}
        if(s.length()<=1){return s.length();}
        HashMap<Character,Integer> hash = new HashMap<Character,Integer>();
        int begin=0,end=0,res=0;
        for(int i=0;i<s.length();i++){
        	if(hash.containsKey(s.charAt(i))){
                res=Math.max(res,i-begin);
                begin=Math.max(begin, hash.get(s.charAt(i))+1);
        		hash.put(s.charAt(i), i);
        	}
        	else{
        		hash.put(s.charAt(i), i);
        	}
        }
        res=Math.max(res,s.length()-begin);
        return res;
    }
	
	public static void main(String[] args) {
//		System.out.println(lengthOfLongestSubstring("ababcdabcbb"));
//		System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("ctclemwwlexnkvwizzoyctqlnzxoetyioavsorrbvoqflpqlqgluzdgoefckaatpdohtgaxdqnlceb"));
	}
}

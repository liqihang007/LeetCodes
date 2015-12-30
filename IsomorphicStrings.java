//Given two strings s and t, determine if they are isomorphic.
//Two strings are isomorphic if the characters in s can be replaced to get t.
//All occurrences of a character must be replaced with another character while preserving the order of characters. 
//No two characters may map to the same character but a character may map to itself.
//For example,
//Given "egg", "add", return true.
//Given "foo", "bar", return false.
//Given "paper", "title", return true.
//Note:
//You may assume both s and t have the same length.

import java.util.*;

public class IsomorphicStrings {

	public static boolean isIsomorphic(String s, String t) {
        if(s.length()==0 && t.length()==0)
        	return true;
        HashMap<Character, Character>map=new HashMap<Character, Character>();
        for(int i=0;i<s.length();i++){
        	if(map.containsKey(s.charAt(i))){
        		if(map.get(s.charAt(i))!=t.charAt(i))
        			return false;
        	}
        	else{
        		if(map.containsValue(t.charAt(i)))
        			return false;
        		else
        			map.put(s.charAt(i), t.charAt(i));
        	}
        }
        return true;
    }

	public static void main(String[] args) {
		System.out.println(isIsomorphic("egg","add"));
		System.out.println(isIsomorphic("foo","bar"));
		System.out.println(isIsomorphic("paper","title"));
	}

}

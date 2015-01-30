//Given an array of strings, return all groups of strings that are anagrams.

import java.util.*;

public class Anagrams {

	public static List<String> anagrams(String[] strs) {
		List<String>res=new ArrayList<String>();
        if(strs.length<=1){return res;}
        HashMap<String,List<Integer>>hash=new HashMap<String,List<Integer>>();
        for(int i=0;i<strs.length;i++){
        	String s=strs[i];
        	char[] chars = s.toCharArray();
        	Arrays.sort(chars);
        	s = String.valueOf(chars);
        	if(hash.containsKey(s)){
        		hash.get(s).add(i);
        	}
        	else{
        		List<Integer> tmp=new ArrayList<Integer>();
        		tmp.add(i);
        		hash.put(s,tmp);
        	}
        }
        for(String i : hash.keySet()){
        	if(hash.get(i).size()>1){
        		for(int j : hash.get(i)){
        			res.add(strs[j]);
        		}
        	}
        }
        return res;
    }
	
	public static void main(String[] args) {
		String[] strs={"c","c"};
		System.out.println(anagrams(strs));
	}

}

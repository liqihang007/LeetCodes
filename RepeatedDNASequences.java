//All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG". 
//When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.
//Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.
//For example,
//Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",
//Return:
//["AAAAACCCCC", "CCCCCAAAAA"].

import java.util.*;

public class RepeatedDNASequences {
	public List<String> findRepeatedDnaSequences(String s) {
		List<String> list= new ArrayList();
        if(s==null || s.length()<10)
            return list;
        int start=0, end=10;
        Set<String> set1=new HashSet();
        Set<String> set2=new HashSet();
        while(end<=s.length()){
            String str=s.substring(start,end);
            if(!set1.contains(str)) 
                set1.add(str);
            else
                set2.add(str);
            start++;
            end++;
        }
        list.addAll(set2);
        return list;
    }
}

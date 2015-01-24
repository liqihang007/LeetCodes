//Given a roman numeral, convert it to an integer.
//Input is guaranteed to be within the range from 1 to 3999.

import java.util.*;

public class RomantoInteger {

	public static int romanToInt(String s) {
        HashMap<Character,Integer> map=new HashMap<Character,Integer>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        int res=0;
        for(int i=0;i<s.length()-1;i++){
        	if(map.get(s.charAt(i+1))>map.get(s.charAt(i))){
        		res-=map.get(s.charAt(i));
        	}
        	else{
        		res+=map.get(s.charAt(i));
        	}
        }
        res+=map.get(s.charAt(s.length()-1));
        return res;
    }

	public static void main(String[] args) {
		System.out.println(romanToInt("MMXIV"));
	}

}

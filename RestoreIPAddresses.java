//Given a string containing only digits, restore it by returning all possible valid IP address combinations.
//For example:
//Given "25525511135",
//return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)

import java.util.*;

public class RestoreIPAddresses {

	public static List<String> restoreIpAddresses(String s) {
		List<String>res=new ArrayList<String>();
		if(s==null || s.length()<4 || s.length()>12){return res;}
		check(res, "", s, 0, 0);
		return res;
    }
	
	public static void check(List<String>res, String path, String s , int pos, int count){
		if(count>4){return;}
		if (count==4 && pos==s.length()) {
            res.add(path.substring(1));
	        return;
	    }
	    for (int i=pos; i<s.length(); i++) {
	        if (i-pos>= 3) break;
	        if (isValidNum(s.substring(pos, i+1))) {
                String newPath = path + "." + s.substring(pos, i+1);
                check(res, newPath, s, i+1, count+1);
            }
	    }
	}
	
	public static boolean isValidNum(String s){
		if(s.length()>1 && s.charAt(0)=='0'){
			return false;
		}
		int num=Integer.parseInt(s);
		if(num>=0 && num <=255){
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		String x="010010";
		System.out.println(restoreIpAddresses(x));
		
	}
}

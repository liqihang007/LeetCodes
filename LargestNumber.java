//Given a list of non negative integers, arrange them such that they form the largest number.
//For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.
//Note: The result may be very large, so you need to return a string instead of an integer.

import java.util.*;

public class LargestNumber {
	
	public static String largestNumber(int[] num) {
		ArrayList<String> list=new ArrayList<String>();
		for(int i : num){
			list.add(String.valueOf(i));
		}
        Collections.sort(list,new Comparator<String>(){
            public int compare(String a, String b){
                if(a.length()==b.length()){
                    return b.compareTo(a);
                }
                else{
                    String ab=a+b;
                    String ba=b+a;
                    return ba.compareTo(ab);
                }
            }
        });
		String res="";
		for(int i=0;i<list.size();i++){
			res+=list.get(i);
		}
		if(res.charAt(0)=='0' || res.length()<=0) {return "0";}
		return res;
    }
	
	public static void main(String[] args) {
		System.out.println(largestNumber(new int[]{3, 30, 34, 5, 9}));
	}

}

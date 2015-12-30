//Write an algorithm to determine if a number is "happy".
//A happy number is a number defined by the following process: 
//Starting with any positive integer, replace the number by the sum of the squares of its digits,
//and repeat the process until the number equals 1 (where it will stay), 
//or it loops endlessly in a cycle which does not include 1. 
//Those numbers for which this process ends in 1 are happy numbers.
//Example: 19 is a happy number
//
//1^2 + 9^2 = 82
//8^2 + 2^2 = 68
//6^2 + 8^2 = 100
//1^2 + 0^2 + 0^2 = 1

import java.util.*;

public class HappyNumber {

	public static boolean isHappy(int n) {
        HashSet<Integer>set=new HashSet<Integer>();
        int res=0, tmp=n;
        while(res!=1){
        	res=0;
	        while(tmp!=0){
	        	res+=Math.pow(tmp%10,2);
	        	tmp/=10;
	        }
//	        System.out.println(res);
	        if(set.contains(res))
	        	return false;
	        else
	        	set.add(res);
	        tmp=res;
        }
        if(res==1)
        	return true;
        else
        	return false;
    }

	public static void main(String[] args) {
		System.out.println(isHappy(18));
		System.out.println(isHappy(19));
		System.out.println(isHappy(20));
	}

}

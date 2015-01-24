//Implement atoi to convert a string to an integer.
//Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.
//Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front.
//spoilers alert... click to show requirements for atoi.
//Requirements for atoi:
//The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.
//The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.
//If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.
//If no valid conversion could be performed, a zero value is returned. If the correct value is out of the range of representable values, INT_MAX (2147483647) or INT_MIN (-2147483648) is returned.

import java.util.*;

public class StringtoIntegerATOI {

	public static int atoi(String str) {
        str=str.trim();
        if(str.length()==0){return 0;}
        int sign=0;
        if(str.charAt(0)=='-'){sign=-1;};
        if(str.charAt(0)=='+'){sign=1;};
        if(sign!=0){str=str.substring(1);}
//        System.out.println(str+" "+sign);
        if(str.length()==0){return 0;}
        int valid=0;
        for(int i=0;i<str.length();i++){
        	char d = str.charAt(i);
        	if(!Character.isDigit(d)){
        		valid=i;
        		break;
        	}
        }
        if(valid!=0){str=str.substring(0, valid);}
        int res=0;
        try{
	        for(int i=0;i<str.length();i++){
	        	char d = str.charAt(i);
//	        	if(d==' '){continue;}
	        	if(!Character.isDigit(d)){return 0;}
	        	else{
	        		if(sign==-1){
	        			res=(int) (res-(int)(d-'0')*Math.pow(10,str.length()-i-1));
	        		}
	        		else{
	        			res=(int) (res+(int)(d-'0')*Math.pow(10,str.length()-i-1));
	        		}
	        		System.out.println(d);
	        	}
	        }
	        return res;
        }catch (Exception e){
        	System.out.println(e);
        	if (sign==-1) {return Integer.MIN_VALUE;}
        	if (sign==1) {return Integer.MAX_VALUE;}
        	else {return 0;}
        }
    }
	public static void main(String[] args) {
		System.out.println(atoi("-1"));
	}

}

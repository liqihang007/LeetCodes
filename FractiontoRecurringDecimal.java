//Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.
//If the fractional part is repeating, enclose the repeating part in parentheses.
//For example,
//Given numerator = 1, denominator = 2, return "0.5".
//Given numerator = 2, denominator = 1, return "2".
//Given numerator = 2, denominator = 3, return "0.(6)".

import java.util.*;

public class FractiontoRecurringDecimal {

	public static String fractionToDecimal(int numerator, int denominator) {
		String res = "";
		long a = Math.abs((long) numerator);
		long b = Math.abs((long) denominator);
	    if ((denominator < 0 && numerator > 0) || (denominator > 0 && numerator < 0)) {
	        res += "-";
	    }
	    long intPart= a / b;
	    
	    res += intPart;
	    if (a % b == 0) {
	        return res;
	    }
	    res += ".";
	    long remainder = a % b;
	    HashMap<Long,Integer> hash = new HashMap<Long,Integer>();
	    List<Long> list = new ArrayList<Long>();
	    int begin=0, end=0;
	    while(remainder!=0){
	    	hash.put(remainder,end);
	    	end++;
	    	long digit=remainder*10/b;
	    	remainder=remainder*10%b;
	    	list.add(digit);
	    	if(hash.containsKey(remainder)){
	    		begin=hash.get(remainder);
	    		break;
	    	}
	    	else{
	    		hash.put(remainder,end);
	    	}
	    }
//	    System.out.println(list);
//	    System.out.println(begin+" "+end);
	    if(remainder==0){
	    	for(int k=0;k<list.size();k++){
	    		res += list.get(k);
	    	}
	    }
	    else{
	    	for(int k=0;k<begin;k++){
	    		res += list.get(k);
	    	}
	    	res += "(";
	    	for(int k=begin;k<end;k++){
	    		res += list.get(k);
	    	}
	    	res += ")";
	    }
		return res;
    }
	
	public static void main(String[] args) {
		int a=-1;
		int b=-2147483648;
		System.out.println((double)a/b);
		System.out.println(fractionToDecimal(a,b));
	}

}

//1. for the input integer: positive and negative number matters? => yes, so check the sign first
//2. can get integer part directly by a/b, then deal with decimal part
//3. get remainder by a%b. the problem is: how to check the decimal part is repeated (or not)?
//4. for each loop, we can get the digit by remainder*10/b and update new remainder=remainder*10%b, if we get the same remainder again, previous result is repeated
//5. so, use a set to store the remainder(s) that already appeared and use queue to store int sequence that need to append to res
//6. check remainder for each loop, if 0, poll all elem in queue, if set contains the remainder (q...)
//7. but... the question comes again: example, if result is 0.123454545 or 1/7 = 0.123454545, need a parameter to store which digit the res starts to repeat.. extra info is needed when we store the remainder to "locate" its position
//8. back to step 5, define the map instead of set to store <remainder, position> position=i (each loop i++)
//9. at last, check the remainder to know whether it's belong to "recurring" result or not
//Given an integer, convert it to a roman numeral.
//Input is guaranteed to be within the range from 1 to 3999.

import java.util.*;

public class IntegertoRoman {

	public static String intToRoman(int num) {
        int [] numbers=new int[]{1,4,5,9,10,40,50,90,100,400,500,900,1000};
        String[] romans=new String[]{"I","IV","V","IX","X","XL","L","XC","C","CD","D","CM","M"};
        String res="";
        for(int i=numbers.length-1;i>=0;i--){
        	int k=num/numbers[i];
        	num=num%numbers[i];
        	for(int j=0;j<k;j++){
        		res=res+romans[i];
        	}
        }
        return res;
    }

	public static void main(String[] args) {
		System.out.println(intToRoman(99)); //XCIX 10 100 1 10
	}

}

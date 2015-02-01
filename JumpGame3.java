//You are given an array of non-negative integers (0, 1, 2 etc). 
//The value in each element represents the number of hops you may take to the next destination. 
//Write a function that determines when you start from the first element whether you will be able to reach the last element of the array. 
//if a value is 3, you can take either 0, 1, 2 or 3 hops. 
//For eg: for the array with elements 1, 2, 0, 1, 0, 1, any route you take from the first element, you will not be able to reach the last element.

import java.util.*;

public class JumpGame3 {

	public boolean jump(int[] num){
		if(num==null || num.length==0)return{false;}
		if(num.length==1){return true;}
		int res=0;
		for(int i=0;i<num.length && i<=res;i++){
			if(res<num[i]+i){res=num[i]+i;}
			if(res>=num.length-1){
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

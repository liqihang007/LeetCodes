//Given an array of positive numbers, find the maximum sum of a subsequence that no 2 numbers should be adjacent.
//Eg. (3, 2, 7, 10) should return 13 (3+10)
//Eg. (3, 2, 5, 10, 7) should return 15 (3+5+7).

/*
Loop for all elements in arr[] and maintain two sums 'incl' and 'excl' where:
incl = Max sum including the previous element
excl = Max sum excluding the previous element

res[i]=max(res[i-1], res[i-2]+A[i])
 */

import java.util.*;

public class MaximumSumSuchThatNoTwoElementsAreAdjacent {

	public static int MaximumSumSuchThatNoTwoElementsAreAdjacent(int[]num){	//O(n)+O(n)
		if(num.length==0)
            return 0;
		if(num.length==1)
            return num[0];
		if(num.length==2)
            return Math.max(num[0], num[1]);
		int[]res=new int[num.length];
		res[0]=num[0];
		res[1]=num[1];
		for(int i=2;i<num.length;i++){
			res[i]=Math.max(res[i-1], res[i-2]+num[i]);
		}
		return res[res.length-1];
	}
	
	public static int MaximumSumSuchThatNoTwoElementsAreAdjacent_O1space(int[]num){	//O(n)+O(1)
		if(num.length==0){return 0;}
		if(num.length==1){return num[0];}
		if(num.length==2){return Math.max(num[0], num[1]);}
		int pp=num[0];
		int p=num[1];
		int res=0;
		for(int i=2;i<num.length;i++){
			if(pp+num[i]>p){
				res=pp+num[i];
			}
			else{res=p;}
			pp=p;
			p=res;
		}
		return res;
	}
	
	public static void main(String[] args) {
		System.out.println(MaximumSumSuchThatNoTwoElementsAreAdjacent(new int[]{3,2,5,10,7}));
		System.out.println(MaximumSumSuchThatNoTwoElementsAreAdjacent_O1space(new int[]{3,2,5,10,7}));
	}

}

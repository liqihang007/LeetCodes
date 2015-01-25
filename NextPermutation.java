//Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
//If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
//The replacement must be in-place, do not allocate extra memory.
//Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
//1,2,3 -> 1,3,2
//3,2,1 -> 1,2,3
//1,1,5 -> 1,5,1

import java.util.*;

public class NextPermutation {

	public static void nextPermutation(int[] num) {
        if(num.length>1){
	        int i=num.length-1,j=i-1;
			while(num[j]>=num[i]){
				i--;j--;
				if(j<0){
					break;
				}
			}
			if (j<0){
				Arrays.sort(num);
			}
			else{
				int diff=Integer.MAX_VALUE;
				int which=j;
				for(int k=j+1;k<num.length;k++){
					if(num[k]>num[j] && num[k]-num[j]<diff){
						diff=num[k]-num[j];
						which=k;
						System.out.println(diff+" "+which);
					}
				}
				int temp=num[which];
				num[which]=num[j];
				num[j]=temp;
				int[] temparray=new int[num.length-1-j];
				for(int k=0;k<temparray.length;k++){
					temparray[k]=num[j+k+1];
				}
				Arrays.sort(temparray);
				for(int k=0;k<temparray.length;k++){
					num[j+k+1]=temparray[k];
				}
			}
        }
    }
	
	public static void main(String[] args) {
		int[]A=new int[]{5,1,1};
		nextPermutation(A);
		System.out.println(Arrays.toString(A));
	}

}

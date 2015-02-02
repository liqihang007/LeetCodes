//You have a sorted array containing the age of every person on Earth. 
//[0, 0, 0, 0, ..., 1, 1, ..., 28, 28, ..., 110, ...] 
//Find out how many people have each age.

import java.util.*;

public class AgeofEveryPersononEarth {	// m*logn, where m is number of unique ages and n is number of elements
	
	public static int[] countAge(int[] input) {
		int[] count = new int[input[input.length-1]+1];
		bst(input, 0, input.length-1, count);
		return count;
	}
		
	private static void bst(int[] input, int begin, int end, int[] count) {
		if (input[begin] == input[end]) {
			count[input[begin]] += end-begin+1;
		}
		else {
			bst(input, begin, (begin+end)/2, count);
			bst(input, (begin+end)/2 + 1, end, count);
		}		
	}
	
	public static void main(String[] args) {
		int[]A=new int[]{0,0,0,0,1,1,1,1,1,1,3,3,3,3,4,4,4,4,5,5,5,6,6,6,6,
				7,7,7,7,8,8,8,8,8,8,8,9,9,9,9,9,12,12,16,44,44,47,48};
		System.out.println(Arrays.toString(countAge(A)));
	}
}

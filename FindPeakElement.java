//A peak element is an element that is greater than its neighbors.
//Given an input array where num[i] != num[i+1], find a peak element and return its index.
//The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.
//You may imagine that num[-1] = num[n] = -inf.
//For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.
//Note: Your solution should be in logarithmic complexity.

import java.util.*;

public class FindPeakElement {

	public static int findPeakElement(int[] num) {
        if (num==null || num.length==0) return 0;
        int i=0, j=num.length-1;
        while(i<j-1){
        	int mid=(i + j)/2;
        	if(num[mid]>num[mid-1] && num[mid]>num[mid+1])
        		return mid;
        	if(num[mid]>num[mid+1])
        		j=mid+1;
        	if(num[mid]<num[mid+1])
        		i=mid;
        }
        return -1;
	}
	
	public static void main(String[] args) {
		System.out.println(findPeakElement(new int[]{1,5,4,5,6,7,8,6}));
	}
}

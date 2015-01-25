//A peak element is an element that is greater than its neighbors.
//Given an input array where num[i] != num[i+1], find a peak element and return its index.
//The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.
//You may imagine that num[-1] = num[n] = -inf.
//For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.
//Note: Your solution should be in logarithmic complexity.

import java.util.*;

public class FindPeakElement {

	public static int findPeakElement(int[] num) {
        int myreturn=0;
        if (num.length>1){
        	myreturn=finddiff(num,0,num.length-1);
        }
        return myreturn;
    }
	
	public static int finddiff(int[] num, int x, int y){
		if(x>=y){
			return x;
		}
		if(x==y-1){
			if(num[x]>num[y]){
        		return x;
        	}
        	else{
        		return y;
        	}
		}
		else{
			int mid=(int)((int)(x+y)*0.5);
			int left=finddiff(num, x, mid);
			int right=finddiff(num, mid+1, y);
			if (num[left]>num[right]){
				return left;
			}
			else{
				return right;
			}
		}
	}
	
//	public int findPeakElement(int[] num) {
//        for (int i = 0, j = num.length - 1, mid = j / 2; i < j; mid = (i + j) / 2) {
//            if (mid == i) { 
//					return num[mid] > num[j] ? mid : j; 
//				}
//            i = num[mid] < num[mid + 1] ? mid : i;
//            j = num[mid] > num[mid + 1] ? mid : j;
//        }
//        return 0;
//    }
	
	public static void main(String[] args) {
		System.out.println(findPeakElement(new int[]{1,2,1,1,1,1,2}));

	}

}

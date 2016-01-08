//Write a program to find the n-th ugly number.
//Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. 
//For example, 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.
//Note that 1 is typically treated as an ugly number.

import java.util.*;

public class UglyNumber2 {
	
	// three lists:
	// (1) 1x2, 2x2, 3x2, 4x2, 5x2, ...
	// (2) 1x3, 2x3, 3x3, 4x3, 5x3, ...
	// (3) 1x5, 2x5, 3x5, 4x5, 5x5, ...
	// O(n) time, O(n) space 
	
	public static int nthUglyNumber(int n) {
		int[] d=new int[n];
		Arrays.fill(d, 0);
	    d[0]=1;
	    int f2=2, f3=3, f5=5;     // min values for multipy factor 2, 3, 5
	    int i2=0, i3=0, i5=0;  // indexs for min values of f2, f3, f5 
	    for (int i=1; i<n; i++) {
	        int minV=Math.min(Math.min(f2, f3), f5);
	        d[i]=minV;
	        if (minV==f2)
	        	f2=2*d[++i2];
	        if (minV==f3) 
	        	f3=3*d[++i3];
	        if (minV==f5) 
	        	f5=5*d[++i5];
	    }
	    return d[n-1];
    }
	
	public static void main(String[] args) {
		System.out.println(nthUglyNumber(12));

	}
}

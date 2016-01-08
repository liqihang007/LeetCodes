//Write a program to find the nth super ugly number.
//Super ugly numbers are positive numbers whose all prime factors are in the given prime list primes of size k. 
//For example, [1, 2, 4, 7, 8, 13, 14, 16, 19, 26, 28, 32] is the sequence of the 
//first 12 super ugly numbers given primes = [2, 7, 13, 19] of size 4.
//Note:
//(1) 1 is a super ugly number for any given primes.
//(2) The given numbers in primes are in ascending order.
//(3) 0 < k <= 100, 0 < n <= 10^6, 0 < primes[i] < 1000.

import java.util.*;

public class SuperUglyNumber {

	public int nthSuperUglyNumber(int n, int[] primes) {
		int[] count=new int[primes.length];
		int[] next=new int[primes.length];
		int[] ugly=new int[n];
		Arrays.fill(next,1);
		for(int i=0; i<n; i++){
		    int tmp=Integer.MAX_VALUE;
		    for(int j : next)
		    	tmp=Math.min(tmp, j);
		    ugly[i]=tmp;
		    for(int j=0; j<primes.length; j++){
		        if(tmp==next[j]){
		        	next[j]=primes[j]*(ugly[count[j]]);
		        	count[j]++;
		        }
		    }
		}
		return ugly[n-1];
    }
}

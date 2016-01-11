//Given an integer n, count the total number of digit 1 appearing in all non-negative integers less than or equal to n.
//For example:
//Given n = 13,
//Return 6, because digit 1 occurred in the following numbers: 1, 10, 11, 12, 13.

/*The idea is to calculate occurrence of 1 on every digit. There are 3 scenarios, for example
if n = xyzdabc
and we are considering the occurrence of one on thousand, it should be:
(1) xyz * 1000                     if d == 0
(2) xyz * 1000 + abc + 1           if d == 1
(3) xyz * 1000 + 1000              if d > 1
iterate through all digits and sum them all will give the final answer*/

public class NumberofDigitOne {
	public int countDigitOne(int n) {
		if (n<=0) return 0;
	    int q=n, x=1, res=0;
	    do {
	        int digit=q%10;
	        q/=10;
	        res+=q*x;
	        if (digit==1) 
	        	res+=n%x+1;
	        if (digit>1) 
	        	res+=x;
	        x*=10;
	    } while (q>0);
	    return res;
    }
}

//Count the number of k's between 0 and n. k can be 0 - 9.
//Example
//if n=12, in [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12], we have FIVE 1's (1, 10, 11, 12)

public class DigitCounts {
	/*
     * param k : As description.
     * param n : As description.
     * return: An integer denote the count of digit k in 1..n
     */
	public int digitCounts(int k, int n) {
        int base=1;
        int res=0;
        while(base <= n){
        	// caculate how many k's <(n/(base*10))*(base*10) at pos base
        	int a=n/(base*10);
        	if(base>1 && k==0 && a>0)
        		a--;
        	a*=base;
        	//caculate how many k's >=(n/(base*10))*(base*10) at pos base
        	int digit=(n/base)%10;
        	int b=0;
        	if(k<digit)
        		b=base;
        	if(k==digit)
        		b=n%base+1;
        	if(n<base*10 && k==0)
        		b=0;
        	res+=a+b;
        	base*=10;
        }
        return res;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

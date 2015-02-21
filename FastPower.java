//Calculate the a^n % b where a, b and n are all 32bit integers.
//Example
//For 2^31 % 3 = 2
//For 100^1000 % 1000 = 0

//(a*b)%x = ((a%x) * (b%x)) %x

public class FastPower {

	public int fastPower(int a, int b, int n) {
        if(a==0) return 0;
        if(n==0) return 1%b;
        if(n==1) return a%b;
        long res=0;
    	res=fastPower(a, b, n/2);
    	res*=res;
    	res%=b;
        if((n%2)==1)
        	res = (res * a) % b;
        return (int)res;
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

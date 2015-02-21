// nth fibonacci number with O(1) space complexity
// 4th fibonacci number - 2
// 0,1,1,2,3,5,8

public class FibonacciNumber {
	
	public int getFibo(int n) {
	    if(n==0) return 0;
	    if(n==1) return 1;
	    int p=1, pp=0, newnum=0;
	    for(int i=2;i<=n;i++){
	        newnum=pp+p;
	        pp=p;
	        p=newnum;
	    }
	    return newnum;
	}
	
	public static void main(String[] args) {

	}
}

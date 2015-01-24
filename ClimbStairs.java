
public class ClimbStairs {

	public static int climbStairs(int n) {
        if (n==0){
        	return 0;
        }
        else{
        	if (n==1){
        		return 1;
        	}
        	else{
        		int[] a=new int[n];
        		a[0]=1;
        		a[1]=2;
        		if (n>=3){
        			for (int i=2;i<n;i++){
        				a[i]=a[i-1]+a[i-2];
        			}
        		}
        		return a[n-1];
        	}
        }
    }
	
	public static void main(String[] args) {
		int n=5;
		System.out.println(climbStairs(n));

	}

}

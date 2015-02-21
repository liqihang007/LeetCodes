//Implement int sqrt(int x).

public class Sqrt { // (x_i - x_i＋1) * f'(x_i) = f(x_i)
	public class Solution {
	    public int sqrt(int x) {
	        if(x==1 || x==0){
	            return x;
	        }
	        else{
			    int n=10;
	            double k=(double)x;
	            double p=k*2;
	            for (int i=0;i<n;i++){
	                p=(p+k/p)*0.5;
	            }
	            if(p<0){p=-p;}
	            return (int)p;
	        }
	    }
	}	
	
	public static void main(String[] args) {
		int x=2142414199;
        System.out.println(sqrt(x));
	}

}

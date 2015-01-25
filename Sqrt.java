//Implement int sqrt(int x).

public class Sqrt {
	public class Solution {
	    public int sqrt(int x) {
	        if(x==1 || x==0){
	            return x;
	        }
	        else{
			    int n=Integer.toString(x).length()*2;
	            double k=(double)x;
	            double p=k*2;
	            for (int i=0;i<n*2;i++){
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

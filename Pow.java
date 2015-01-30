//Implement pow(x, n).

public class Pow {
	
	public static double pow(double x, int n) { // binary search 
		double res;
		if(n==0){return 1;}
		if(n<0){
			n=-n;
			x=1/x;
		}
		if(n==1){res=x;}
		if(n%2==0){
			res=pow(x*x,n/2);
		}
		else{
			res=x*pow(x,n-1);
		}
        return res;
    }
	
	public static void main(String[] args) {
		double x=4.70975;
		int n=-6;
		System.out.println((float)pow(x,n));
		System.out.println((float)Math.pow(x,n));
	}
}

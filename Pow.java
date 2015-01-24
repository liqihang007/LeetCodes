
public class Pow {
	
	public static double pow(double x, int n) {
		double myreturn;
		if(n==0){
			myreturn=1;
		}
		else{
			if(n<0){
				n=-n;
				x=1/x;
			}
			if(n==1){
				myreturn=x;
			}
			else{
				if(n==-1){
					myreturn=1/x;
				}
				else{
					if(n==2){
						myreturn=x*x;
					}
					else{
						if(n%2==0){
							myreturn=pow(x*x,(int)(n/2));
						}
						else{
							myreturn=x*pow(x,n-1);
						}
					}
				}
			}
		}
        return myreturn;
    }
	
	public static void main(String[] args) {
		double x=4.70975;
		int n=-6;
		System.out.println((float)pow(x,n));
		System.out.println((float)Math.pow(x,n));
	}
}

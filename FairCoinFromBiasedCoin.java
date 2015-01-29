//Let the function_A return 0 with probability 40% and 1 with probability 60%. 
//Generate a function_B with probabilities 50-50 using only function_A only.

public class FairCoinFromBiasedCoin {

	public boolean function_A(){
		double x=Math.random();
		if(x>0.6){return true;}
		return false;
	}
	
	public boolean fairCoinFromBiasedCoin(){
		boolean r1,r2;
		do{
			r1=function_A();
			r2=function_A();
		}while(r1==r2);
		return (r1);
	}
	
	public static void main(String[] args) {
		
	}
}

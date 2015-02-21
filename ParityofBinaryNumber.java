//Check the parity of a given binary number. Parity is total no of ones in a binary number.
//1110 , output = 3

public class ParityofBinaryNumber {

	public int biones(int x){
	    int res=0;
	    while(x!=0){
	        if((x^1)==1)
	            res++;
	        x=x>>1;
	    }
	    return res;
	}
	
	public static void main(String[] args) {

	}
}

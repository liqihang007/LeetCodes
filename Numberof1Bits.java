//Write a function that takes an unsigned integer and returns the number of '1' bits it has (also known as the Hamming weight).
//For example, the 32-bit integer '11' has binary representation 00000000000000000000000000001011, so the function should return 3.

public class Numberof1Bits {
	
	public static int hammingWeight(int n) {
        int res=0;
        while(n!=0){
            res++;
            n=n&(n-1);
        }
        return res;
    }
	
	public static void main(String[] args) {
		System.out.println(hammingWeight(2147648));
	}

}

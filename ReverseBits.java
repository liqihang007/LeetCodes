//Reverse bits of a given 32 bits unsigned integer.
//For example, given input 43261596 (represented in binary as 00000010100101000001111010011100), 
//return 964176192 (represented in binary as 00111001011110000010100101000000).

public class ReverseBits {

	public int reverseBits(int n) {
		int temp=0;
        int res=0;
        int a[]=new int[32];
        for(int i=0; i<32; i++){
            temp=n%2; // the first bit
            n=n>>>1;
            temp=(temp)<<(31-i);
            res+=temp;
        }
        return res;
    }

	public static void main(String[] args) {

	}

}
